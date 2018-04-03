package com.threesixty.cube.generate;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionGeneratorTest {

    private static final int NUMBER_OF_PERMUTATIONS = 120;

    @Test
    void given_PositionGenerator_ShouldGenerateAllPossiblePermutations() {
        PositionGenerator positionGenerator = new PositionGenerator();
        final List<String> allPermutations = positionGenerator.allPermutations("12345");

        assertTrue(allPermutations.contains("54321"));
        assertEquals(NUMBER_OF_PERMUTATIONS, allPermutations.size());
    }

}