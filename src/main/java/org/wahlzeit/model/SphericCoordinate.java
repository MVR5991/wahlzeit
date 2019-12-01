package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate{

    private double latitude;
    private double longitude;
    private double radius;

    public SphericCoordinate(double latitude, double longitude, double rad) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = rad;
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
        return new CartesianCoordinate(x, y, z);
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
