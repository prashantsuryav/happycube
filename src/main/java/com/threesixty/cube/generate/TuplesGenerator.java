package com.threesixty.cube.generate;

import java.util.ArrayList;
import java.util.List;

import com.threesixty.cube.model.Tuple;

import static java.lang.String.valueOf;

public class TuplesGenerator {

    private static final int NUMBER_OF_ORIENTATION_TYPES = 8;
    private static List<String> permutationsPerCubePiece = new ArrayList<>();

    private static void generateAllPermutationsPerCubePiece() {

        for (int i = 0; i < NUMBER_OF_ORIENTATION_TYPES; i++) {
            for (int j = 0; j < NUMBER_OF_ORIENTATION_TYPES; j++) {
                for (int k = 0; k < NUMBER_OF_ORIENTATION_TYPES; k++) {
                    for (int l = 0; l < NUMBER_OF_ORIENTATION_TYPES; l++) {
                        for (int m = 0; m < NUMBER_OF_ORIENTATION_TYPES; m++) {
                            permutationsPerCubePiece.add(valueOf(i) + valueOf(j) + valueOf(k) + valueOf(l) +
                                    valueOf(m));
                        }
                    }
                }
            }
        }
    }

    /**
     * Contains orientation and positioning information of cube pieces
     *
     * @return all possible tuples
     */
    public List<Tuple> generateTuples() {
        List<Tuple> allTuples = new ArrayList<>();

        PositionGenerator positionGenerator = new PositionGenerator();
        final List<String> allPositions = positionGenerator.allPermutations("12345");

        generateAllPermutationsPerCubePiece();

        for (String position : allPositions) {
            for (String orientation : permutationsPerCubePiece) {
                allTuples.add(new Tuple(position, orientation));
            }
        }

        return allTuples;

    }

}
