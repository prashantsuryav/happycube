package com.threesixty.cube.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.threesixty.cube.model.CubePieces;
import com.threesixty.cube.model.Piece;
import com.threesixty.cube.model.Tuple;
import com.threesixty.cube.validate.CubeValidator;

public class CubePieceGenerator {

    private static final Logger LOGGER = Logger.getLogger(CubePieceGenerator.class.getName());
    private static final CubeValidator cubeValidator = new CubeValidator();

    /**
     * Finds valid combination of cube piece from the given cube piece
     *
     * @param cubePieces
     * @return valid cube piece
     */
    public CubePieces getValidCubePieces(final CubePieces cubePieces) {
        TuplesGenerator tuplesGenerator = new TuplesGenerator();
        final List<Tuple> allPossibleTuples = tuplesGenerator.generateTuples();

        for (Tuple tuple : allPossibleTuples) {
            List<Piece> pieces = new ArrayList<>();
            final String positionOfPieces = tuple.getPositionOfPieces();
            final String orientationOfPieces = tuple.getOrientationOfPieces();

            pieces.add(0, cubePieces.getPiece(0));
            pieces.add(1, getModifiedPiece(cubePieces.getPiece(Integer.parseInt(String.valueOf(positionOfPieces.charAt(0))))
                    , orientationOfPieces.charAt(0)));
            pieces.add(2, getModifiedPiece(cubePieces.getPiece(Integer.parseInt(String.valueOf(positionOfPieces.charAt(1))))
                    , orientationOfPieces.charAt(1)));
            pieces.add(3, getModifiedPiece(cubePieces.getPiece(Integer.parseInt(String.valueOf(positionOfPieces.charAt(2))))
                    , orientationOfPieces.charAt(2)));
            pieces.add(4, getModifiedPiece(cubePieces.getPiece(Integer.parseInt(String.valueOf(positionOfPieces.charAt(3))))
                    , orientationOfPieces.charAt(3)));
            pieces.add(5, getModifiedPiece(cubePieces.getPiece(Integer.parseInt(String.valueOf(positionOfPieces.charAt(4))))
                    , orientationOfPieces.charAt(4)));

            CubePieces obtainedCubePiece = new CubePieces(pieces);

            final CubePieces myValidCombination = cubeValidator.getValidCombination(Collections.singletonList(obtainedCubePiece));
            if (myValidCombination != null) {
                LOGGER.info("Solution found for the cube");
                return myValidCombination;
            }

        }

        return null;

    }

    /**
     * Modifies the piece according to its orientation type
     *
     * @param piece
     * @param orientationType
     * @return modified piece
     */
    private Piece getModifiedPiece(final Piece piece,
            final char orientationType) {

        if (orientationType == '1') {
            piece.rotatePiece();
        }
        else if (orientationType == '2') {
            piece.rotatePiece();
            piece.rotatePiece();
        }
        else if (orientationType == '3') {
            piece.rotatePiece();
            piece.rotatePiece();
            piece.rotatePiece();
        }
        else if (orientationType == '4') {
            piece.flipPiece();
        }
        else if (orientationType == '5') {
            piece.flipPiece();
            piece.rotatePiece();
        }
        else if (orientationType == '6') {
            piece.flipPiece();
            piece.rotatePiece();
            piece.rotatePiece();
        }
        else if (orientationType == '7') {
            piece.flipPiece();
            piece.rotatePiece();
            piece.rotatePiece();
            piece.rotatePiece();
        }

        return piece;
    }

}
