package com.threesixty.cube.validate;

import java.util.List;

import com.threesixty.cube.model.CubePieces;
import com.threesixty.cube.model.Edge;

public class CubeValidator {

    private static final char OCCUPIED_MARK = 'o';

    private static boolean isValidCombination(CubePieces cubePieces) {
        final boolean validEdgeResult = validateEdges(cubePieces);
        final boolean validCornerResult = validateCorners(cubePieces);
        return (validEdgeResult && validCornerResult);
    }

    private static boolean validateEdges(CubePieces cubePieces) {
        final boolean b0 =
                areEdgesComplimentary(cubePieces.getPiece(0).getLeftEdge(), cubePieces.getPiece(1).getRightEdge());
        final boolean b1 =
                areEdgesComplimentary(cubePieces.getPiece(0).getTopEdge(), cubePieces.getPiece(2).getBottomEdge());
        final boolean b2 =
                areEdgesComplimentary(cubePieces.getPiece(0).getRightEdge(), cubePieces.getPiece(3).getLeftEdge());
        final boolean b3 =
                areEdgesComplimentary(cubePieces.getPiece(0).getBottomEdge(), cubePieces.getPiece(4).getTopEdge());

        final boolean b4 =
                areEdgesComplimentary(cubePieces.getPiece(2).getRightEdge(),
                        cubePieces.getPiece(3).getTopEdge().getReverseEdge());
        final boolean b5 =
                areEdgesComplimentary(cubePieces.getPiece(4).getRightEdge(), cubePieces.getPiece(3).getBottomEdge());
        final boolean b6 =
                areEdgesComplimentary(cubePieces.getPiece(4).getLeftEdge(),
                        cubePieces.getPiece(1).getBottomEdge().getReverseEdge());
        final boolean b7 =
                areEdgesComplimentary(cubePieces.getPiece(2).getLeftEdge(), cubePieces.getPiece(1).getTopEdge());

        final boolean b8 =
                areEdgesComplimentary(cubePieces.getPiece(2).getTopEdge(), cubePieces.getPiece(5).getBottomEdge());
        final boolean b9 =
                areEdgesComplimentary(cubePieces.getPiece(5).getTopEdge(), cubePieces.getPiece(4).getBottomEdge());
        final boolean b10 =
                areEdgesComplimentary(cubePieces.getPiece(1).getLeftEdge(),
                        cubePieces.getPiece(5).getLeftEdge().getReverseEdge());
        final boolean b11 =
                areEdgesComplimentary(cubePieces.getPiece(3).getRightEdge(),
                        cubePieces.getPiece(5).getRightEdge().getReverseEdge());

        return (b0 && b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8 && b9 && b10 && b11);

    }

    private static boolean areEdgesComplimentary(Edge firstEdge, Edge secondEdge) {
        final boolean complementary0 = (firstEdge.getEdge()[0] != secondEdge.getEdge()[0]);
        final boolean complementary1 = (firstEdge.getEdge()[1] != secondEdge.getEdge()[1]);
        final boolean complementary2 = (firstEdge.getEdge()[0] != secondEdge.getEdge()[2]);
        return (complementary0 && complementary1 && complementary2);
    }

    private static boolean validateCorners(CubePieces cubePieces) {
        final boolean c1 = noCollision(cubePieces.getPiece(0).getTopLeftCorner(),
                cubePieces.getPiece(2).getBottomLeftCorner(), cubePieces.getPiece(1).getTopRightCorner());
        final boolean c2 = noCollision(cubePieces.getPiece(0).getTopRightCorner(),
                cubePieces.getPiece(2).getBottomRightCorner(), cubePieces.getPiece(3).getTopLeftCorner());
        final boolean c3 = noCollision(cubePieces.getPiece(0).getBottomRightCorner(),
                cubePieces.getPiece(3).getBottomLeftCorner(), cubePieces.getPiece(4).getTopRightCorner());
        final boolean c4 = noCollision(cubePieces.getPiece(0).getBottomLeftCorner(),
                cubePieces.getPiece(1).getBottomRightCorner(), cubePieces.getPiece(4).getTopLeftCorner());

        final boolean c5 = noCollision(cubePieces.getPiece(2).getTopRightCorner(),
                cubePieces.getPiece(5).getBottomRightCorner(), cubePieces.getPiece(3).getTopRightCorner());
        final boolean c6 = noCollision(cubePieces.getPiece(2).getTopLeftCorner(),
                cubePieces.getPiece(5).getBottomLeftCorner(), cubePieces.getPiece(1).getTopLeftCorner());
        final boolean c7 = noCollision(cubePieces.getPiece(5).getTopRightCorner(),
                cubePieces.getPiece(3).getBottomRightCorner(), cubePieces.getPiece(4).getBottomRightCorner());
        final boolean c8 = noCollision(cubePieces.getPiece(5).getTopLeftCorner(),
                cubePieces.getPiece(1).getBottomLeftCorner(), cubePieces.getPiece(4).getBottomLeftCorner());

        return (c1 && c2 && c3 && c4 && c5 && c6 && c7 && c8);
    }

    private static boolean noCollision(final char first, final char second, final char third) {
        int count = 0;

        if (first == OCCUPIED_MARK) {
            count++;
        }
        if (second == OCCUPIED_MARK) {
            count++;
        }
        if (third == OCCUPIED_MARK) {
            count++;
        }

        return count == 1;
    }

    public CubePieces getValidCombination(final List<CubePieces> allPieces) {
        for (CubePieces cubePiece : allPieces) {
            if (isValidCombination(cubePiece)) {
                return cubePiece;
            }
        }
        return null;
    }

}