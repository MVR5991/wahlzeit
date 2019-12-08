package org.wahlzeit.model;

public class Site {

    /**
     * Enum type for the type of a train.
     */
    enum Continent {
        Asian, European, American, African, Australian, Unknown;
    }

    public Site(){
        this.continent = Continent.Unknown;
    }

    public Site(Continent continent) {
        this.continent = continent;
    }

    private Continent continent;

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        if(continent == null) throw new IllegalArgumentException("No Continent specified");
        this.continent = continent;
    }
}
