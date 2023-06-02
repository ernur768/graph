





public class Main {
    public static void main(String[] args) {
//        WeightedGraph<String> graph = new WeightedGraph<>();
        MyGraph<String> graph = new MyGraph<>();

        graph.addVertex("Almaty");
        graph.addVertex("Astana");
        graph.addVertex("Shymkent");
        graph.addVertex("Kostanay");
        graph.addVertex("Kyzylorda");

//        graph.addEdge("Almaty", "Astana", 2.1);
//        graph.addEdge("Almaty", "Shymkent", 7.2);
//        graph.addEdge("Shymkent", "Astana", 3.9);
//        graph.addEdge("Astana", "Kostanay", 3.5);
//        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");

//        System.out.println("Dijkstra:");
////        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
////        outputPath(djk, "Kyzylorda");
//        Dijkstra<String> dijkstra = new Dijkstra<>(graph, "Almaty", "Kyzylorda");
//        outputPath(dijkstra.getRoad());


        System.out.println("DFS:");
//        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(graph.DFS("Almaty", "Kyzylorda"));

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
//        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(graph.BFS("Almaty", "Kyzylorda"));
    }

    public static void outputPath(Iterable<String> road) {
        for (String v : road) {
            System.out.print(v + " -> ");
        }
    }
}














//import java.util.List;
//
//public class Main
//{
//    public static void main(String[] args)
//    {
//        WeightedGraph<String> graph = new WeightedGraph<>();
//
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//
//        graph.addEdge("A", "B", 6);
//        graph.addEdge("A", "C", 2);
//        graph.addEdge("C", "B", 3);
//        graph.addEdge("B", "D", 1);
//        graph.addEdge("C", "D", 5);
//
//        Dijkstra<String> dijkstra = new Dijkstra<>(graph, "A", "D");
//
//        for (String vertex : dijkstra.getRoad()) {
//            System.out.print(vertex + " ");
//        }
//        System.out.println();
//    }
//}
//
///*
//1) MyGraph
//*/