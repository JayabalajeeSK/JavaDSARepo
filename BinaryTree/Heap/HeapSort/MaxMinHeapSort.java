package Heap.HeapSort;

import java.util.*;

public class MaxMinHeapSort 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    
        for (int num : arr) 
        {
            minHeap.add(num);
            maxHeap.add(num);
        }

        int[] ascending = new int[arr.length];
        int i = 0;
        while (!minHeap.isEmpty()) 
        {
            ascending[i] = minHeap.poll();
            i++;
        }


        int[] descending = new int[arr.length];
        int j = 0;
        while (!maxHeap.isEmpty()) 
        {
            descending[j] = maxHeap.poll();
            j++;
        }
        System.out.println("Ascending Order:  " + Arrays.toString(ascending));
        System.out.println("Descending Order: " + Arrays.toString(descending));

        sc.close();
    }
    
}
// Enter number of elements: 6
// Enter 6 elements:
// 1 5 2 8 4 9
// Ascending Order:  [1, 2, 4, 5, 8, 9]
// Descending Order: [9, 8, 5, 4, 2, 1]
