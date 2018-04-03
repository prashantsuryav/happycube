package com.threesixty.cube.model;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.threesixty.cube.utils.CubeUtils.createCubePieces;
import static com.threesixty.cube.utils.CubeUtils.getInputResourceAsStream;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTest {

    private static final String BLUE_CUBE_INPUT = "blue-cube.txt";
    private static final String EXPECTED_TOP_EDGE = "xox";
    private static final String EXPECTED_BOTTOM_EDGE = "xox";
    private static final String EXPECTED_LEFT_EDGE = "xox";
    private static final String EXPECTED_RIGHT_EDGE = "xox";

    private static final String EXPECTED_LEFT_TOP_CORNER = "x";
    private static final String EXPECTED_LEFT_BOTTOM_CORNER = "x";
    private static final String EXPECTED_RIGHT_TOP_CORNER = "x";
    private static final String EXPECTED_RIGHT_BOTTOM_CORNER = "x";

    private static Piece piece;

    @BeforeAll
    static void setup() throws IOException {
        final String cubeString = getInputResourceAsStream(BLUE_CUBE_INPUT);
        final CubePieces cubePieces = createCubePieces(cubeString);
        piece = cubePieces.getPiece(0);
    }

    @Test
    void given_PieceIsSet_whenGetTopEdge_shouldReturnTopEdge() {
        assertEquals(EXPECTED_TOP_EDGE, valueOf(piece.getTopEdge().getEdge()));
    }

    @Test
    void given_PieceIsSet_whenGetBottomEdge_shouldReturnBottomEdge() {
        assertEquals(EXPECTED_BOTTOM_EDGE, valueOf(piece.getBottomEdge().getEdge()));
    }

    @Test
    void given_PieceIsSet_whenGetLeftEdge_shouldReturnLeftEdge() {
        assertEquals(EXPECTED_LEFT_EDGE, valueOf(piece.getLeftEdge().getEdge()));
    }

    @Test
    void given_PieceIsSet_whenGetRightEdge_shouldReturnRightEdge() {
        assertEquals(EXPECTED_RIGHT_EDGE, valueOf(piece.getRightEdge().getEdge()));
    }

    @Test
    void given_PieceIsSet_whenGetLeftTopCorner_shouldReturnLeftTopCorner() {
        assertEquals(EXPECTED_LEFT_TOP_CORNER, valueOf(piece.getTopLeftCorner()));
    }

    @Test
    void given_PieceIsSet_whenGetRightTopCorner_shouldReturnRightTopCorner() {
        assertEquals(EXPECTED_RIGHT_TOP_CORNER, valueOf(piece.getTopRightCorner()));
    }

    @Test
    void given_PieceIsSet_whenGetLeftBottomCorner_shouldReturnLeftBottomCorner() {
        assertEquals(EXPECTED_LEFT_BOTTOM_CORNER, valueOf(piece.getBottomLeftCorner()));
    }

    @Test
    void given_PieceIsSet_whenGetRightBottomCorner_shouldReturnRightBottomCorner() {
        assertEquals(EXPECTED_RIGHT_BOTTOM_CORNER, valueOf(piece.getBottomRightCorner()));
    }

}