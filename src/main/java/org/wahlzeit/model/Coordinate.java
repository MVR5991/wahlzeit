package org.wahlzeit.model;

import java.math.BigDecimal;

public interface Coordinate {

     CartesianCoordinate asCartesianCoordinate();

     double getCartesianDistance(Coordinate coordinate);

     double getCentralAngle(Coordinate coordinate);

     boolean isEqual(Coordinate coordinate);

    SphericCoordinate asSphericCoordinate();

}
