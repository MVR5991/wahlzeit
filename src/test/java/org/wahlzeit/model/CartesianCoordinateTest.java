package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    @Test
    public void isEqualsShouldReturnTrue(){
        Coordinate one = CartesianCoordinate.createOrGetCartesianCoordinate(2.454, 2.565, 7.24);
        Coordinate two = CartesianCoordinate.createOrGetCartesianCoordinate(2.454, 2.565, 7.24);
        assertEquals(one.isEqual(two), true);
    }

    @Test
    public void isEqualsShouldFalseTrue(){
        Coordinate one = CartesianCoordinate.createOrGetCartesianCoordinate(2.454, 2.565, 7.24);
        Coordinate two = CartesianCoordinate.createOrGetCartesianCoordinate(2.454, 2, 7.24);
        assertEquals(one.isEqual(two), false);
    }

    @Test
    public void comparisonWithSphericCoordinateShouldBeTrue(){
        Coordinate one = CartesianCoordinate.createOrGetCartesianCoordinate(2.454, 2.565, 7.24);
        Coordinate two = CartesianCoordinate.createOrGetCartesianCoordinate(2.454, 2.565, 7.24);
        assertEquals(one.isEqual(two.asSphericCoordinate()), true);
    }
}