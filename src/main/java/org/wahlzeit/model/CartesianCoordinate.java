package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    protected SphericCoordinate doAsSphericCoordinate() {
        double a = Math.toDegrees(Math.atan2(this.getY(), this.getX()));
        double rad = Math.sqrt(Math.pow(this.getZ(), 2) + Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
        double p = Math.toDegrees(Math.acos(this.getZ() / rad));
        return new SphericCoordinate(p, a, rad);
    }

    @Override
    protected CartesianCoordinate doAsCartesianCoordinate() {
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianCoordinate that = (CartesianCoordinate) o;
        return isEqual(that);
    }

    @Override
    protected void assertClassInVariant() throws IllegalStateException {
        try {
            AbstractCoordinate.assertDoubleValueisValid(this.getX());
            AbstractCoordinate.assertDoubleValueisValid(this.getY());
            AbstractCoordinate.assertDoubleValueisValid(this.getZ());
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(String.format(":::class invariant has been violated %s", e.getMessage()));
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
