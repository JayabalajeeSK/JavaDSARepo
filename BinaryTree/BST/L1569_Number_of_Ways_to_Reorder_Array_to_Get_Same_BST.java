package BinaryTree.BST;

public class L1569_Number_of_Ways_to_Reorder_Array_to_Get_Same_BST 
{
    int MOD = 1000000007;
    public int numOfWays(int[] nums) 
    {
        int len = nums.length;
        long[][] dp = new long[len][len];
        dp[0][0] = 1;
        for (int i = 1; i < len; i++) 
        {
            for (int j = 0; j <= i; j++) 
            {
                if (i == 1 || j == 0) 
                {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }
        return (int)(dfs(nums, dp, len) - 1);
    }

    long dfs(int[] nums, long[][] dp, int len) 
    {
        if (len < 3) return 1;

        long answer = 1;

        int[] left = new int[len - 1];
        int leftLen = 0;

        int[] right = new int[len - 1];
        int rightLen = 0;

        for (int i = 1; i < len; i++) 
        {
            if (nums[0] > nums[i]) right[rightLen++] = nums[i];
            else left[leftLen++] = nums[i];
        }
        // System.out.println(leftLen + " " + (len - 1));
        // System.out.println(dp[len - 1][leftLen]);
        answer = (answer * dp[len - 1][leftLen]) % MOD;
        
        if (leftLen != 0)  answer = (answer * dfs(left, dp, leftLen)) % MOD;
        
        if (rightLen != 0) answer = (answer * dfs(right, dp, rightLen)) % MOD;
        
        return answer;
    }
    
}
