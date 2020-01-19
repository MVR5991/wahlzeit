package org.wahlzeit.model;

public class Site {

    /**
     * Enum type for the type of a train.
     */
    enum Continent {
        Asian, European, American, African, Australian, Unknown;

    }
    private Continent continent;

    private SiteType type;

    public Site(){
        this.type = SiteType.DEFAULT;
        this.continent = Continent.Unknown;
    }

    public Site(SiteType type, Continent continent) {
        this.type = type;
        this.continent = continent;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        if(continent == null) throw new IllegalArgumentException("No Continent specified");
        this.continent = continent;
    }

    public SiteType getType() {
        return type;
    }

    public void setType(SiteType type) {
        this.type = type;
    }
}
