package Graph.Traversal;

import java.util.*;

public class GraphListDFS 
{
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;
    private boolean[] visited;

    // Constructor
    public GraphListDFS(int vertices, boolean isDirected) 
    {
        adjList = new HashMap<>();
        this.isDirected = isDirected;
        visited = new boolean[vertices];

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

    // ----------- PRE-ORDER DFS -----------
    private void dfsPreUtil(int node, List<Integer> preOrder) 
    {
        visited[node] = true;
        preOrder.add(node);   // Pre-order step

        for (int neighbor : adjList.get(node)) 
        {
            if (!visited[neighbor]) 
            {
                dfsPreUtil(neighbor, preOrder);
            }
        }
    }

    public List<Integer> dfsPreOrder(int start) 
    {
        Arrays.fill(visited, false);
        List<Integer> preOrder = new ArrayList<>();

        dfsPreUtil(start, preOrder);

        // For disconnected graphs
        for (int i = 0; i < visited.length; i++) 
        {
            if (!visited[i]) dfsPreUtil(i, preOrder);
        }
        return preOrder;
    }

    // ----------- POST-ORDER DFS -----------
    private void dfsPostUtil(int node, List<Integer> postOrder) 
    {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) 
        {
            if (!visited[neighbor]) 
            {
                dfsPostUtil(neighbor, postOrder);
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
        for (int i = 0; i < visited.length; i++) 
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

        GraphListDFS graph = new GraphListDFS(vertices, isDirected);

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < edges; i++) 
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("\nGraph Representation:");
        graph.printGraph();

        System.out.print("\nEnter starting node for DFS: ");
        int start = sc.nextInt();

        System.out.println("Pre-order Traversal: " + graph.dfsPreOrder(start));
        System.out.println("Post-order Traversal: " + graph.dfsPostOrder(start));

        sc.close();
    }
}
// UD /////////////////////////////////////////////////////
// Enter number of vertices: 5
// Enter number of edges: 4
// Is the graph directed? (true/false): false
// Enter edges (u v): 
// 0 1
// 0 2
// 1 3
// 3 4

// Graph Representation:
// 0 -> 1 2 
// 1 -> 0 3 
// 2 -> 0
// 3 -> 1 4
// 4 -> 3

// Enter starting node for DFS: 0
// Pre-order Traversal: [0, 1, 3, 4, 2]
// Post-order Traversal: [4, 3, 1, 2, 0]

// D //////////////////////////////////////
// Enter number of vertices: 4 
// Enter number of edges: 3
// Is the graph directed? (true/false): true
// Enter edges (u v):
// 0 1
// 0 2
// 1 3

// Graph Representation:
// 0 -> 1 2
// 1 -> 3
// 2 ->
// 3 ->

// Enter starting node for DFS: 0
// Pre-order Traversal: [0, 1, 3, 2]
// Post-order Traversal: [3, 1, 2, 0]