package BackTracking;

import java.util.*;


public class B2_SubsetSumChecker1 
{
    public static boolean canPartition(int[] nums) 
    {
        int totalSum = 0;

        for (int num : nums) 
        {
            totalSum = totalSum + num;
        }
        
        if (totalSum % 2 != 0) return false;
        
        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true; 
        
        for (int num : nums) 
        {
            for (int j = target; j >= num; j--) 
            {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) 
        {
            nums[i] = sc.nextInt();
        }
        sc.close();
        
        boolean canPartition = canPartition(nums);
        
        if (canPartition) 
        {
            System.out.println("YES");
        } 
        else 
        {
            System.out.println("NO");
        }
    }
}
// Enter number of elements: 4
// Enter 4 numbers:
// 1 2 3 5
// NO

// Enter number of elements: 4 
// Enter 4 numbers:
// 1 5 11 5
// YES

//L416