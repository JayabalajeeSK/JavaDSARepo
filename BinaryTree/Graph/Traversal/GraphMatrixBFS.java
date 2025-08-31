package Graph.Traversal;

import java.util.*;

public class GraphMatrixBFS 
{
    private int[][] adjMatrix;
    private boolean isDirected;
    private int vertices;

    // Constructor
    public GraphMatrixBFS(int vertices, boolean isDirected) 
    {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjMatrix = new int[vertices][vertices];  
    }

    // Method to add edge
    public void addEdge(int u, int v) 
    {
        adjMatrix[u][v] = 1;   

        if (!isDirected) 
        {
            adjMatrix[v][u] = 1;  
        }
    }

    // Display the graph
    public void printGraph() 
    {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) 
        {
            for (int j = 0; j < vertices; j++) 
            {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS Traversal
    public void bfs(int start) 
    {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("\nBFS Traversal starting from " + start + ": ");

        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor = 0; neighbor < vertices; neighbor++) 
            {
                if (adjMatrix[node][neighbor] == 1 && !visited[neighbor]) 
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

        GraphMatrixBFS graph = new GraphMatrixBFS(vertices, isDirected);

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < edges; i++) 
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printGraph();

        System.out.print("\nEnter starting node for BFS: ");
        int start = sc.nextInt();
        graph.bfs(start);

        sc.close();
    }
}
// UD ////////////////////////////////////////
// Enter number of vertices: 4
// Enter number of edges: 3
// Is the graph directed? (true/false): false
// Enter edges (u v): 
// 0 1
// 0 2
// 1 3
// Adjacency Matrix:
// 0 1 1 0 
// 1 0 0 1 
// 1 0 0 0 
// 0 1 0 0 

// Enter starting node for BFS: 0

// BFS Traversal starting from 0: 0 1 2 3

// D ////////////////////////////////////////////
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
// Adjacency Matrix:
// 0 1 1 0 0 0
// 0 0 0 1 0 0
// 0 0 0 0 1 0
// 0 0 0 0 0 1
// 0 0 0 0 0 1
// 0 0 0 0 0 0

// Enter starting node for BFS: 0

// BFS Traversal starting from 0: 0 1 2 3 4 5