package BackTracking;

import java.util.*;

public class UniquePathsMatrix 
{

    // Function to find all paths from top-left to bottom-right
    public static void findPaths(int[][] matrix, int i, int j, List<Integer> path, List<List<Integer>> result) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Add current cell to path
        path.add(matrix[i][j]);

        // If reached bottom-right, add path to result
        if (i == m - 1 && j == n - 1) 
        {
            result.add(new ArrayList<>(path));
        } 
        else 
        {
            // Move Down
            if (i + 1 < m) 
            {
                findPaths(matrix, i + 1, j, path, result);
            }
            // Move Right
            if (j + 1 < n) 
            {
                findPaths(matrix, i, j + 1, path, result);
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> allPaths(int[][] matrix) 
    {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(matrix, 0, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        int val = 1; //
        System.out.println("Enter the matrix elements row-wise:");
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                matrix[i][j] = val++; //sc.nextInt();
            }
        }
        sc.close();

        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                System.out.print(matrix[i][j]); //sc.nextInt();
            }
            System.out.println();
        }

        List<List<Integer>> paths = allPaths(matrix);

        System.out.println("All possible paths:");
        for (List<Integer> path : paths) 
        {
            System.out.println(path);
        }
        System.out.println(paths.size());
    }
}

//
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];

//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 if(i==0 || j==0) dp[i][j] =1;
//                 else
//                 dp[i][j]  = dp[i-1][j] + dp[i][j-1];
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }