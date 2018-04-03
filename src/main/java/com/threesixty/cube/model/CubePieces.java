package com.threesixty.cube.model;

import java.util.List;

public class CubePieces {

    private List<Piece> allPieces;

    public CubePieces(final List<Piece> allPieces) {
        this.allPieces = allPieces;
    }

    public List<Piece> getAllPieces() {
        return allPieces;
    }

    public void setAllPieces(final List<Piece> allPieces) {
        this.allPieces = allPieces;
    }

    public Piece getPiece(int i) {
        return allPieces.get(i);
    }

}
