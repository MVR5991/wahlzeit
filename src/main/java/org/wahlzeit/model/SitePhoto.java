package org.wahlzeit.model;


public class SitePhoto extends Photo{

    private Continent continent;


    /**
     * Enum type for the type of a train.
     */
    enum Continent {
        Asian, European, American, African, Australian, Unknown;
    }
    public SitePhoto() {
        super(PhotoId.getNextId());
        this.continent = Continent.Unknown;
    }

    public SitePhoto(PhotoId myId) {
        super(myId);
        this.continent = Continent.Unknown;
    }

    public SitePhoto(Continent continent) {
        super();
        this.continent = continent;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        if(continent == null) throw new IllegalArgumentException("No Continent specified");
        this.continent = continent;
    }
}
