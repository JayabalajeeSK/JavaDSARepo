package Graph.Weight.DFS;

import java.util.*;

public class DFSGraphList 
{
    private Map<String, List<Edge>> adjList;
    private boolean isDirected;
    private Set<String> visited;

    static class Edge 
    {
        String dest;
        int weight;
        Edge(String dest, int weight) 
        {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public DFSGraphList(boolean isDirected) 
    {
        adjList = new HashMap<>();
        this.isDirected = isDirected;
        visited = new HashSet<>();
    }

    public void addVertex(String vertex) 
    {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String u, String v, int weight) 
    {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(new Edge(v, weight));

        if (!isDirected) 
        {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(new Edge(u, weight));
        }
    }

    public void printGraph() 
    {
        for (String vertex : adjList.keySet()) 
        {
            System.out.print(vertex + " -> ");
            for (Edge edge : adjList.get(vertex)) 
            {
                System.out.print("(" + edge.dest + "," + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // ----------- PRE-ORDER DFS -----------
    private void dfsPreUtil(String node, List<String> preOrder) {
        visited.add(node);

        preOrder.add(node);  

        for (Edge edge : adjList.getOrDefault(node, new ArrayList<>())) 
        {
            if (!visited.contains(edge.dest)) 
            {
                dfsPreUtil(edge.dest, preOrder);
            }
        }
    }

    public List<String> dfsPreOrder(String start) 
    {
        visited.clear();
        List<String> preOrder = new ArrayList<>();

        dfsPreUtil(start, preOrder);

        for (String node : adjList.keySet()) 
        {
            if (!visited.contains(node)) dfsPreUtil(node, preOrder);
        }
        return preOrder;
    }

    private void dfsPostUtil(String node, List<String> postOrder) 
    {
        visited.add(node);

        for (Edge edge : adjList.getOrDefault(node, new ArrayList<>())) 
        {
            if (!visited.contains(edge.dest)) {
                dfsPostUtil(edge.dest, postOrder);
            }
        }

        postOrder.add(node);  // Post-order step
    }

    public List<String> dfsPostOrder(String start) 
    {
        visited.clear();
        List<String> postOrder = new ArrayList<>();

        dfsPostUtil(start, postOrder);

        for (String node : adjList.keySet()) 
        {
            if (!visited.contains(node)) dfsPostUtil(node, postOrder);
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

        DFSGraphList graph = new DFSGraphList(isDirected);

        System.out.println("Enter vertex labels (like A B C ...): ");
        for (int i = 0; i < vertices; i++) 
        {
            String vertex = sc.next();
            graph.addVertex(vertex);
        }

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < edges; i++) 
        {
            String u = sc.next();
            String v = sc.next();
            int weight = sc.nextInt();
            graph.addEdge(u, v, weight);
        }

        System.out.println("\nGraph Representation:");
        graph.printGraph();

        System.out.print("\nEnter starting node for DFS: ");
        String start = sc.next();

        System.out.println("Pre-order Traversal: " + graph.dfsPreOrder(start));
        System.out.println("Post-order Traversal: " + graph.dfsPostOrder(start));

        sc.close();
    }
}
// Enter number of vertices: 4
// Enter number of edges: 4
// Is the graph directed? (true/false): false
// Enter vertex labels (like A B C ...):
// A B C D
// Enter edges (u v weight):
// A B 2
// A C 4
// B D 3
// C D 5

// Graph Representation:
// A -> (B,2) (C,4)
// B -> (A,2) (D,3)
// C -> (A,4) (D,5)
// D -> (B,3) (C,5)

// Enter starting node for DFS: A
// Pre-order Traversal: [A, B, D, C]
// Post-order Traversal: [C, D, B, A]