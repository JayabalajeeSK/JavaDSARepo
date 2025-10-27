package BackTracking;

import java.util.*;

public class B1_SubsetGenerator 
{
    static List<List<Integer>> allSubsets = new ArrayList<>(); //Leetcode 90

    public static List<List<Integer>> generateSubsets(int[] numbers) //
    {
        allSubsets.clear();
        findSubsets(numbers, 0, new ArrayList<>());
        return allSubsets;
    }

    public static void findSubsets(int[] numbers, int index, List<Integer> currentSubset) //
    {
        if (index == numbers.length) 
        {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.add(numbers[index]);

        findSubsets(numbers, index + 1, currentSubset);

        currentSubset.remove(currentSubset.size() - 1);

        findSubsets(numbers, index + 1, currentSubset);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        List<List<Integer>> subsets = generateSubsets(numbers);
        System.out.println("\nAll possible subsets:");
        for (List<Integer> subset : subsets) 
        {
            System.out.println(subset);
        }
    }
}
// Enter number of elements: 2
// Enter 2 integers:
// 6 7

// All possible subsets:
// [6, 7]
// [6]
// [7]
// []


// Enter number of elements: 3
// Enter 3 integers:
// 1 2 3

// All possible subsets:
// [1, 2, 3]
// [1, 2]
// [1, 3]
// [1]
// [2, 3]
// [2]
// [3]
// []

// Enter number of elements: 2
// Enter 2 integers:
// 6 7

// All possible subsets:
// [6, 7]
// [6]
// [7]
// []