package com.threesixty.cube.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.threesixty.cube.generate.CubePieceGenerator;
import com.threesixty.cube.model.CubePieces;
import com.threesixty.cube.model.Piece;

import static java.util.Arrays.asList;

public class CubeUtils {

    private static final char UNOCCUPIED_MARK = 'x';
    private static final char EMPTY = ' ';

    public static String getInputResourceAsStream(String filePath) throws IOException {
        InputStream stream = CubeUtils.class.getClassLoader().getResourceAsStream(filePath);

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String c;
            while ((c = reader.readLine()) != null) {
                stringBuilder.append(c).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    public static String createUnfoldedVersion(final CubePieces cubePieces) {
        if (cubePieces == null) {
            return "No solution found for the given pieces of cube";
        }

        char[][] full = new char[20][15];

        populateMatrix(full, 0, 10, 0, 5);
        populateMatrix(full, 0, 10, 10, 15);
        populateMatrix(full, 15, 20, 0, 5);
        populateMatrix(full, 15, 20, 10, 15);

        final char[][] piece0 = cubePieces.getPiece(0).getMat();
        final char[][] piece1 = cubePieces.getPiece(1).getMat();
        final char[][] piece2 = cubePieces.getPiece(2).getMat();
        final char[][] piece3 = cubePieces.getPiece(3).getMat();
        final char[][] piece4 = cubePieces.getPiece(4).getMat();
        final char[][] piece5 = cubePieces.getPiece(5).getMat();

        //0
        populateOccupiedEntries(full, piece0, 10, 15,
                5, 10, 10, 5);

        //1
        populateOccupiedEntries(full, piece1, 10, 15,
                0, 5, 10, 0);

        //2
        populateOccupiedEntries(full, piece2, 5, 10,
                5, 10, 5, 5);

        //3
        populateOccupiedEntries(full, piece3, 10, 15,
                10, 15, 10, 10);

        //4
        populateOccupiedEntries(full, piece4, 15, 20,
                5, 10, 15, 5);

        //5
        populateOccupiedEntries(full, piece5, 0, 5,
                5, 10, 0, 5);

        StringBuilder unfoldedVersion = new StringBuilder();
        unfoldedVersion
                .append(full[0]).append("\n")
                .append(full[1]).append("\n")
                .append(full[2]).append("\n")
                .append(full[3]).append("\n")
                .append(full[4]).append("\n")
                .append(full[5]).append("\n")
                .append(full[6]).append("\n")
                .append(full[7]).append("\n")
                .append(full[8]).append("\n")
                .append(full[9]).append("\n")
                .append(full[10]).append("\n")
                .append(full[11]).append("\n")
                .append(full[12]).append("\n")
                .append(full[13]).append("\n")
                .append(full[14]).append("\n")
                .append(full[15]).append("\n")
                .append(full[16]).append("\n")
                .append(full[17]).append("\n")
                .append(full[18]).append("\n")
                .append(full[19]);

        return unfoldedVersion.toString().replace(UNOCCUPIED_MARK, EMPTY);
    }

    private static void populateOccupiedEntries(final char[][] full, final char[][] piece, final int rowStartIndex,
            final int rowEndIndex, final int columnStartIndex, final int columnEndIndex, final int rowAdjustment,
            final int columnAdjustment) {
        for (int i = rowStartIndex; i < rowEndIndex; i++) {
            for (int j = columnStartIndex; j < columnEndIndex; j++) {
                full[i][j] = piece[i - rowAdjustment][j - columnAdjustment];
            }
        }
    }

    private static void populateMatrix(final char[][] full, final int rowStartIndex,
            final int rowEndIndex, final int columnStartIndex, final int columnEndIndex) {
        for (int i = rowStartIndex; i < rowEndIndex; i++) {
            for (int j = columnStartIndex; j < columnEndIndex; j++) {
                full[i][j] = UNOCCUPIED_MARK;
            }
        }
    }

    public static CubePieces getValidCombination(final CubePieces cubePieces) {
        CubePieceGenerator cubePieceGenerator = new CubePieceGenerator();
        return cubePieceGenerator.getValidCubePieces(cubePieces);
    }

    public static CubePieces createCubePieces(String input) {
        final String[] rows = input.split("\n");

        char[][] firstPiece = createFirstPiece(rows);
        char[][] secondPiece = createSecondPiece(rows);
        char[][] thirdPiece = createThirdPiece(rows);
        char[][] fourthPiece = createFourthPiece(rows);
        char[][] fifthPiece = createFifthPiece(rows);
        char[][] sixthPiece = createSixthPiece(rows);

        Piece piece0 = new Piece(firstPiece);
        Piece piece1 = new Piece(secondPiece);
        Piece piece2 = new Piece(thirdPiece);
        Piece piece3 = new Piece(fourthPiece);
        Piece piece4 = new Piece(fifthPiece);
        Piece piece5 = new Piece(sixthPiece);

        List<Piece> pieces = new ArrayList<>(asList(piece0, piece1, piece2, piece3, piece4, piece5));

        return new CubePieces(pieces);
    }

    private static char[][] createFirstPiece(final String[] rows) {
        char[][] firstPiece = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                firstPiece[i][j] = rows[i].charAt(j);
            }
        }
        return firstPiece;
    }

    private static char[][] createSecondPiece(final String[] rows) {
        char[][] firstPiece = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                firstPiece[i][j] = rows[i].charAt(j + 5);
            }
        }
        return firstPiece;
    }

    private static char[][] createThirdPiece(final String[] rows) {
        char[][] firstPiece = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                firstPiece[i][j] = rows[i].charAt(j + 10);
            }
        }
        return firstPiece;
    }

    private static char[][] createFourthPiece(final String[] rows) {
        char[][] firstPiece = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                firstPiece[i][j] = rows[i + 5].charAt(j);
            }
        }
        return firstPiece;
    }

    private static char[][] createFifthPiece(final String[] rows) {
        char[][] firstPiece = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                firstPiece[i][j] = rows[i + 5].charAt(j + 5);
            }
        }
        return firstPiece;
    }

    private static char[][] createSixthPiece(final String[] rows) {
        char[][] firstPiece = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                firstPiece[i][j] = rows[i + 5].charAt(j + 10);
            }
        }
        return firstPiece;
    }
}
