import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "C", 2);
        graph.addEdge("C", "B", 3);
        graph.addEdge("B", "D", 1);
        graph.addEdge("C", "D", 5);

        Dijkstra<String> dijkstra = new Dijkstra<>(graph, "A", "D");

        for (String vertex : dijkstra.getRoad()) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}

/*
1) MyGraph
*/