public class GraphExample {
    public static AdjacencyList<String> buildSampleGraph() {
        AdjacencyList<String> ajGraph = new AdjacencyList<>();
        ajGraph.addEdge("A", "B");
        ajGraph.addEdge("B", "A");
        ajGraph.addEdge("B", "E");
        ajGraph.addEdge("D", "A");
        ajGraph.addEdge("E", "A");
        ajGraph.addEdge("E", "C");
        ajGraph.addEdge("E", "D");

        return ajGraph;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        AdjacencyList<String> exampleAJGraph = buildSampleGraph();
        System.out.println(exampleAJGraph);

        System.out.println(exampleAJGraph.containsEdge("A", "B")); // true
        System.out.println(exampleAJGraph.containsEdge("A", "C")); // false
        
        

    }
}
