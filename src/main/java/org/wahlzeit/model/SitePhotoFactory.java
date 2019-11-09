package org.wahlzeit.model;

public class SitePhotoFactory extends PhotoFactory {

    public SitePhoto createPhoto() {
        return new SitePhoto();
    }


    public SitePhoto createPhoto(PhotoId id) {
        return new SitePhoto(id);
    }

    public SitePhoto createPhoto(SitePhoto.Continent continent) {
        return new SitePhoto(continent);
    }

    public SitePhoto loadPhoto(PhotoId id) {
        return null;
    }
}
