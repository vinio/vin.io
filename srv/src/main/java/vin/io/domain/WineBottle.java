package vin.io.domain;

public class WineBottle extends Entity {

    private String domain;

    private int vintage;

    private Color color;

    private String description;

    private String picture;

    private long price;

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

    public WineBottle setPicture(final String picture) {
        this.picture = picture;
        return this;
    }

    public WineBottle setDescription(final String description) {
        this.description = description;
        return this;
    }

    public WineBottle setColor(final Color color) {
        this.color = color;
        return this;
    }

    public WineBottle setVintage(final int vintage) {
        this.vintage = vintage;
        return this;
    }

    public WineBottle setDomain(final String domain) {
        this.domain = domain;
        return this;
    }

    public WineBottle setPrice(final long price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "WineBottle{" +
                "domain='" + domain + '\'' +
                ", vintage=" + vintage +
                ", color=" + color +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                '}';
    }
}
