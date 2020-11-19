package test;

import model.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static utils.Breadth.breadthFirstSearch;
import static utils.Depth.depthFirstSearch;

public class GraphTest {

    public Graph createGraph() {
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

    @Test
    public void testDepthFirstSearch1() {
        Graph graph = createGraph();
        assertEquals("[Bob, Rob, Maria, Alice, Mark]", depthFirstSearch(graph, "Bob").toString());
    }

    @Test
    public void testDepthFirstSearch2() {
        Graph graph = createGraph();
        assertEquals("[Alice, Maria, Rob, Mark, Bob]", depthFirstSearch(graph, "Alice").toString());
    }

    @Test
    public void testBreadthFirstSearch1() {
        Graph graph = createGraph();
        assertEquals("[Bob, Alice, Rob, Mark, Maria]", breadthFirstSearch(graph, "Bob").toString());
    }

    @Test
    public void testBreadthFirstSearch2() {
        Graph graph = createGraph();
        assertEquals("[Alice, Bob, Mark, Maria, Rob]", breadthFirstSearch(graph, "Alice").toString());
    }

}
