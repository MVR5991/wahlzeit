package org.wahlzeit.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CartesianCoordinate implements Coordinate {

    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate cartCoordiante = coordinate.asCartesianCoordinate();
        return Math.sqrt((this.x - cartCoordiante.getX()) + (this.y - cartCoordiante.getY())+ (this.z - cartCoordiante.getZ()));
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate);
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        return this.equals(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return doAsSphericCoordinate();
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
        return compareDouble(this.getX(), that.getX()) == 0 &&
                compareDouble(this.getY(), that.getY()) == 0 &&
                compareDouble(this.getZ(), that.getZ()) == 0;
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

    protected SphericCoordinate doAsSphericCoordinate() {
        double a = Math.toDegrees(Math.atan2(this.getY(), this.getX()));
        double rad = Math.sqrt(Math.pow(this.getZ(), 2) + Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
        double p = Math.toDegrees(Math.acos(this.getZ() / rad));
        return new SphericCoordinate(p, a, rad);
    }

    private static int compareDouble(double x, double y) {
        return new BigDecimal(x).compareTo(new BigDecimal(y));
    }
}
