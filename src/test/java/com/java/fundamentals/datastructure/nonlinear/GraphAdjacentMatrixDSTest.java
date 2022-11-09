package com.java.fundamentals.datastructure.nonlinear;

import org.junit.Assert;
import org.junit.Test;

public class GraphAdjacentMatrixDSTest {

    @Test
    public void testNumVerticesZeroSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(0);
        Assert.assertEquals("", graph.toString());
    }

    @Test
    public void testNumVerticesOneSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(1);
        StringBuilder sb = new StringBuilder()
            .append("0");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(2);
        StringBuilder sb = new StringBuilder()
            .append("0 0 ")
            .append("\n")
            .append("0 0");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoAndEdgeOneSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 1);
        StringBuilder sb = new StringBuilder()
            .append("0 1 ")
            .append("\n")
            .append("1 1");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesThreeSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(3);
        StringBuilder sb = new StringBuilder()
            .append("0 0 0 ")
            .append("\n")
            .append("0 0 0 ")
            .append("\n")
            .append("0 0 0");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoAndEdgeTwoSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 2);
        StringBuilder sb = new StringBuilder()
            .append("0 0 1 ")
            .append("\n")
            .append("0 0 1 ")
            .append("\n")
            .append("1 1 1");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoAndEdgeOneTwoThreeSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(3);
        graph.addEdge(0, 0);
        graph.addEdge(1, 1);
        graph.addEdge(2, 2);
        StringBuilder sb = new StringBuilder()
            .append("1 0 0 ")
            .append("\n")
            .append("0 1 0 ")
            .append("\n")
            .append("0 0 1");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoAndEdgeOneTwoThreeAndRemoveZeroSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(3);
        graph.addEdge(0, 0);
        graph.addEdge(1, 1);
        graph.addEdge(2, 2);
        graph.removeEdge(0, 0);
        StringBuilder sb = new StringBuilder()
            .append("0 0 0 ")
            .append("\n")
            .append("0 1 0 ")
            .append("\n")
            .append("0 0 1");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoAndEdgeOneTwoThreeAndRemoveOneSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(3);
        graph.addEdge(0, 0);
        graph.addEdge(1, 1);
        graph.addEdge(2, 2);
        graph.removeEdge(1, 1);
        StringBuilder sb = new StringBuilder()
            .append("1 0 0 ")
            .append("\n")
            .append("0 0 0 ")
            .append("\n")
            .append("0 0 1");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

    @Test
    public void testNumVerticesTwoAndEdgeOneTwoThreeAndRemoveOneTwoSuccessfully() {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(3);
        graph.addEdge(0, 0);
        graph.addEdge(1, 1);
        graph.addEdge(2, 2);
        graph.removeEdge(1, 1);
        graph.removeEdge(2, 2);
        StringBuilder sb = new StringBuilder()
            .append("1 0 0 ")
            .append("\n")
            .append("0 0 0 ")
            .append("\n")
            .append("0 0 0");
        Assert.assertEquals(sb.toString(), graph.toString());
    }

}
