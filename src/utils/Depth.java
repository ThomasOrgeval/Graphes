package utils;

import model.Graph;
import model.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Depth {

    public static Set<String> depthFirstSearch(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        Vertex vertex = new Vertex(root);
        while (!stack.isEmpty()) {
            if (!visited.contains(vertex.toString())) {
                visited.add(vertex.toString());
                for (Vertex v : graph.getAdjacent(vertex)) {
                    stack.push(v.getVertex());
                }
            }
            vertex = new Vertex(stack.pop());
        }
        return visited;
    }

    public static Set<String> depthFirstSearchRecursive(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        for (Vertex vertex : graph.getAdjMatrix().keySet()) {
            if (!visited.contains(vertex.toString())) graph.explore(new Vertex(root), visited);
        }
        System.out.println("\n" + visited.toString());
        return visited;
    }

}
