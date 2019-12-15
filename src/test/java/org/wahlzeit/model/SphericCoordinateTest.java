package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void isEqualsShouldReturnTrue(){
        Coordinate one = SphericCoordinate.createOrGetSphericCoordinate(2.454, 2.565, 7.24);
        Coordinate two = SphericCoordinate.createOrGetSphericCoordinate(2.454, 2.565, 7.24);
        assertEquals(one.isEqual(two), true);
    }

    @Test
    public void isEqualsShouldReturnFalse(){
        Coordinate one = SphericCoordinate.createOrGetSphericCoordinate(2.454, 2.565, 7.24);
        Coordinate two = SphericCoordinate.createOrGetSphericCoordinate(2.4554, 2.565, 7.24);
        assertEquals(one.isEqual(two), false);
    }

    @Test
    public void isEqualsWithCartesianCoordinateShouldBeTrue(){
        Coordinate one = SphericCoordinate.createOrGetSphericCoordinate(2.454, 2.565, 7.24);
        Coordinate two = SphericCoordinate.createOrGetSphericCoordinate(2.454, 2.565, 7.24);
        assertEquals(one.isEqual(two.asCartesianCoordinate()), true);
    }

}