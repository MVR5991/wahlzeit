package org.wahlzeit.model;

public class Location {

    private Coordinate coordinates;

    public Location(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }
}
