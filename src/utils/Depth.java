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
        while (!stack.isEmpty()) {
            Vertex vertex = new Vertex(stack.pop());
            if (!visited.contains(vertex.toString())) {
                visited.add(vertex.toString());
                for (Vertex v : graph.getAdjacent(vertex)) {
                    stack.push(v.getVertex());
                }
            }
        }
        return visited;
    }

}
