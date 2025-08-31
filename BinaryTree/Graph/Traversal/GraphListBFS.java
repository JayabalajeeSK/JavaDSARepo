package Graph.Traversal;
import java.util.*;

public class GraphListBFS 
{
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;

    // Constructor
    public GraphListBFS(int vertices, boolean isDirected) 
    {
        adjList = new HashMap<>();
        this.isDirected = isDirected;

        for (int i = 0; i < vertices; i++) 
        {
            adjList.put(i, new ArrayList<>());
        }
    }

    // Method to add edge
    public void addEdge(int u, int v) 
    {
        adjList.get(u).add(v); 

        if (!isDirected) 
        {
            adjList.get(v).add(u);  
        }
    }

    // Display the graph
    public void printGraph() 
    {
        for (int vertex : adjList.keySet()) 
        {
            System.out.print(vertex + " -> ");
            for (int neighbor : adjList.get(vertex)) 
            {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // BFS Traversal
    public void bfs(int start) 
    {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal starting from " + start + ": ");

        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) 
            {
                if (!visited[neighbor]) 
                {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        GraphListBFS graph = new GraphListBFS(vertices, isDirected);

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < edges; i++) 
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("\nGraph Representation:");
        graph.printGraph();

        System.out.print("\nEnter starting node for BFS: ");
        int start = sc.nextInt();
        graph.bfs(start);

        sc.close();
    }
}
// UD ///////////////////////////////////////////
// Enter number of vertices: 4
// Enter number of edges: 3
// Is the graph directed? (true/false): false
// Enter edges (u v):
// 0 1
// 0 2
// 1 3

// Graph Representation:
// 0 -> 1 2
// 1 -> 0 3
// 2 -> 0
// 3 -> 1

// Enter starting node for BFS: 0
// BFS Traversal starting from 0: 0 1 2 3

// D //////////////////////////////////
// Enter number of vertices: 6
// Enter number of edges: 6
// Is the graph directed? (true/false): true
// Enter edges (u v):
// 0 1
// 0 2
// 1 3
// 2 4
// 3 5
// 4 5

// Graph Representation:
// 0 -> 1 2
// 1 -> 3
// 2 -> 4
// 3 -> 5
// 4 -> 5
// 5 ->

// Enter starting node for BFS: 0
// BFS Traversal starting from 0: 0 1 2 3 4 5