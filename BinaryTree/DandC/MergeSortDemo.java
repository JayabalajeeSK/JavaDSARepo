package DandC;

import java.util.*;

public class MergeSortDemo 
{
    // Merge function
    public static void merge(Integer[] arr, int left, int mid, int right) 
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];

        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Merge Sort 
    public static void mergeSort(Integer[] arr, int left, int right) 
    {
        if (left < right) 
        {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
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

        // remove null
        List<Integer> list = new ArrayList<>();
        for (Integer val : arr) 
        {
            if (val != null) 
            {
                list.add(val);
            }
        }
        arr = list.toArray(new Integer[0]);

        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(arr));

        sc.close();
    }
}
// Enter array (example: ["10","20","30","40"]): 10 20 40 30 80 60
// Original array: [10, 20, 40, 30, 80, 60]
// Sorted array:   [10, 20, 30, 40, 60, 80]