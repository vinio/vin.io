package vin.io.resources;

import com.google.common.base.Optional;
import com.google.common.io.ByteStreams;
import com.google.common.net.HttpHeaders;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.types.ObjectId;
import restx.*;
import restx.factory.Component;
import restx.http.HttpStatus;
import restx.jongo.JongoCollection;

import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;

@Component
public class PicturesRoute extends StdRoute {

    public static final String FILES_COLLECTION_NAME = "files";
    private GridFS gridFS;

    public PicturesRoute(@Named("bottles") JongoCollection pictures) {
        super("download", new StdRestxRequestMatcher("GET", "/download/{name}"));
        this.gridFS = new GridFS(pictures.get().getDBCollection().getDB(), FILES_COLLECTION_NAME);
    }

    @Override
    public void handle(RestxRequestMatch match, RestxRequest req, RestxResponse resp, RestxContext ctx) throws IOException {

        final String fileName = match.getPathParams().get("name");

        final GridFSDBFile gridFSDBFile = gridFS.findOne(fileName);

        if (gridFSDBFile == null) {
            resp.setStatus(HttpStatus.NOT_FOUND);
            return;
        }

        resp.setStatus(HttpStatus.OK);
        resp.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + gridFSDBFile.getFilename() + "\"");
        resp.setContentType(Optional.fromNullable(gridFSDBFile.getContentType()).or("application/octet-stream"));

        try (InputStream inputStream = gridFSDBFile.getInputStream()) {
            ByteStreams.copy(inputStream, resp.getOutputStream());
        }
    }
}
