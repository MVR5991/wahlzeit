package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    private static Map<Integer, CartesianCoordinate> knownCoordinates = new HashMap<Integer, CartesianCoordinate>();

    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static CartesianCoordinate createOrGetCartesianCoordinate(double x, double y, double z){
        AbstractCoordinate.assertDoubleValueisValid(x);
        AbstractCoordinate.assertDoubleValueisValid(y);
        AbstractCoordinate.assertDoubleValueisValid(z);

        int hash = Objects.hash(x,y,z);

        if(knownCoordinates.containsKey(hash)){
            return knownCoordinates.get(hash);
        } else{
            knownCoordinates.put(hash,new CartesianCoordinate(x,y,z));
            return knownCoordinates.get(hash);
        }

    }

    @Override
    protected SphericCoordinate doAsSphericCoordinate() {
        double a = Math.toDegrees(Math.atan2(this.getY(), this.getX()));
        double rad = Math.sqrt(Math.pow(this.getZ(), 2) + Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
        double p = Math.toDegrees(Math.acos(this.getZ() / rad));
        return SphericCoordinate.createOrGetSphericCoordinate(p, a, rad);
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

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

}
