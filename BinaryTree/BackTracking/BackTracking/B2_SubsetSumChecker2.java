package BackTracking;

import java.util.*;

public class B2_SubsetSumChecker2 
{

    public static boolean isSubsetSum(int[] nums, int target) 
    {
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

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();
        sc.close();

        boolean result = isSubsetSum(nums, target);

        System.out.println(result); // True or False
    }
}
// Enter number of elements: 4
// Enter 4 numbers:
// 1 7 3 7
// Enter the target sum: 14
// true

// Enter 4 numbers:
// 1 55 78 2
// Enter the target sum: 4
// false

// Enter 4 numbers:
// 1 3 5 1
// Enter the target sum: 2
// true