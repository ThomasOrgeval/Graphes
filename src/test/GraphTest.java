package test;

import model.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static utils.Breadth.breadthFirstSearch;
import static utils.Depth.depthFirstSearch;

public class GraphTest {

    public Graph graph1() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Alice");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    public Graph graph2() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("S");
        graph.addEdge("S", "E");
        graph.addEdge("S", "D");
        graph.addEdge("S", "A");
        graph.addEdge("S", "C");
        graph.addEdge("E", "D");
        graph.addEdge("A", "B");
        graph.addEdge("C", "B");
        return graph;
    }

    @Test
    public void testDepthFirstSearch1() {
        Graph graph = graph1();
        assertEquals("[Bob, Rob, Maria, Alice, Mark]", depthFirstSearch(graph, "Bob").toString());
    }

    @Test
    public void testDepthFirstSearch2() {
        Graph graph = graph1();
        assertEquals("[Alice, Maria, Rob, Mark, Bob]", depthFirstSearch(graph, "Alice").toString());
    }

    @Test
    public void testDepthFirstSearch3() {
        Graph graph = graph2();
        assertEquals("[S, C, B, A, D, E]", depthFirstSearch(graph, "S").toString());
    }

    @Test
    public void testBreadthFirstSearch1() {
        Graph graph = graph1();
        assertEquals("[Bob, Alice, Rob, Mark, Maria]", breadthFirstSearch(graph, "Bob").toString());
    }

    @Test
    public void testBreadthFirstSearch2() {
        Graph graph = graph1();
        assertEquals("[Alice, Bob, Mark, Maria, Rob]", breadthFirstSearch(graph, "Alice").toString());
    }

}
