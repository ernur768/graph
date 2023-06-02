import java.util.*;

public class MyGraph<T>
{
    private final boolean undirected;
    private Map<T, Set<T>> graph;

    public MyGraph()
    {
        this(false);
    }

    public MyGraph(boolean undirected)
    {
        this.undirected = undirected;
        this.graph = new HashMap<>();
    }

    public List<T> DFS(T source, T dest)
    {
        if (!graph.containsKey(source)) return null;
        List<T> res = new ArrayList<>();
        DFS(source, dest, res);
        return res;
    }

    private void DFS(T source, T dest, List<T> arr)
    {
        arr.add(source);
        if (source.equals(dest)) return;

        for (T neighbor : graph.get(source))
        {
            if (!arr.contains(neighbor))
            {
                DFS(neighbor, dest, arr);
            }
        }
    }


    public List<T> BFS(T source, T dest)
    {
        if (!graph.containsKey(source)) return null;

        Queue<T> queue = new LinkedList<>();
        queue.add(source);
        List<T> visited = new ArrayList<>();

        while (!queue.isEmpty())
        {
            T vertex = queue.poll();

            if (!visited.contains(vertex))
            {

                visited.add(vertex);
                queue.addAll(graph.get(vertex));
            }

            if (vertex.equals(dest)) break;

        }

        return visited;
    }

    public void addVertex(T v) {
        if (graph.containsKey(v)) return;
        graph.put(v, new HashSet<>());
    }

    public void addEdge(T source, T dest) {
        if (!graph.containsKey(source) || !graph.containsKey(dest)) return;
        if (source.equals(dest)) return;

        graph.get(source).add(dest);

        if (undirected)
        {
            graph.get(dest).add(source);
        }
    }

    public void print()
    {
        for (T vertex : graph.keySet()) {
            System.out.print(vertex + " : ");
            for (T neighbor : graph.get(vertex)) {
                System.out.print(neighbor + ", ");
            }
            System.out.println();
        }
    }



}
