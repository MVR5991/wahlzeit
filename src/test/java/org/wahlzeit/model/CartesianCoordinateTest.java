package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    @Test
    public void isEqualsShouldReturnTrue(){
        Coordinate one = new CartesianCoordinate(2.454, 2.565, 7.24);
        Coordinate two = new CartesianCoordinate(2.454, 2.565, 7.24);
        assertEquals(one.isEqual(two), true);
    }

}