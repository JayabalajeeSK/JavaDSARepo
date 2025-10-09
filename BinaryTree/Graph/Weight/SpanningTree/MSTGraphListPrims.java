package Graph.Weight.SpanningTree;


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


public class MSTGraphListPrims 
{
    private Map<Integer, List<Edge>> adjList;
    private boolean isDirected;
    private String[] labels;

    public MSTGraphListPrims(int vertices, boolean isDirected) 
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
        for (int vertex : adjList.keySet()) 
        {
            System.out.print(labels[vertex] + " -> ");
            for (Edge edge : adjList.get(vertex)) 
            {
                System.out.print("(" + labels[edge.dest] + ", w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // BFS Traversal
    public void bfs(int start) 
    {
        boolean[] visited = new boolean[labels.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("\nBFS Traversal starting from " + labels[start] + ": ");

        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            System.out.print(labels[node] + " ");

            for (Edge edge : adjList.getOrDefault(node, new ArrayList<>())) 
            {
                if (!visited[edge.dest]) 
                
                {
                    visited[edge.dest] = true;
                    queue.add(edge.dest);
                }
            }
        }
        System.out.println();
    }

    // ---------- Prim's Algorithm ----------
    public void primMST(int vertices) 
    {
        if (isDirected) 
        {
            System.out.println("\nMST (Prim) not applicable for directed graphs.");
            return;
        }
        

        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        visited[0] = true;
        for (Edge e : adjList.getOrDefault(0, new ArrayList<>())) 
        {
            minHeap.add(e);
        }

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        int edgesUsed = 0;

        while (!minHeap.isEmpty() && edgesUsed < vertices - 1) 
        {
            Edge edge = minHeap.poll();

            if (visited[edge.dest]) 
            {
                continue; 
            }

            visited[edge.dest] = true;
            mstEdges.add(edge);
            totalCost = totalCost + edge.weight;
            edgesUsed++;

            for (Edge next : adjList.getOrDefault(edge.dest, new ArrayList<>())) 
            {
                if (!visited[next.dest]) 
                {
                    minHeap.add(next);
                }
            }
        }

        System.out.println("\nMST using Prim's Algorithm:");
        for (Edge e : mstEdges) 
        {
            System.out.println(labels[e.src] + " - " + labels[e.dest] + " (w=" + e.weight + ")");
        }
        System.out.println("Total cost of MST = " + totalCost);
    }

    // ---------- Main ----------
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        MSTGraphList graph = new MSTGraphList(vertices, isDirected);

        System.out.println("Enter labels for vertices (like A B C ...): ");
        String[] labels = new String[vertices];
        for (int i = 0; i < vertices; i++) 
        {
            labels[i] = sc.next();
        }
        graph.setLabels(labels);

        System.out.println("Enter edges (u v weight) using labels:");
        for (int i = 0; i < edges; i++) 
        {
            String uLabel = sc.next();
            String vLabel = sc.next();
            int weight = sc.nextInt();

            int u = Arrays.asList(labels).indexOf(uLabel);
            int v = Arrays.asList(labels).indexOf(vLabel);

            graph.addEdge(u, v, weight);
        }

        graph.printGraph();

        System.out.print("\nEnter starting node for BFS: ");
        String startLabel = sc.next();
        int start = Arrays.asList(labels).indexOf(startLabel);
        graph.bfs(start);

        // Run Kruskal and Prim
        graph.primMST(vertices);

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

// Enter starting node for BFS: A

// BFS Traversal starting from A: A B C D

// MST using Prim's Algorithm:
// A - B (w=2)
// B - D (w=3)
// A - C (w=4)
// Total cost of MST = 9