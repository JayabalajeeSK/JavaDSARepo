package Graph.Weight.DFS;
import java.util.*;

public class DFSGraphMatrix 
{
    private int[][] adjMatrix;
    private boolean isDirected;
    private int vertices;
    private String[] labels;

    private boolean[] visited;

    public DFSGraphMatrix(int vertices, boolean isDirected) 
    {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjMatrix = new int[vertices][vertices];
        labels = new String[vertices];
        visited = new boolean[vertices];
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

        if (!isDirected) {
            adjMatrix[v][u] = weight;
        }
    }

    public void printGraph() 
    {
        System.out.println("\nAdjacency Matrix:");
        System.out.print("    ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(labels[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) 
        {
            System.out.print(labels[i] + " | ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ---------- PRE-ORDER DFS ----------
    private void dfsPreUtil(int node, List<String> preOrder) 
    {
        visited[node] = true;
        preOrder.add(labels[node]);  // Pre-order step

        for (int j = 0; j < vertices; j++) 
        {
            if (adjMatrix[node][j] != 0 && !visited[j]) 
            {
                dfsPreUtil(j, preOrder);
            }
        }
    }

    public List<String> dfsPreOrder(int start) 
    {
        Arrays.fill(visited, false);
        List<String> preOrder = new ArrayList<>();

        dfsPreUtil(start, preOrder);

        // Handle disconnected graph
        for (int i = 0; i < vertices; i++) 
        {
            if (!visited[i]) dfsPreUtil(i, preOrder);
        }
        return preOrder;
    }

    // ---------- POST-ORDER DFS ----------
    private void dfsPostUtil(int node, List<String> postOrder) 
    {
        visited[node] = true;

        for (int j = 0; j < vertices; j++) {
            if (adjMatrix[node][j] != 0 && !visited[j]) 
            {
                dfsPostUtil(j, postOrder);
            }
        }

        postOrder.add(labels[node]);  // Post-order step
    }

    public List<String> dfsPostOrder(int start) 
    {
        Arrays.fill(visited, false);
        List<String> postOrder = new ArrayList<>();

        dfsPostUtil(start, postOrder);

        // Handle disconnected graph
        for (int i = 0; i < vertices; i++) 
        {
            if (!visited[i]) dfsPostUtil(i, postOrder);
        }
        return postOrder;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        DFSGraphMatrix graph = new DFSGraphMatrix(vertices, isDirected);

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

        System.out.print("\nEnter starting node for DFS: ");
        String startLabel = sc.next();
        int start = Arrays.asList(labels).indexOf(startLabel);

        System.out.println("Pre-order Traversal: " + graph.dfsPreOrder(start));
        System.out.println("Post-order Traversal: " + graph.dfsPostOrder(start));

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

// Adjacency Matrix:
//     A B C D
// A | 0 2 4 0
// B | 2 0 0 3
// C | 4 0 0 5
// D | 0 3 5 0

// Enter starting node for DFS: A
// Pre-order Traversal: [A, B, D, C]
// Post-order Traversal: [C, D, B, A]