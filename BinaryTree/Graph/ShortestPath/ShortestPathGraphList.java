package Graph.ShortestPath;

import java.util.*;

class Edge 
{
    int src, dest, weight;

    Edge(int src, int dest, int weight) 
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class ShortestPathGraphList 
{
    private Map<Integer, List<Edge>> adjList;
    private boolean isDirected;
    private String[] labels;

    public ShortestPathGraphList(int vertices, boolean isDirected) 
    {
        adjList = new HashMap<>();
        this.isDirected = isDirected;
        labels = new String[vertices];
    }

    public void setLabels(String[] labels) 
    {
        this.labels = labels;
    }

    public void addEdge(int u, int v, int weight) 
    {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(new Edge(u, v, weight));

        if (!isDirected) 
        {
            adjList.get(v).add(new Edge(v, u, weight));
        }
    }

    public void printGraph() 
    {
        System.out.println("\nGraph Representation (Adjacency List):");
        for (int vertex : adjList.keySet()) {
            System.out.print(labels[vertex] + " -> ");
            for (Edge edge : adjList.get(vertex)) {
                System.out.print("(" + labels[edge.dest] + ", w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // ---------- Dijkstra Algorithm (no negative weights) ----------
    public void dijkstra(int src, int vertices) 
    {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) 
        {
            int[] node = pq.poll();
            int u = node[0];
            int d = node[1];

            if (d > dist[u]) continue; // Skip outdated entry

            for (Edge edge : adjList.getOrDefault(u, new ArrayList<>())) 
            {
                if (dist[u] + edge.weight < dist[edge.dest]) 
                {
                    dist[edge.dest] = dist[u] + edge.weight;
                    pq.add(new int[]{edge.dest, dist[edge.dest]});
                }
            }
        }

        System.out.println("\nShortest paths from " + labels[src] + " using Dijkstra:");
        for (int i = 0; i < vertices; i++) 
        {
            System.out.println(labels[src] + " -> " + labels[i] + " = " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // ---------- Bellman-Ford Algorithm (handles negative weights) ----------
    public void bellmanFord(int src, int vertices) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges (V-1) times
        for (int i = 1; i < vertices; i++) {
            for (int u : adjList.keySet()) {
                for (Edge e : adjList.get(u)) {
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.dest]) {
                        dist[e.dest] = dist[u] + e.weight;
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int u : adjList.keySet()) {
            for (Edge e : adjList.get(u)) {
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.dest]) {
                    System.out.println("\nGraph contains negative weight cycle!");
                    return;
                }
            }
        }

        System.out.println("\nShortest paths from " + labels[src] + " using Bellman-Ford:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(labels[src] + " -> " + labels[i] + " = " +
                    (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        ShortestPathGraphList graph = new ShortestPathGraphList(vertices, isDirected);

        System.out.println("Enter labels for vertices (like A B C ...): ");
        String[] labels = new String[vertices];
        for (int i = 0; i < vertices; i++) {
            labels[i] = sc.next();
        }
        graph.setLabels(labels);

        System.out.println("Enter edges (u v weight) using labels:");
        for (int i = 0; i < edges; i++) {
            String uLabel = sc.next();
            String vLabel = sc.next();
            int weight = sc.nextInt();

            int u = Arrays.asList(labels).indexOf(uLabel);
            int v = Arrays.asList(labels).indexOf(vLabel);

            graph.addEdge(u, v, weight);
        }

        graph.printGraph();

        System.out.print("\nEnter source node for shortest paths: ");
        String startLabel = sc.next();
        int start = Arrays.asList(labels).indexOf(startLabel);

        // Run Dijkstra (if no negatives)
        boolean hasNegative = false;
        for (int u : graph.adjList.keySet()) {
            for (Edge e : graph.adjList.get(u)) {
                if (e.weight < 0) {
                    hasNegative = true;
                    break;
                }
            }
        }

        if (hasNegative) {
            graph.bellmanFord(start, vertices);
        } else {
            graph.dijkstra(start, vertices);
        }

        sc.close();
    }
}
// Enter number of vertices: 4
// Enter number of edges: 4
// Is the graph directed? (true/false): false
// Enter labels for vertices (like A B C ...):
// A B C D
// Enter edges (u v weight) using labels:
// A B 2
// A C 4
// B D 3
// C D 5

// Graph Representation (Adjacency List):
// A -> (B, w=2) (C, w=4) 
// B -> (A, w=2) (D, w=3)
// C -> (A, w=4) (D, w=5)
// D -> (B, w=3) (C, w=5)

// Enter source node for shortest paths: A 

// Shortest paths from A using Dijkstra:
// A -> A = 0
// A -> B = 2
// A -> C = 4
// A -> D = 5