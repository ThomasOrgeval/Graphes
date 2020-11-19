package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {

    protected Map<Vertex, List<Vertex>> adjMatrix;

    public Graph(Map<Vertex, List<Vertex>> adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Map<Vertex, List<Vertex>> getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(Map<Vertex, List<Vertex>> adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public List<Vertex> getAdjacent(Vertex vertex) {
        return adjMatrix.get(vertex);
    }

    public void addVertex(Vertex vertex) {
        adjMatrix.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(Vertex vertex) {
        adjMatrix.remove(vertex);
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        adjMatrix.get(vertex1).add(vertex2);
        adjMatrix.get(vertex2).add(vertex1);
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if(adjMatrix.get(vertex1) != null) adjMatrix.get(vertex1).remove(vertex2);
        if(adjMatrix.get(vertex2) != null) adjMatrix.get(vertex2).remove(vertex1);
    }
}
