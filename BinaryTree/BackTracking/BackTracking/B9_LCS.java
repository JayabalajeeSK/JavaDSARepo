package BackTracking;
import java.util.Scanner;

public class B9_LCS 
{
    public int longestCommonSubsequence(String text1, String text2)  // Leetcode 1143
    {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) 
        {
            for (int j = 1; j <= n; j++) 
            {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) 
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                else 
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String text2 = sc.nextLine();

        B9_LCS obj = new B9_LCS();
        int result = obj.longestCommonSubsequence(text1, text2);

        System.out.println("Length of Longest Common Subsequence: " + result);
        
        sc.close();
    }
}
// Enter first string: acb
// Enter second string: ab
// Length of Longest Common Subsequence: 2

// Enter first string: acb
// Enter second string: ba
// Length of Longest Common Subsequence: 1