package model.test;

import model.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void testDepthFirstSearch() {
        Graph graph = createGraph();
        assertEquals("[Bob, Rob, Maria, Alice, Mark]", graph.depthFirstSearch("Bob").toString());
    }

    @Test
    public void testDepthFirstSearch2() {
        Graph graph = createGraph();
        assertEquals("[Alice, Maria, Rob, Mark, Bob]", graph.depthFirstSearch("Alice").toString());
    }

    @Test
    public void testBreadthFirstSearch() {
        Graph graph = createGraph();
        assertEquals("[Bob, Alice, Rob, Mark, Maria]", graph.breadthFirstSearch("Bob").toString());
    }

    @Test
    public void testBreadthFirstSearch2() {
        Graph graph = createGraph();
        assertEquals("[Alice, Bob, Mark, Maria, Rob]", graph.breadthFirstSearch("Alice").toString());
    }

}
