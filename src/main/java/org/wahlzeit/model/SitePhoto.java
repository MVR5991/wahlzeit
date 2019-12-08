package org.wahlzeit.model;


public class SitePhoto extends Photo{

    private Site site;

    public SitePhoto() {
        super(PhotoId.getNextId());
        this.site = new Site();
    }

    public SitePhoto(PhotoId myId) {
        super(myId);
        this.site = new Site();
    }

    public SitePhoto(Site.Continent continent, PhotoId myId) {
        super(myId);
        this.site = new Site(continent);
    }

    public SitePhoto(Site.Continent continent) {
        super(PhotoId.getNextId());
        this.site = new Site(continent);
    }


    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        if(site == null) throw new IllegalArgumentException("no site specified");
        this.site = site;
    }
}
