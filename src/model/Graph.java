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

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if(adjMatrix.get(vertex1) != null) adjMatrix.get(vertex1).remove(vertex2);
        if(adjMatrix.get(vertex2) != null) adjMatrix.get(vertex2).remove(vertex1);
    }

    public void removeEdge(String vertex1, String vertex2) {
        removeEdge(new Vertex(vertex1), new Vertex(vertex2));
    }

    public Set<String> depthFirstSearch(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vertex = new Vertex(stack.pop());
            if (!visited.contains(vertex.toString())) {
                visited.add(vertex.toString());
                for (Vertex v : this.getAdjacent(vertex)) {
                    stack.push(v.vertex);
                }
            }
        }
        return visited;
    }

    public Set<String> breadthFirstSearch(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Vertex vertex = new Vertex(queue.poll());
            for (Vertex v : this.getAdjacent(vertex)) {
                if (!visited.contains(v.vertex)) {
                    visited.add(v.vertex);
                    queue.add(v.vertex);
                }
            }
        }
        return visited;
    }
}
