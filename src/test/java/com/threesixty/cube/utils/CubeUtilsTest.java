package com.threesixty.cube.utils;

import java.io.IOException;

import com.threesixty.cube.model.CubePieces;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.threesixty.cube.utils.CubeUtils.createCubePieces;
import static com.threesixty.cube.utils.CubeUtils.createUnfoldedVersion;
import static com.threesixty.cube.utils.CubeUtils.getInputResourceAsStream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CubeUtilsTest {

    private static final String BLUE_CUBE_INPUT = "blue-cube.txt";
    private static final String EXPECTED_CONTENT = "oxoxxoxoxxoxo";
    private static final String EXPECTED_UNFOLDED_STRING = "      oooo     ";
    private static final String ERROR_MESSAGE = "No solution found for the given pieces of cube";
    private static String cubeString;

    @BeforeAll
    static void setup() throws IOException {
        cubeString = getInputResourceAsStream(BLUE_CUBE_INPUT);
    }

    @Test
    void given_InputFileIsPresent_ShouldReturnAsStringContent() {
        assertNotNull(cubeString);
        assertTrue(cubeString.contains(EXPECTED_CONTENT));
    }

    @Test
    void given_CubePieces_ShouldReturnUnfoldedVersion() {
        final CubePieces cubePieces = createCubePieces(cubeString);
        final String unfoldedVersion = createUnfoldedVersion(cubePieces);

        assertNotNull(unfoldedVersion);
        assertTrue(unfoldedVersion.contains(EXPECTED_UNFOLDED_STRING));
    }

    @Test
    void given_CubePiecesIsNotSet_ShouldReturnMessageInUnfoldedVersion() {
        final CubePieces cubePieces = null;
        final String unfoldedVersion = createUnfoldedVersion(cubePieces);

        assertNotNull(unfoldedVersion);
        assertTrue(unfoldedVersion.contains(ERROR_MESSAGE));
    }
}