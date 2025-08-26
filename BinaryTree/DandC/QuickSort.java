package DandC;

import java.util.*;

public class QuickSort
{
    // Partition function
    public static int partition(Integer[] arr, int low, int high) 
    {
        int pivot = arr[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (arr[j] <= pivot) 
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort (Recursive)
    public static void quickSort(Integer[] arr, int low, int high) 
    {
        if (low < high) 
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Main Method
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

        // Remove nulls before sorting
        List<Integer> list = new ArrayList<>();
        for (Integer val : arr)
        {
            if (val != null) list.add(val);
            {
                arr = list.toArray(new Integer[0]);
            }

        } 
    
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(arr));

        sc.close();
    }
}
// Enter array (example: ["10","20","30","40"]): 10 20 40 30 80 60
// Original array: [10, 20, 40, 30, 80, 60]
// Sorted array:   [10, 20, 30, 40, 60, 80]