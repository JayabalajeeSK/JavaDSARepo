package Heap.HeapSort;

import java.util.*;

public class MaxMinHeapSort 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Using ArrayList instead of array - reason Dynamic
        ArrayList<Integer> arrList = new ArrayList<>();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            arrList.add(sc.nextInt());
        }
        
        // arrList.add(0,3); // Heapify ip

        // Min Heap and Max Heap 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Heapify
        for (int num : arrList) 
        {
            minHeap.add(num);
            maxHeap.add(num);
        }

        System.out.println("Min heap: " + minHeap); //Level Order - BFS
        System.out.println("Max heap: " + maxHeap); //Level Order - BFS

        // Heapify Up
        minHeap.add(3); 
        maxHeap.add(3);
        System.out.println("Min heap: " + minHeap);
        System.out.println("Max heap: " + maxHeap);

        // Heapify Down
        minHeap.remove(Integer.valueOf(5));
        maxHeap.remove(Integer.valueOf(5));
        System.out.println("Min heap: " + minHeap);
        System.out.println("Max heap: " + maxHeap);


        // Tree Traversals
        ArrayList<Integer> minHeapList = new ArrayList<>(minHeap);
        ArrayList<Integer> maxHeapList = new ArrayList<>(maxHeap);

        System.out.println("\nMin Heap Preorder:");
        preorder(minHeapList, 0);

        System.out.println("\nMin Heap Inorder:");
        inorder(minHeapList, 0);

        System.out.println("\nMin Heap Postorder:");
        postorder(minHeapList, 0);

        System.out.println("\nMax Heap Preorder:");
        preorder(maxHeapList, 0);

        System.out.println("\nMax Heap Inorder:");
        inorder(maxHeapList, 0);

        System.out.println("\nMax Heap Postorder:");
        postorder(maxHeapList, 0);


        //Heap Sort
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
    // Preorder
    public static void preorder(ArrayList<Integer> heap, int i) 
    {
        if (i >= heap.size()) return;
        System.out.print(heap.get(i) + " ");
        preorder(heap, 2 * i + 1);
        preorder(heap, 2 * i + 2);
    }

    // Inorder
    public static void inorder(ArrayList<Integer> heap, int i) 
    {
        if (i >= heap.size()) return;
        inorder(heap, 2 * i + 1);
        System.out.print(heap.get(i) + " ");
        inorder(heap, 2 * i + 2);
    }

    // Postorder
    public static void postorder(ArrayList<Integer> heap, int i) 
    {
        if (i >= heap.size()) return;
        postorder(heap, 2 * i + 1);
        postorder(heap, 2 * i + 2);
        System.out.print(heap.get(i) + " ");
    }
}
// Enter number of elements: 4
// Enter 4 elements:
// 1 4 5 2

// Min heap: [1, 2, 5, 4]
// Max heap: [5, 2, 4, 1]

// Min heap: [1, 2, 5, 4, 3]
// Max heap: [5, 3, 4, 1, 2]

// Min heap: [1, 2, 3, 4]
// Max heap: [4, 3, 2, 1]

// Min Heap Preorder:
// 1 2 4 3
// Min Heap Inorder:
// 4 2 1 3
// Min Heap Postorder:
// 4 2 3 1
// Max Heap Preorder:
// 4 3 1 2
// Max Heap Inorder:
// 1 3 4 2
// Max Heap Postorder:
// 1 3 2 4 

// Ascending Order:  [1, 2, 3, 4]
// Descending Order: [4, 3, 2, 1]