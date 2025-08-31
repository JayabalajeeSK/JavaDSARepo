package Graph.Traversal;

import java.util.*;

public class GraphMatrixDFS 
{
    private int[][] adjMatrix;
    private boolean isDirected;
    private int vertices;

    private boolean[] visited;

    // Constructor
    public GraphMatrixDFS(int vertices, boolean isDirected) 
    {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjMatrix = new int[vertices][vertices];  
        visited = new boolean[vertices];
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

    // ----------- PRE-ORDER DFS -----------
    private void dfsPreUtil(int node, List<Integer> preOrder) 
    {
        visited[node] = true;
        preOrder.add(node);   // Pre-order step

        for (int j = 0; j < vertices; j++) 
        {
            if (adjMatrix[node][j] == 1 && !visited[j]) 
            {
                dfsPreUtil(j, preOrder);
            }
        }
    }

    public List<Integer> dfsPreOrder(int start) 
    {
        Arrays.fill(visited, false);
        List<Integer> preOrder = new ArrayList<>();

        dfsPreUtil(start, preOrder);

        // For disconnected graphs
        for (int i = 0; i < vertices; i++) 
        {
            if (!visited[i]) dfsPreUtil(i, preOrder);
        }
        return preOrder;
    }

    // ----------- POST-ORDER DFS -----------
    private void dfsPostUtil(int node, List<Integer> postOrder) 
    {
        visited[node] = true;

        for (int j = 0; j < vertices; j++) 
        {
            if (adjMatrix[node][j] == 1 && !visited[j]) 
            {
                dfsPostUtil(j, postOrder);
            }
        }

        postOrder.add(node);  // Post-order step
    }

    public List<Integer> dfsPostOrder(int start) 
    {
        Arrays.fill(visited, false);
        List<Integer> postOrder = new ArrayList<>();

        dfsPostUtil(start, postOrder);

        // For disconnected graphs
        for (int i = 0; i < vertices; i++) 
        {
            if (!visited[i]) dfsPostUtil(i, postOrder);
        }
        return postOrder;
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

        GraphMatrixDFS graph = new GraphMatrixDFS(vertices, isDirected);

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < edges; i++) 
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printGraph();

        System.out.print("\nEnter starting node for DFS: ");
        int start = sc.nextInt();

        System.out.println("Pre-order Traversal: " + graph.dfsPreOrder(start));
        System.out.println("Post-order Traversal: " + graph.dfsPostOrder(start));

        sc.close();
    }
}
// UD ////////////////////////////////////
// Enter number of vertices: 5
// Enter number of edges: 4
// Is the graph directed? (true/false): false
// Enter edges (u v): 
// 0 1
// 0 2
// 1 3
// 3 4
// Adjacency Matrix:
// 0 1 1 0 0 
// 1 0 0 1 0 
// 1 0 0 0 0 
// 0 1 0 0 1
// 0 0 0 1 0

// Enter starting node for DFS: 0
// Pre-order Traversal: [0, 1, 3, 4, 2]
// Post-order Traversal: [4, 3, 1, 2, 0]

// D ///////////////////////////////
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
// 0 0 0 0

// Enter starting node for DFS: 0
// Pre-order Traversal: [0, 1, 3, 2]
// Post-order Traversal: [3, 1, 2, 0]
