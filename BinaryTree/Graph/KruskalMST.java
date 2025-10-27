package Graph;

import java.util.*;

class Edge implements Comparable<Edge> 
{
    int src, dest, weight;

    Edge(int s, int d, int w) 
    {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge other) 
    {
        return this.weight - other.weight;
    }
}

public class KruskalMST 
{


    static int find(int[] parent, int i) 
    {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static void union(int[] parent, int[] rank, int x, int y) 
    {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;

        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        
        else 
        {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // Kruskal algorithm
    static void kruskal(List<Edge> edges, int V) 
    {
        Collections.sort(edges); 
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) 
        {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

    
        for (Edge edge : edges) 
        {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

       
            if (rootSrc != rootDest) 
            {
                mst.add(edge);
                totalWeight = totalWeight + edge.weight;
                union(parent, rank, rootSrc, rootDest);
            }
        }

       
        System.out.println("\nEdges in MST:");
        for (Edge e : mst)
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);

        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(s, d, w));
        }
        sc.close();

        kruskal(edges, V);
    }
}
