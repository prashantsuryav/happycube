package com.threesixty.cube.model;

import org.junit.jupiter.api.Test;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EdgeTest {

    private static final String EDGE = "xxooo";
    private static final String REVERSED = "oooxx";

    @Test
    void given_EdgeIsSet_whenGetEdge_ShouldReturnEdge() {
        Edge edge = new Edge(EDGE.toCharArray());

        assertNotNull(edge.getEdge());
        assertEquals(valueOf(EDGE.toCharArray()), valueOf(edge.getEdge()));
    }

    @Test
    void given_EdgeIsSet_whenGetReverse_ShouldReturnReversedEdge() {
        Edge edge = new Edge(EDGE.toCharArray());

        assertNotNull(edge.getEdge());
        assertEquals(valueOf(REVERSED.toCharArray()), valueOf(edge.getReverseEdge().getEdge()));
    }

}