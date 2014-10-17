package vin.io.domain;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

/**
 * Date: 17/10/14
 * Time: 11:17
 */
public class WineBottle {
    @ObjectId
    @Id
    private String key;

    private String domain;

    private int vintage;

    private Color color;

    private String description;

    private String picture;

    private long price;




    public String getKey() {
        return key;
    }

    public String getDomain() {
        return domain;
    }

    public int getVintage() {
        return vintage;
    }

    public Color getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public long getPrice() {
        return price;
    }

    public WineBottle setKey(final String key) {
        this.key = key;
        return this;
    }

    public WineBottle setDomain(final String domain) {
        this.domain = domain;
        return this;
    }

    public WineBottle setVintage(final int vintage) {
        this.vintage = vintage;
        return this;
    }

    public WineBottle setColor(final Color color) {
        this.color = color;
        return this;
    }

    public WineBottle setDescription(final String description) {
        this.description = description;
        return this;
    }

    public WineBottle setPicture(final String picture) {
        this.picture = picture;
        return this;
    }

    public WineBottle setPrice(final long price) {
        this.price = price;
        return this;
    }


}
