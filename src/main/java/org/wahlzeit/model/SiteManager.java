package org.wahlzeit.model;

import java.util.HashMap;

public class SiteManager {

    private HashMap<Integer, Site> allSites = new HashMap<>();
    private HashMap<Integer, SiteType> allTypes = new HashMap<>();

    private static SiteManager managerInstance;

    public static SiteManager getInstance(){
        if(managerInstance == null){
            managerInstance = new SiteManager();
        }
        return managerInstance;
    }

    public SiteType getSiteType(String county){
        SiteType type = new SiteType(county);
        if(allTypes.containsKey(type.hashCode())){
            return allTypes.get(type.hashCode());
        }
        allTypes.put(type.hashCode(), type);
        return type;
    }

    public Site getSite(SiteType type, Site.Continent continent) {
        Site site = new Site(type, continent);
        if (allSites.containsKey(site.hashCode())) {
            return allSites.get(site.hashCode());
        }
        return null;
    }

    public Site createSite(String country, Site.Continent continent) {
        SiteType type = getSiteType(country);
        Site site= type.createInstance(continent);
        allSites.put(site.hashCode(), site);
        allTypes.put(type.hashCode(), type);
        return site;
    }
}
