package vin.io;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restx.factory.AutoStartable;
import restx.factory.Component;
import restx.jongo.JongoCollection;

import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class PicturesBundleInitializer implements AutoStartable {

    private static final Logger logger = LoggerFactory.getLogger(PicturesBundleInitializer.class);

    private static final String PICTURES_COLLECTION = "pictures";
    private static final List<String> PICTURES = ImmutableList.of("pictures/petrus.jpg");

    private final DB db;

    public PicturesBundleInitializer(@Named(PICTURES_COLLECTION) JongoCollection pictures) {
        this.db = pictures.get().getDBCollection().getDB();
    }

    @Override
    public void start() {

        db.dropDatabase();

        GridFS gridFS = new GridFS(db);
        for (String picture : PICTURES) {

            GridFSInputFile file;
            try {
                file = gridFS.createFile(new File(Resources.getResource(picture).getFile()));
                file.save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            logger.info("File '{}' ({}) imported into gridfs bucket", file.getFilename(), file.getId());
        }
    }
}
