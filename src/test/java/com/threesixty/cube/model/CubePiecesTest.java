package com.threesixty.cube.model;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static com.threesixty.cube.utils.CubeUtils.createCubePieces;
import static com.threesixty.cube.utils.CubeUtils.getInputResourceAsStream;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CubePiecesTest {

    private static final String BLUE_CUBE_INPUT = "blue-cube.txt";
    private static final String EXPECTED_STRING = "xxoxx";

    @Test
    void given_CubePieces_When_getPiece_ShouldReturnPiece() throws IOException {

        final String cubeString = getInputResourceAsStream(BLUE_CUBE_INPUT);
        final CubePieces cubePieces = createCubePieces(cubeString);

        final Piece piece0 = cubePieces.getPiece(0);

        assertNotNull(piece0);
        assertEquals(EXPECTED_STRING, valueOf(piece0.getMat()[0]));
    }

}