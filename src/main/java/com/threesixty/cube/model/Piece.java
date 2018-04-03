package com.threesixty.cube.model;

public class Piece {

    private char[][] mat;

    public Piece(final char[][] mat) {
        this.mat = mat;
    }

    public char[][] getMat() {
        return mat;
    }

    public void setMat(final char[][] mat) {
        this.mat = mat;
    }

    public Edge getLeftEdge() {
        char[] edge = new char[3];
        for (int i = 0; i < 3; i++) {
            edge[i] = mat[i + 1][0];
        }
        return new Edge(edge);
    }

    public Edge getTopEdge() {
        char[] edge = new char[3];
        for (int i = 0; i < 3; i++) {
            edge[i] = mat[0][i + 1];
        }
        return new Edge(edge);
    }

    public Edge getRightEdge() {
        char[] edge = new char[3];
        for (int i = 0; i < 3; i++) {
            edge[i] = mat[i + 1][4];
        }
        return new Edge(edge);
    }

    public Edge getBottomEdge() {
        char[] edge = new char[3];
        for (int i = 0; i < 3; i++) {
            edge[i] = mat[4][i + 1];
        }
        return new Edge(edge);
    }

    public char getTopLeftCorner() {
        return mat[0][0];
    }

    public char getTopRightCorner() {
        return mat[0][4];
    }

    public char getBottomLeftCorner() {
        return mat[4][0];
    }

    public char getBottomRightCorner() {
        return mat[4][4];
    }

    public Piece rotatePiece() {
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 5 - i - 1; j++) {
                char temp = mat[i][j];

                mat[i][j] = mat[j][5 - 1 - i];
                mat[j][5 - 1 - i] = mat[5 - 1 - i][5 - 1 - j];
                mat[5 - 1 - i][5 - 1 - j] = mat[5 - 1 - j][i];
                mat[5 - 1 - j][i] = temp;
            }
        }

        return new Piece(mat);
    }

    public Piece flipPiece() {
        char[] temp0 = mat[0];
        char[] temp1 = mat[1];

        mat[0] = mat[4];
        mat[1] = mat[3];
        mat[3] = temp1;
        mat[4] = temp0;

        return new Piece(mat);
    }

}