package com.java.fundamentals.datastructure.nonlinear;

public class GraphAdjacentMatrixDS {

    private boolean adjacentMatrix [][];
    private int numVertices;

    public GraphAdjacentMatrixDS(int numVertices) {
        this.adjacentMatrix = new boolean[numVertices][numVertices];
        this.numVertices = numVertices;
    }

    public void add(int i, int j) {
        this.adjacentMatrix[i][j] = true;
        this.adjacentMatrix[j][i] = true;
    }

    public void remove(int i, int j) {
        this.adjacentMatrix[i][j] = false;
        this.adjacentMatrix[j][i] = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                sb.append("" + (this.adjacentMatrix[i][j] == true ? 1 : 0) + " ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        GraphAdjacentMatrixDS graph = new GraphAdjacentMatrixDS(4);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 2);
        graph.add(2, 0);
        graph.add(2, 1);

        System.out.println(graph);
    }
}
