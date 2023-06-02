import java.util.*;

public class WeightedGraph<T>
{
    private final boolean undirected;
    private final Map<T, Map<T, Double>> graph;

    public WeightedGraph()
    {
        this(false);
    }

    public WeightedGraph(boolean undirected)
    {
        this.undirected = undirected;
        this.graph = new HashMap<>();
    }

    public double getWeight(T source, T dest)
    {
        return graph.get(source).get(dest);
    }

    public Map<T, Double> getNeighborsTable(T vertex)
    {
        return graph.get(vertex);
    }

    public Set<T> getNeighbors(T vertex)
    {
        return graph.get(vertex).keySet();
    }

    public Set<T> getVertices()
    {
        return graph.keySet();
    }

    public void addVertex(T vertex)
    {
        if (graph.containsKey(vertex)) return;
        graph.put(vertex, new HashMap<>());
    }

    public void addEdge(T source, T dest, double weight)
    {
        if (!graph.containsKey(source) || !graph.containsKey(dest)) return;
        if (source.equals(dest)) return;

        graph.get(source).put(dest, weight);

        if (undirected)
        {
            graph.get(dest).put(source, weight);
        }
    }


    public void print()
    {
        Map<T, Double> neighbors;
        for (T vertex : graph.keySet()) {
            neighbors = graph.get(vertex);

            System.out.print(vertex + ":\n");
            for (T neighbor : neighbors.keySet()) {
                System.out.println("\t" + neighbor + " weight is : " + neighbors.get(neighbor) + ", ");
            }
        }
    }


}
