package com.threesixty.cube.generate;

import java.util.List;

import com.threesixty.cube.model.Tuple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TuplesGeneratorTest {

    private static final int NUMBER_OF_COMBINATIONS = 8 * 8 * 8 * 8 * 8 * 120;

    @Test
    void given_TuplesGenerator_ShouldGenerateAllPossible() {
        TuplesGenerator tuplesGenerator = new TuplesGenerator();
        final List<Tuple> tuples = tuplesGenerator.generateTuples();

        assertNotNull(tuples);
        assertEquals(NUMBER_OF_COMBINATIONS, tuples.size());
    }

}