package Heap.HeapSort;

import java.util.*;

public class CharHeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] arr = new char[n];

        System.out.println("Enter " + n + " characters:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0); // read single character
        }

        // Min-Heap for ascending order
        PriorityQueue<Character> minHeap = new PriorityQueue<>();

        // Max-Heap for descending order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all characters
        for (char ch : arr) {
            minHeap.add(ch);
            maxHeap.add(ch);
        }

        // Extract ascending
        char[] ascending = new char[n];
        int i = 0;
        while (!minHeap.isEmpty()) {
            ascending[i++] = minHeap.poll();
        }

        // Extract descending
        char[] descending = new char[n];
        int j = 0;
        while (!maxHeap.isEmpty()) {
            descending[j++] = maxHeap.poll();
        }

        System.out.println("Ascending Order:  " + Arrays.toString(ascending));
        System.out.println("Descending Order: " + Arrays.toString(descending));

        sc.close();
    }
}
// Enter number of characters: 4 
// Enter 4 characters:
// e t T J
// Ascending Order:  [J, T, e, t]
// Descending Order: [t, e, T, J]