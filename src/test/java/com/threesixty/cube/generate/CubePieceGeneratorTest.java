package com.threesixty.cube.generate;

import java.io.IOException;

import com.threesixty.cube.model.CubePieces;
import org.junit.jupiter.api.Test;

import static com.threesixty.cube.utils.CubeUtils.createCubePieces;
import static com.threesixty.cube.utils.CubeUtils.getInputResourceAsStream;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CubePieceGeneratorTest {

    private static final String BLUE_CUBE_INPUT = "blue-cube.txt";
    private static final String EXPECTED_STRING = "xxoxx";

    @Test
    void given_CubePieceGenerator_ShouldGenerateAllPossiblePermutations() throws IOException {
        CubePieceGenerator cubePieceGenerator = new CubePieceGenerator();

        final String cubeString = getInputResourceAsStream(BLUE_CUBE_INPUT);
        final CubePieces cubePieces = createCubePieces(cubeString);

        final CubePieces validCubePieces = cubePieceGenerator.getValidCubePieces(cubePieces);

        assertNotNull(validCubePieces);
        assertEquals(EXPECTED_STRING, valueOf(validCubePieces.getPiece(0).getMat()[0]));

    }

}