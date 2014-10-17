package vin.io.resources;

import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import restx.security.PermitAll;
import vin.io.domain.WineBottle;

import javax.inject.Named;

/**
 * Date: 17/10/14
 * Time: 11:19
 */
@Component @RestxResource
@PermitAll
public class WineBottleResource {
    private JongoCollection bottles;

    public WineBottleResource(@Named("bottles") JongoCollection bottles) {
        this.bottles = bottles;
    }

    @GET("/bottles")
    public Iterable<WineBottle> findAllBottles() {
        return bottles.get().find().as(WineBottle.class);
    }

    @POST("/bottles")
    public WineBottle saveBottle(WineBottle bottle) {
        bottles.get().save(bottle);
        return bottle;
    }
}
