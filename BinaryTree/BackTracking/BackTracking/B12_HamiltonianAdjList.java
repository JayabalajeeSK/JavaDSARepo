package BackTracking;

import java.util.*;

public class B12_HamiltonianAdjList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        System.out.println("Enter number of edges:");
        int e = sc.nextInt();
        System.out.println("Enter edges (u v) 0-indexed:");
        for (int i = 0; i < e; i++) 
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }

        int[] path = new int[n];
        Arrays.fill(path, -1);
        path[0] = 0; 

        if (hamiltonian(graph, path, 1)) 
        {
            System.out.println("Hamiltonian Cycle exists:");
            for (int v : path) System.out.print(v + " ");
            System.out.println(path[0]); // complete the cycle
        } 
        else 
        {
            System.out.println("No Hamiltonian Cycle exists");
        }
        sc.close();
    }

    static boolean hamiltonian(List<List<Integer>> graph, int[] path, int pos) {
        int n = graph.size();
        if (pos == n) 
        {
            return graph.get(path[pos - 1]).contains(path[0]);
        }

        for (int v = 1; v < n; v++) 
        {
            if (isSafe(v, graph, path, pos)) 
            {
                path[pos] = v;
                System.out.println("Trying vertex " + v + " at position " + pos);
                if (hamiltonian(graph, path, pos + 1)) 
                {
                    return true;
                }
                path[pos] = -1; // backtrack
                System.out.println("Backtracking from vertex " + v + " at position " + pos);
            }
        }
        return false;
    }

    static boolean isSafe(int v, List<List<Integer>> graph, int[] path, int pos) 
    {
        for (int i = 0; i < pos; i++) if (path[i] == v) return false;

        return graph.get(path[pos - 1]).contains(v);
    }
}
// Enter number of edges:
// 5
// Enter edges (u v) 0-indexed:
// 0 1
// 0 2
// 1 2
// 1 3
// 2 3
// Trying vertex 1 at position 1
// Trying vertex 2 at position 2
// Trying vertex 3 at position 3
// Backtracking from vertex 3 at position 3
// Backtracking from vertex 2 at position 2
// Trying vertex 3 at position 2
// Trying vertex 2 at position 3
// Hamiltonian Cycle exists:
// 0 1 3 2 0