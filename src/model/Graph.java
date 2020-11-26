package model;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    protected Map<Vertex, List<Vertex>> adjMatrix;

    public Graph() {
        this.adjMatrix = new HashMap<>();
    }

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

    public void addVertex(String vertex) {
        adjMatrix.putIfAbsent(new Vertex(vertex), new ArrayList<>());
    }

    public void removeVertex(Vertex vertex) {
        adjMatrix.values()
                .stream()
                .map(e -> e.remove(vertex))
                .collect(Collectors.toList());
        adjMatrix.remove(vertex);
    }

    public void removeVertex(String vertex) {
        removeVertex(new Vertex(vertex));
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        adjMatrix.get(vertex1).add(vertex2);
        adjMatrix.get(vertex2).add(vertex1);
    }

    public void addEdge(String vertex1, String vertex2) {
        addEdge(new Vertex(vertex1), new Vertex(vertex2));
    }

    public void addEdgeSense(Vertex vertex1, Vertex vertex2) {
        adjMatrix.get(vertex1).add(vertex2);
    }

    public void addEdgeSense(String vertex1, String vertex2) {
        addEdgeSense(new Vertex(vertex1), new Vertex(vertex2));
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if(adjMatrix.get(vertex1) != null) adjMatrix.get(vertex1).remove(vertex2);
        if(adjMatrix.get(vertex2) != null) adjMatrix.get(vertex2).remove(vertex1);
    }

    public void removeEdge(String vertex1, String vertex2) {
        removeEdge(new Vertex(vertex1), new Vertex(vertex2));
    }

    public void removeEdgeSense(Vertex vertex1, Vertex vertex2) {
        if(adjMatrix.get(vertex1) != null) adjMatrix.get(vertex1).remove(vertex2);
    }

    public void removeEdgeSense(String vertex1, String vertex2) {
        removeEdgeSense(new Vertex(vertex1), new Vertex(vertex2));
    }

    public void explore(Vertex root, Set<String> visited) {
        visited.add(root.toString());
        preVisit(root);
        for (Vertex vertex : this.getAdjacent(root)) {
            if (!visited.contains(vertex.toString())) explore(vertex, visited);
        }
        postVisit(root);
    }

    private void preVisit(Vertex root) {
        System.out.print(root.toString() + " ");
    }

    private void postVisit(Vertex root) {
        System.out.print(root.toString() + " ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(adjMatrix, graph.adjMatrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adjMatrix);
    }

    @Override
    public String toString() {
        return "Graph="+ adjMatrix + "";
    }
}
