package utils;

import model.Graph;
import model.Vertex;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Breadth {

    public static Set<String> breadthFirstSearch(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Vertex vertex = new Vertex(queue.poll());
            for (Vertex v : graph.getAdjacent(vertex)) {
                if (!visited.contains(v.getVertex())) {
                    visited.add(v.getVertex());
                    queue.add(v.getVertex());
                }
            }
        }
        return visited;
    }
}
