package vin.io.resources;

import org.jongo.MongoCollection;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import restx.security.PermitAll;
import vin.io.domain.WineBottle;

import javax.inject.Named;

@Component
@RestxResource
public class WineBottlesResource {

    private final JongoCollection bottles;

    public WineBottlesResource(@Named("bottles") JongoCollection bottles) {
        this.bottles = bottles;
    }

    @GET("/bottles")
    @PermitAll
    public Iterable<WineBottle> getAllBottles() {
        return bottles.get().find().as(WineBottle.class);
    }

    @POST("/bottles")
    @PermitAll
    public Iterable<WineBottle> addBottle(WineBottle bottle) {

        MongoCollection bottles = this.bottles.get();

        bottles.insert(bottle);

        return bottles.find().as(WineBottle.class);
    }

}
