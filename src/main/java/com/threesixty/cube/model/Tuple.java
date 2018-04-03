package com.threesixty.cube.model;

public class Tuple {

    private String positionOfPieces;
    private String orientationOfPieces;

    public Tuple(final String positionOfPieces, final String orientationOfPieces) {
        this.positionOfPieces = positionOfPieces;
        this.orientationOfPieces = orientationOfPieces;
    }

    public String getPositionOfPieces() {
        return positionOfPieces;
    }

    public String getOrientationOfPieces() {
        return orientationOfPieces;
    }

}
