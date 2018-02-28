package dataStructure.graph.graph_v;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        CreateGraph createGraph = new CreateGraph();
        createGraph.initGraph(graph);
        createGraph.outputGraph(graph);
    }
}
