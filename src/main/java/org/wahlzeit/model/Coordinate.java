package org.wahlzeit.model;

import java.math.BigDecimal;

public interface Coordinate {

     CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException;

     double getCartesianDistance(Coordinate coordinate) throws IllegalCoordinateException;

     double getCentralAngle(Coordinate coordinate) throws IllegalCoordinateException;

     boolean isEqual(Coordinate coordinate) throws IllegalCoordinateException;

    SphericCoordinate asSphericCoordinate() throws IllegalCoordinateException;

}
