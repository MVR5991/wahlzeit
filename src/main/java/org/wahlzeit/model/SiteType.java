package org.wahlzeit.model;

import com.sun.tools.javac.util.StringUtils;
import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SiteType extends DataObject {

    public static final SiteType DEFAULT = new SiteType("notKnown");

    private String country;

    private SiteType superType;
    private Set<SiteType> subTypes = new HashSet<>();

    public SiteType(String country) {
        this.country = country;
    }

    public Site createInstance(Site.Continent continent){
        return new Site(this, continent);
    }

    public void addSubType(SiteType subType){
        subType.addSuperType(this);
        this.subTypes.add(subType);
    }

    public void addSuperType(SiteType superType){
        this.superType = superType;
    }

    public Iterator<SiteType> getSubTypesIterator(){
        return subTypes.iterator();
    }

    public SiteType getSuperType(){
        return this.superType;
    }

    public void setCountry(String country){
        if(country == null || country.isEmpty()){
            throw new IllegalArgumentException("invalid argument for country");
        }
        this.country = country;
    }

    public String getCountry(){
        return this.country;
    }

    public boolean hasInstance(Site site){
        for(SiteType type: subTypes){
            if(type.hasInstance(site)){
                return true;
            }
        }
        return false;
    }
}
