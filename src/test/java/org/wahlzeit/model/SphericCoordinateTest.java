package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void isEqualsShouldReturnTrue(){
        Coordinate one = new SphericCoordinate(2.454, 2.565, 7.24);
        Coordinate two = new SphericCoordinate(2.454, 2.565, 7.24);
        assertEquals(one.isEqual(two), true);
    }

}