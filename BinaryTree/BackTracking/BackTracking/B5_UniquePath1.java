package BackTracking;
import java.util.Scanner;

public class B5_UniquePath1 
{
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (i == 0 || j == 0) 
                {
                    dp[i][j] = 1;
                } 
                else 
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        B5_UniquePath1 sol = new B5_UniquePath1();
        int result = sol.uniquePaths(m, n);

        System.out.println("Number of unique paths: " + result);
        sc.close();
    }
}

// Enter number of rows (m): 2
// Enter number of columns (n): 2
// Number of unique paths: 2

// Enter number of rows: 2
// Enter number of columns: 2
// Enter the matrix elements row-wise:
// 12
// 34
// All possible paths:
// [1, 3, 4]
// [1, 2, 4]
// 2

//L62