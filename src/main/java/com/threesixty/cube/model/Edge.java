package com.threesixty.cube.model;

public class Edge {

    private char[] edge;

    public Edge(final char[] edge) {
        this.edge = edge.clone();
    }

    public char[] getEdge() {
        return edge;
    }

    public void setEdge(final char[] edge) {
        this.edge = edge;
    }

    public Edge getReverseEdge() {
        StringBuilder original = new StringBuilder();
        original.append(edge);
        return new Edge(original.reverse().toString().toCharArray());
    }

}
