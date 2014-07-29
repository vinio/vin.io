package vin.io.domain;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

public class WineBottle {

    @ObjectId
    @Id
    private String key;

    private String domain;

    private int vintage;

    private String description;

    private String picture;

    public String getKey() {
        return key;
    }

    public String getDomain() {
        return domain;
    }

    public int getVintage() {
        return vintage;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public WineBottle setDomain(final String domain) {
        this.domain = domain;
        return this;
    }

    public WineBottle setVintage(final int vintage) {
        this.vintage = vintage;
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

    @Override
    public String toString() {
        return "WineBottle{" +
                "domain='" + domain + '\'' +
                ", vintage=" + vintage +
                ", description='" + description + '\'' +
                '}';
    }
}
