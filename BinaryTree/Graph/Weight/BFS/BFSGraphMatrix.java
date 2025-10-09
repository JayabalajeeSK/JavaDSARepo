package Graph.Weight.BFS;
import java.util.*;

public class BFSGraphMatrix 
{
    private int[][] adjMatrix;    
    private boolean isDirected;
    private int vertices;
    private String[] labels;      

    public BFSGraphMatrix(int vertices, boolean isDirected) 
    {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjMatrix = new int[vertices][vertices];
        labels = new String[vertices];
    }

    public void setLabels(String[] labels) 
    {
        if (labels.length != vertices) 
        {
            throw new IllegalArgumentException("Number of labels must match vertices");
        }
        this.labels = labels;
    }

   
    public void addEdge(int u, int v, int weight) 
    {
        adjMatrix[u][v] = weight;

        if (!isDirected) 
        {
            adjMatrix[v][u] = weight;
        }
    }

    public void printGraph() 
    {
        System.out.println("\nAdjacency Matrix:");
        System.out.print("    ");
        for (int i = 0; i < vertices; i++) 
        {
            System.out.print(labels[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) 
        {
            System.out.print(labels[i] + " | ");
            for (int j = 0; j < vertices; j++) 
            {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) 
    {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("\nBFS Traversal starting from " + labels[start] + ": ");

        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            System.out.print(labels[node] + " ");

            for (int neighbor = 0; neighbor < vertices; neighbor++) 
            {
                if (adjMatrix[node][neighbor] != 0 && !visited[neighbor]) 
                {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        BFSGraphMatrix graph = new BFSGraphMatrix(vertices, isDirected);


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

        sc.close();
    }
}
// Enter number of vertices: 4
// Enter number of edges: 4
// Is the graph directed? (true/false): true
// Enter labels for vertices (like A B C ...):
// A B C D
// Enter edges (u v weight) using labels:
// A B 2
// A C 4
// B D 3
// C D 5

// Adjacency Matrix:
//     A B C D
// A | 0 2 4 0 
// B | 0 0 0 3
// C | 0 0 0 5
// D | 0 0 0 0

// Enter starting node for BFS: A

// BFS Traversal starting from A: A B C D

///////////////////////////////////////////

// Enter number of vertices: 5
// Enter number of edges: 6
// Is the graph directed? (true/false): true
// Enter labels for vertices (like A B C ...):
// A B C D E
// Enter edges (u v weight) using labels:
// A B 2
// A C 3
// B D 1
// C D 4
// C E 6
// D E 5

// Adjacency Matrix:
//     A B C D E
// A | 0 2 3 0 0
// B | 0 0 0 1 0
// C | 0 0 0 4 6
// D | 0 0 0 0 5
// E | 0 0 0 0 0

// Enter starting node for BFS: A

// BFS Traversal starting from A: A B C D E

/////////////////////////////////////////////////////

// Enter number of vertices: 5
// Enter number of edges: 6
// Is the graph directed? (true/false): true
// Enter labels for vertices (like A B C ...): 
// A B C D E
// Enter edges (u v weight) using labels:
// A B 2
// A C 3
// B D 1
// C D 4
// C E 6
// D E 5

// Graph Representation (Adjacency List):
// A -> (B, w=2) (C, w=3)
// B -> (D, w=1)
// C -> (D, w=4) (E, w=6)
// D -> (E, w=5)
// E ->

// Enter starting node for BFS: A

// BFS Traversal starting from A: A B C D E

/////////////////////////////////////////////

// Enter number of vertices: 5
// Enter number of edges: 6
// Is the graph directed? (true/false): true
// Enter vertex labels (like A B C ...): 
// A B C D E
// Enter edges (u v weight):
// A B 2
// A C 3
// B D 1
// C D 4
// C E 6
// D E 5

// Graph Representation:
// A -> (B,2) (C,3)
// B -> (D,1)
// C -> (D,4) (E,6)
// D -> (E,5)
// E ->

// Enter starting node for DFS: A
// Pre-order Traversal: [A, B, D, E, C]
// Post-order Traversal: [E, D, B, C, A]