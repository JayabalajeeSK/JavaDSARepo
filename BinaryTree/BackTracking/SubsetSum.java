package BackTracking;

import java.util.*;

public class SubsetSum 
{
    public static boolean findSubset(int[] set, int target) 
    {
        List<Integer> current = new ArrayList<>();
        return backtrack(set, target, 0, 0, current);
    }

    private static boolean backtrack(int[] set, int target, int index, int currentSum, List<Integer> current) 
    {
        if (currentSum == target) 
        {
            System.out.print("Subset found: [");
            for (int num : current) 
            {
                System.out.print(" " + num + " ");
            }
            System.out.println("]");
            return true;   
        }

        if (currentSum > target || index >= set.length) 
        {
            return false;
        }


        current.add(set[index]);
        if (backtrack(set, target, index + 1, currentSum + set[index], current)) 
        {
            return true;
        }

    
        current.remove(current.size() - 1);
        return backtrack(set, target, index + 1, currentSum, current);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] set = new int[n];

        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) 
        {
            set[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        boolean result = findSubset(set, sum);
        if (!result) 
        {
            System.out.println("False");
        }
        else
        {
            System.out.println("True");

        }

        sc.close();
    }
}
// Enter number of elements: 4
// Enter elements: 1 3 5 2
// Enter target sum: 10
// Subset found: [ 3  5  2 ]
// True

// Enter number of elements: 5
// Enter elements: 1 4 6 8 9
// Enter target sum: 29
// False