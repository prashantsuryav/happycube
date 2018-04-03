package com.threesixty.cube.validate;

import java.io.IOException;
import java.util.Collections;

import com.threesixty.cube.model.CubePieces;
import org.junit.jupiter.api.Test;

import static com.threesixty.cube.utils.CubeUtils.createCubePieces;
import static com.threesixty.cube.utils.CubeUtils.getInputResourceAsStream;
import static org.junit.jupiter.api.Assertions.assertNull;

class CubeValidatorTest {

    private static final String BLUE_CUBE_INPUT = "blue-cube.txt";

    @Test
    void given_InvalidCubePieces_ShouldReturnNull() throws IOException {
        CubeValidator cubeValidator = new CubeValidator();

        final String cubeString = getInputResourceAsStream(BLUE_CUBE_INPUT);
        final CubePieces cubePieces = createCubePieces(cubeString);

        final CubePieces validCombination = cubeValidator.getValidCombination(Collections.singletonList(cubePieces));

        assertNull(validCombination);
    }

}