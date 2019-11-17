package org.wahlzeit.model;

import java.math.BigDecimal;
import java.util.Objects;

public class SphericCoordinate implements Coordinate {

    private double p;
    private double a;
    private double rad;

    public SphericCoordinate(double p, double a, double rad) {
        this.p = p;
        this.a = a;
        this.rad = rad;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, a, rad);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
       return doGetCentralAngle(coordinate);
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        return this.equals(coordinate.asSphericCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphericCoordinate that = (SphericCoordinate) o;

        return compareDouble(this.getA(), that.getA()) == 0 &&
                compareDouble(this.getP(), that.getP()) == 0 &&
                compareDouble(this.getRad(), that.getRad()) == 0;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getRad() {
        return rad;
    }

    public void setRad(double rad) {
        this.rad = rad;
    }

    protected double doGetCentralAngle(Coordinate coordinate){
        CartesianCoordinate cartCoordinate = this.asCartesianCoordinate();
        double cartesianSubtraction = cartCoordinate.getCartesianDistance(coordinate);
        return Math.asin(cartesianSubtraction / 2) * 2;
    }

    protected CartesianCoordinate doAsCartesianCoordinate(){
        double z = this.getRad() * Math.cos(Math.toRadians(this.getP()));
        double y = this.getRad() * Math.sin(Math.toRadians(this.getP())) * Math.sin(Math.toRadians(this.getA()));
        double x = this.getRad() * Math.sin(Math.toRadians(this.getP())) * Math.cos(Math.toRadians(this.getA()));
        return new CartesianCoordinate(x, y, z);
    }

    private static int compareDouble(double x, double y){
        return new BigDecimal(x).compareTo(new BigDecimal(y));
    }
}
