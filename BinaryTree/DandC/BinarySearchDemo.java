package DandC;

import java.util.*;

public class BinarySearchDemo 
{
    // Iterative Binary Search
    public static int binarySearchIterative(Integer[] arr, int target) 
    {
        int left = 0, right = arr.length - 1;
        while (left <= right) 
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == null) return -1; 

            if (arr[mid] == target) return mid;

            else if (arr[mid] < target) left = mid + 1;
            
            else right = mid - 1;
        }
        return -1;
    }

    // Recursive Binary Search
    public static int binarySearchRecursive(Integer[] arr, int target, int left, int right) 
    {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == null) return -1; 

        if (arr[mid] == target) return mid;

        else if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
        
        else  return binarySearchRecursive(arr, target, left, mid - 1);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array (example: [\"10\",\"20\",\"30\",\"40\"]): ");
        String raw = sc.nextLine();

        String clean = raw.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(",", " ")
                .trim()
                .replaceAll("\\s+", " ");

        String[] parts = clean.split(" ");
        Integer[] arr = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) 
        {
            if (parts[i].equalsIgnoreCase("null")) arr[i] = null;
            else arr[i] = Integer.parseInt(parts[i]);
        }

        // Sort array (Binary search needs sorted data)
        Arrays.sort(arr, Comparator.nullsLast(Integer::compareTo));
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Iterative Search
        int iterResult = binarySearchIterative(arr, target);
        System.out.println("Iterative → " + (iterResult != -1 ? "Found at index " + iterResult : "Not found"));

        // Recursive Search
        int recResult = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("Recursive → " + (recResult != -1 ? "Found at index " + recResult : "Not found"));

        sc.close();
    }
}
// Enter array (example: ["10","20","30","40"]): 10 20 40 30 80 60
// Sorted array: [10, 20, 30, 40, 60, 80]
// Enter target value: 60
// Iterative ? Found at index 4
// Recursive ? Found at index 4