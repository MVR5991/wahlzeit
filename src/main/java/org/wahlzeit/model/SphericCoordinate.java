package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class SphericCoordinate extends AbstractCoordinate{

    private final double latitude;
    private final double longitude;
    private final double radius;

    private static Map<Integer, SphericCoordinate> knownCoordinates = new HashMap<Integer, SphericCoordinate>();

    private SphericCoordinate(double latitude, double longitude, double rad) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = rad;
    }

    public static SphericCoordinate createOrGetSphericCoordinate(double latitude, double longitude, double radius){
        AbstractCoordinate.assertDoubleValueisValid(latitude);
        AbstractCoordinate.assertDoubleValueisValid(longitude);
        AbstractCoordinate.assertDoubleValueisValid(radius);

        int hash = Objects.hash(latitude,longitude,radius);

        if(knownCoordinates.containsKey(hash)){
            return knownCoordinates.get(hash);
        } else{
            knownCoordinates.put(hash,new SphericCoordinate(latitude,longitude,radius));
            return knownCoordinates.get(hash);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphericCoordinate that = (SphericCoordinate) o;
        return isEqual(that);
    }

    @Override
    protected SphericCoordinate doAsSphericCoordinate() {
        return this;
    }

    @Override
    protected CartesianCoordinate doAsCartesianCoordinate(){
        double z = this.getRadius() * Math.cos(Math.toRadians(this.getLatitude()));
        double y = this.getRadius() * Math.sin(Math.toRadians(this.getLatitude())) * Math.sin(Math.toRadians(this.getLongitude()));
        double x = this.getRadius() * Math.sin(Math.toRadians(this.getLatitude())) * Math.cos(Math.toRadians(this.getLongitude()));
        return CartesianCoordinate.createOrGetCartesianCoordinate(x, y, z);
    }

    @Override
    protected void assertClassInVariant() throws IllegalStateException {
        try {
            AbstractCoordinate.assertDoubleValueisValid(this.getLatitude());
            AbstractCoordinate.assertDoubleValueisValid(this.getLongitude());
            AbstractCoordinate.assertDoubleValueisValid(this.getRadius());
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(String.format(":::class invariant has been violated %s", e.getMessage()));
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

}
