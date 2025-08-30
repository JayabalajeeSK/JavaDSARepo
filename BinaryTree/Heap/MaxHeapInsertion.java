package Heap;

import java.util.*;

class MaxHeap 
{
    List<Integer> heap;

    public MaxHeap() 
    {
        heap = new ArrayList<>();
    }

    // Insert into Max-Heap
    public void insert(int val) 
    {
        heap.add(val);
        int i = heap.size() - 1;
        // Heapify Up
        while (i > 0) 
        {
            int parent = (i - 1) / 2;
            if (heap.get(i) > heap.get(parent)) 
            {  // only change: ">" instead of "<"
                Collections.swap(heap, i, parent);
                i = parent;
            } 
            else break;
        }
    }

    // Print Heap as Array
    public String heapToString() 
    {
        return heap.toString();
    }

    // Traversals (for comparison with trees)
    public void preorder(int i) 
    {
        if (i >= heap.size()) return;
        System.out.print(heap.get(i) + " ");
        preorder(2 * i + 1);
        preorder(2 * i + 2);
    }

    public void inorder(int i) 
    {
        if (i >= heap.size()) return;
        inorder(2 * i + 1);
        System.out.print(heap.get(i) + " ");
        inorder(2 * i + 2);
    }

    public void postorder(int i) 
    {
        if (i >= heap.size()) return;
        postorder(2 * i + 1);
        postorder(2 * i + 2);
        System.out.print(heap.get(i) + " ");
    }
}

public class MaxHeapInsertion {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Input format
        System.out.println("Enter array input (like [\"3\",\"9\",\"20\",\"15\",\"7\"]):");
        String raw = sc.nextLine();

        // Clean input
        String clean = raw.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(",", " ")
                .trim()
                .replaceAll("\\s+", " ");

        String[] parts = clean.split(" ");
        
        MaxHeap heap = new MaxHeap();

        // Insert elements
        for (String p : parts) {
            if (!p.equalsIgnoreCase("null")) 
            {
                heap.insert(Integer.parseInt(p));
            }
        }

        // Print initial heap
        System.out.println("Max-Heap as Array: " + heap.heapToString());

        // Insert new element
        System.out.println("Enter any element to insert:");
        int newVal = sc.nextInt();
        heap.insert(newVal);

        // Print after insertion
        System.out.println("Max-Heap after insertion: " + heap.heapToString());

        // Traversals
        System.out.println("Preorder:");
        heap.preorder(0);
        System.out.println();

        System.out.println("Inorder:");
        heap.inorder(0);
        System.out.println();

        System.out.println("Postorder:");
        heap.postorder(0);
        System.out.println();

        sc.close();
    }
}
// Enter array input (like ["3","9","20","15","7"]):
// 1 4 5 2
// Max-Heap as Array: [5, 2, 4, 1]
// Enter any element to insert:
// 3
// Max-Heap after insertion: [5, 3, 4, 1, 2]
// Preorder:
// 5 3 1 2 4
// Inorder:
// 1 3 2 5 4
// Postorder:
// 1 2 3 4 5
