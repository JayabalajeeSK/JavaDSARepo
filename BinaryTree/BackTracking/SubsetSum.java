package BackTracking;

import java.util.*;

public class SubsetSum 
{
    public static void findSubsets(int[] set, int target) 
    {
        List<Integer> current = new ArrayList<>();

        List<List<Integer>> results = new ArrayList<>();

        backtrack(set, target, 0, 0, current, results);

        for (List<Integer> subset : results) 
        {
            System.out.print("[");
            for (int num : subset) 
            {
                System.out.print(" "+ num + " ");
            }
            System.out.print("]");
        }
    }

    private static void backtrack(int[] set, int target, int index, int currentSum, 
                                  List<Integer> current, List<List<Integer>> results) 
    {
        if (currentSum == target) 
        {
            results.add(new ArrayList<>(current));
            return;
        }

        if (currentSum > target || index >= set.length) 
        {
            return;
        }

        current.add(set[index]);
        backtrack(set, target, index + 1, currentSum + set[index], current, results);

        current.remove(current.size() - 1);
        backtrack(set, target, index + 1, currentSum, current, results);
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

        findSubsets(set, sum);

        sc.close();
    }
}
// Enter number of elements: 3
// Enter elements: 1 2 1
// Enter target sum: 3
// [ 1  2 ][ 2  1 ]