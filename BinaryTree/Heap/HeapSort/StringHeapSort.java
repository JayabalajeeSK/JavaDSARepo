package Heap.HeapSort;

import java.util.*;

public class StringHeapSort 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] arr = new String[n];

        System.out.println("Enter " + n + " strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine(); 
        }

        // lexicographical
        PriorityQueue<String> minHeap = new PriorityQueue<>();

      
        PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : arr) {
            minHeap.add(str);
            maxHeap.add(str);
        }

        String[] ascending = new String[n];
        int i = 0;
        while (!minHeap.isEmpty()) {
            ascending[i++] = minHeap.poll();
        }


        String[] descending = new String[n];
        int j = 0;
        while (!maxHeap.isEmpty()) {
            descending[j++] = maxHeap.poll();
        }

        System.out.println("Ascending Order:  " + Arrays.toString(ascending));
        System.out.println("Descending Order: " + Arrays.toString(descending));

        sc.close();
    }
}
// Enter number of strings: 4
// Enter 4 strings:
// jaya
// bala
// tharun
// Jaya
// Ascending Order:  [Jaya, bala, jaya, tharun]
// Descending Order: [tharun, jaya, bala, Jaya]