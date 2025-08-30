package Graph;

import java.util.*;

public class GraphMatrix 
{
    private int[][] adjMatrix;
    private boolean isDirected;
    private int vertices;

    // Constructor
    public GraphMatrix(int vertices, boolean isDirected) 
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

        GraphMatrix graph = new GraphMatrix(vertices, isDirected);

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < edges; i++) 
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printGraph();
        sc.close();
    }
}
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

// Enter number of vertices: 4
// Enter number of edges: 3
// Is the graph directed? (true/false): true
// Enter edges (u v):
// 0 1
// 0 2
// 1 3
// Adjacency Matrix:
// 0 1 1 0
// 0 0 0 1
// 0 0 0 0