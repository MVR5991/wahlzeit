package org.wahlzeit.model;

import java.math.BigDecimal;

public abstract class AbstractCoordinate implements Coordinate {

    /**
     * Maring for double comparisions
     */
    final static double EPSILON = 10E-8;

    /**
     * @param coordinate
     * @return the cartesian distance between two coordinates
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        try {
            return doGetCartesianDistance(coordinate);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new IllegalCoordinateException(String.format(":::getCartesianDistance could not be performed with given parameter %s", coordinate.toString()));
        }
    }

    /**
     * @param coordinate
     * @return the central angle of these coordinates
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        try {
            return doGetCentralAngle(coordinate);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new IllegalCoordinateException(String.format(":::getCentralAngle could not be performed with given parameter %s", coordinate.toString()));
        }
    }

    /**
     * @param coordinate
     * @return assertion if both coordinate are representing the same
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        try {
            return doIsEqual(coordinate);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new IllegalCoordinateException(String.format(":::isEqual could not be performed with given parameter %s", coordinate.toString()));
        }
    }

    /**
     * @return transforms the coordinate into a CartesianCoordinate
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    /**
     * @return transforms the coordinate into a SphericCoordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return doAsSphericCoordinate();
    }

    protected abstract CartesianCoordinate doAsCartesianCoordinate();

    protected boolean doIsEqual(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException {
        assertCoordinateIsNotNull(coordinate);
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate thatCoordinate = coordinate.asCartesianCoordinate();
        asserClassInvariants(thatCoordinate);
        if (thisCoordinate == thatCoordinate) return true;
        if (thisCoordinate == null || getClass() != thatCoordinate.getClass()) return false;
        return compareDouble(thisCoordinate.getX(), thatCoordinate.getX()) &&
                compareDouble(thisCoordinate.getY(), thatCoordinate.getY()) &&
                compareDouble(thisCoordinate.getZ(), thatCoordinate.getZ());
    }

    protected double doGetCartesianDistance(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException  {
        assertCoordinateIsNotNull(coordinate);
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate thatCoordinate = coordinate.asCartesianCoordinate();
        asserClassInvariants(thatCoordinate);
        return Math.sqrt((thisCoordinate.getX() - thatCoordinate.getX()) +
                (thisCoordinate.getY() - thatCoordinate.getY()) +
                (thisCoordinate.getZ() - thatCoordinate.getZ()));
    }

    protected double doGetCentralAngle(Coordinate coordinate) throws IllegalArgumentException {
        assertCoordinateIsNotNull(coordinate);
        CartesianCoordinate cartCoordinate = this.asCartesianCoordinate();
        double cartesianSubtraction = cartCoordinate.getCartesianDistance(coordinate);
        return Math.asin(cartesianSubtraction / 2) * 2;
    }

    protected abstract SphericCoordinate doAsSphericCoordinate();

    private static boolean compareDouble(double x, double y) throws IllegalArgumentException {
        assertDoubleValueisValid(x);
        assertDoubleValueisValid(y);
        return Math.abs(x -y) < AbstractCoordinate.EPSILON;
    }

    public static void assertCoordinateIsNotNull(Coordinate coordinate) throws IllegalArgumentException {
        if (coordinate == null) {
            throw new IllegalArgumentException(String.format(":::given coordinate is null"));
        }
    }

    public static void assertDoubleValueisValid(double val) throws IllegalArgumentException {
        if (!Double.isFinite(val)) {
            throw new IllegalArgumentException(String.format(":::given double value is not valid %s", val));
        }
    }

    protected abstract void assertClassInVariant() throws IllegalStateException;

    private void asserClassInvariants(AbstractCoordinate coordinate) throws IllegalStateException{
        this.assertClassInVariant();
        coordinate.assertClassInVariant();

    }
}
