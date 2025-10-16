package Heap.HeapSort;

import java.util.*;

public class MaxMinHeapSort 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Using ArrayList instead of array
        ArrayList<Integer> arrList = new ArrayList<>();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            arrList.add(sc.nextInt());
        }
        
        // arrList.add(0,3);

        // Min Heap and Max Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to both heaps
        for (int num : arrList) 
        {
            minHeap.add(num);
            maxHeap.add(num);
        }

        System.out.println("Min heap: " + minHeap);
        System.out.println("Max heap: " + maxHeap);

        // Example of add(index, element)
        // arrList.add(0, 3); // Adds 3 at the beginning
        // System.out.println("After add(0, 3): " + arrList);

        // Example of add(element)
        // minHeap.add(3); // Adds 7 at the end
        // maxHeap.add(3);
        minHeap.remove(Integer.valueOf(5));
        maxHeap.remove(Integer.valueOf(5));
        System.out.println("Min heap: " + minHeap);
        System.out.println("Max heap: " + maxHeap);

        // Example of remove(element)
        // arrList.remove(Integer.valueOf(5)); // Removes element 5 if it exists
        // System.out.println("After remove(5): " + arrList);

        // Build ascending order from minHeap
        ArrayList<Integer> ascending = new ArrayList<>();
        while (!minHeap.isEmpty()) 
        {
            ascending.add(minHeap.poll());
        }

        // Build descending order from maxHeap
        ArrayList<Integer> descending = new ArrayList<>();
        while (!maxHeap.isEmpty()) 
        {
            descending.add(maxHeap.poll());
        }

        System.out.println("Ascending Order:  " + ascending);
        System.out.println("Descending Order: " + descending);

        sc.close();
    }
}
