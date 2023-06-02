import java.util.*;

public class Dijkstra<T extends Comparable<T>>
{
    private final WeightedGraph<T> graph;
    private final Map<T, Double> costs;
    private final Map<T, T> parentTable;

    private final T source;
    private final T dest;

    public List<T> getRoad()
    {
        makeParentTable();
        List<T> road = new ArrayList<>();

        T vertex = dest;

        while (!vertex.equals(source))
        {
            road.add(vertex);
            vertex = parentTable.get(vertex);
        }
        road.add(source);

        Collections.reverse(road);

        return road;
    }

    private void makeParentTable()
    {
        Set<T> visited = new HashSet<>();

        T vertex = findMinCostVertex(visited);
        double cost;
        double newCost;

        while (vertex != null)
        {
            cost = costs.get(vertex);

            for (T neighbor : graph.getNeighbors(vertex)) {
                newCost = cost + graph.getWeight(vertex, neighbor);

                if (newCost < costs.get(neighbor))
                {
                    costs.put(neighbor, newCost);
                    parentTable.put(neighbor, vertex);
                }
            }

            visited.add(vertex);
            vertex = findMinCostVertex(visited);
        }
    }

    private T findMinCostVertex(Set<T> visited)
    {
        return costs
                .entrySet()
                .stream()
                .filter(e -> !visited.contains(e.getKey()))
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

    public Dijkstra(WeightedGraph<T> graph, T source, T dest)
    {
        this.graph = graph;
        this.source = source;
        this.dest = dest;

        this.costs = new HashMap<>();
        initializeCosts();

        this.parentTable = new HashMap<>();
        initializeParentTable();
    }

    private void initializeCosts()
    {
        for (T vertex : graph.getVertices()) {
            costs.put(vertex, Double.MAX_VALUE);
        }

        Map<T, Double> neighborsTable = graph.getNeighborsTable(source);
        for (T neighbor : neighborsTable.keySet()) {
            costs.put(neighbor, neighborsTable.get(neighbor));
        }

        costs.remove(source);
    }

    private void initializeParentTable()
    {
        for (T neighbor : graph.getNeighbors(source)) {
            parentTable.put(neighbor, source);
        }
    }
}
