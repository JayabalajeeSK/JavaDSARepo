package BackTracking;

import java.util.*;

public class B11_GraphColoring {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int V;

    static boolean isSafe(int v, int color[], int c) 
    {
        for (int neighbor : graph.get(v)) 
        {
            if (color[neighbor] == c)
                return false;
        }
        return true;
    }


    static boolean colorGraph(int v, int m, int color[]) 
    {
        if (v == V) return true; 

        for (int c = 1; c <= m; c++) 
        {
            if (isSafe(v, color, c))
            {
                color[v] = c;
                if (colorGraph(v + 1, m, color))
                    return true;
                color[v] = 0; // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        for (int i = 0; i < V; i++)
            graph.put(i, new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();

        int[] color = new int[V];

        if (colorGraph(0, m, color)) {
            System.out.println("\n Solution Exists. Colors are:");
            for (int i = 0; i < V; i++)
                System.out.println("Vertex " + i + " → Color " + color[i]);
        } else {
            System.out.println("\n No solution exists.");
        }
        sc.close();
    }
}

// Enter number of vertices: 4
// Enter number of edges: 5
// Enter edges (u v):
// 0 1
// 0 2
// 0 3
// 1 2
// 2 3
// Enter number of colors: 3

//  Solution Exists. Colors are:
// Vertex 0 ? Color 1
// Vertex 1 ? Color 2
// Vertex 2 ? Color 3
// Vertex 3 ? Color 2