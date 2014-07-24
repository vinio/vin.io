package vin.io.domain;

public class WineBottle {

    private String domain;

    private int vintage;

    private String description;

    public String getDomain() {
        return domain;
    }

    public int getVintage() {
        return vintage;
    }

    public String getDescription() {
        return description;
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

    @Override
    public String toString() {
        return "WineBottle{" +
                "domain='" + domain + '\'' +
                ", vintage=" + vintage +
                ", description='" + description + '\'' +
                '}';
    }
}
