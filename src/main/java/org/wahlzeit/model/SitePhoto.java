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

    public SitePhoto(String country, Site.Continent continent, PhotoId myId) {
        super(myId);
        this.site = SiteManager.getInstance().createSite(country, continent);
    }

    public SitePhoto(String country, Site.Continent continent) {
        super(PhotoId.getNextId());
        this.site = SiteManager.getInstance().createSite(country, continent);
    }


    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        if(site == null) throw new IllegalArgumentException("no site specified");
        this.site = site;
    }
}
