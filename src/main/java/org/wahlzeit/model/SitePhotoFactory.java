package org.wahlzeit.model;

public class SitePhotoFactory extends PhotoFactory {

    public SitePhoto createPhoto() {
        return new SitePhoto();
    }


    public SitePhoto createPhoto(PhotoId id) {
        return new SitePhoto(id);
    }

    public SitePhoto createPhoto(String country, Site.Continent continent) {
        return new SitePhoto(country, continent);
    }

    public SitePhoto loadPhoto(PhotoId id) {
        return null;
    }
}
