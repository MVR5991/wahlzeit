package org.wahlzeit.model;

import java.math.BigDecimal;

public abstract class AbstractCoordinate implements Coordinate {

    /**
     *
     * @param coordinate
     * @return the cartesian distance between two coordinates
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return doGetCartesianDistance(coordinate);
    }

    /**
     *
     * @param coordinate
     * @return the central angle of these coordinates
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return doGetCentralAngle(coordinate);
    }

    /**
     *
     * @param coordinate
     * @return assertion if both coordinate are representing the same
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        return doIsEqual(coordinate);
    }

    /**
     *
     * @return transforms the coordinate into a CartesianCoordinate
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate(){
        return doAsCartesianCoordinate();
    }

    /**
     *
     * @return transforms the coordinate into a SphericCoordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return doAsSphericCoordinate();
    }

    protected abstract CartesianCoordinate doAsCartesianCoordinate();

    protected boolean doIsEqual(Coordinate coordinate) {
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate thatCoordinate = coordinate.asCartesianCoordinate();
        if (thisCoordinate == thatCoordinate) return true;
        if (thisCoordinate == null || getClass() != thatCoordinate.getClass()) return false;
        return compareDouble(thisCoordinate.getX(), thatCoordinate.getX()) == 0 &&
                compareDouble(thisCoordinate.getY(), thatCoordinate.getY()) == 0 &&
                compareDouble(thisCoordinate.getZ(), thatCoordinate.getZ()) == 0;
    }

    protected double doGetCartesianDistance(Coordinate coordinate){
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartCoordiante = coordinate.asCartesianCoordinate();
        return Math.sqrt((thisCoordinate.getX() - cartCoordiante.getX()) +
                (thisCoordinate.getY() - cartCoordiante.getY()) +
                (thisCoordinate.getZ() - cartCoordiante.getZ()));
    }

    protected double doGetCentralAngle(Coordinate coordinate) {
        CartesianCoordinate cartCoordinate = this.asCartesianCoordinate();
        double cartesianSubtraction = cartCoordinate.getCartesianDistance(coordinate);
        return Math.asin(cartesianSubtraction / 2) * 2;
    }

    protected abstract SphericCoordinate doAsSphericCoordinate();

    private static int compareDouble(double x, double y) {
        return new BigDecimal(x).compareTo(new BigDecimal(y));
    }
}
