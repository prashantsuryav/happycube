package com.threesixty.cube.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TupleTest {

    private static final String EXPECTED_POSITIONING = "12345";
    private static final String EXPECTED_ORIENTATION = "00000";

    @Test
    void given_TupleIsSet_ShouldReturnOrientationAndPositions() {
        Tuple tuple = new Tuple("12345", "00000");

        assertNotNull(tuple.getOrientationOfPieces());
        assertNotNull(tuple.getPositionOfPieces());

        assertEquals(EXPECTED_POSITIONING, tuple.getPositionOfPieces());
        assertEquals(EXPECTED_ORIENTATION, tuple.getOrientationOfPieces());

    }

}