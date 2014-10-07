package vin.io.resources;

import com.google.common.base.Optional;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import restx.security.PermitAll;
import vin.io.domain.web.ResponseAck;
import vin.io.domain.WineBottle;

import javax.inject.Named;

@Component
@RestxResource
public class WineBottlesResource {

    private static final Logger logger = LoggerFactory.getLogger(WineBottlesResource.class);

    private final JongoCollection bottles;

    public WineBottlesResource(@Named("bottles") JongoCollection bottles) {
        this.bottles = bottles;
    }

    private void prepare(WineBottle entity) {
        if (entity.getKey() == null) {
            entity.setKey(new ObjectId().toString());
        }
    }

    @GET("/bottles")
    @PermitAll
    public Iterable<WineBottle> getAllBottles() {
        return bottles.get().find().as(WineBottle.class);
    }

    @GET("/bottles/:id")
    @PermitAll
    public Optional<WineBottle> getBottle(String id) {
        WineBottle bottle = bottles.get().findOne(new ObjectId(id)).as(WineBottle.class);
        return Optional.fromNullable(bottle);
    }

    @POST("/bottles")
    @PermitAll
    public ResponseAck<WineBottle> addBottle(WineBottle bottle) {
        MongoCollection bottles = this.bottles.get();
        prepare(bottle);
        bottles.save(bottle);
        logger.info("Bottle '{}' updated", bottle.getKey());
        return ResponseAck.success(bottle);
    }

}
