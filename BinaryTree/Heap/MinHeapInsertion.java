package Heap;

import java.util.*;

// TreeNode for Heap (Binary Heap stored as array)
class MinHeap 
{
    List<Integer> heap;

    public MinHeap() 
    {
        heap = new ArrayList<>();
    }

    // Insert into Min-Heap
    public void insert(int val) 
    {
        heap.add(val);
        int i = heap.size() - 1;
        // Heapify Up
        while (i > 0) 
        {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) 
            {
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

    // Traversals (for visual comparison)
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

public class MinHeapInsertion 
{
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
        MinHeap heap = new MinHeap();

        // Insert elements
        for (String p : parts) 
        {
            if (!p.equalsIgnoreCase("null")) 
            {
                heap.insert(Integer.parseInt(p));
            }
        }

        // Print initial heap
        System.out.println("Heap as Array: " + heap.heapToString());

        // Insert new element
        System.out.println("Enter any element to insert:");
        int newVal = sc.nextInt();
        heap.insert(newVal);

        // Print after insertion
        System.out.println("Heap after insertion: " + heap.heapToString());

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
// Heap as Array: [1, 2, 5, 4]
// Enter any element to insert:
// 3
// Heap after insertion: [1, 2, 5, 4, 3]
// Preorder:
// 1 2 4 3 5
// Inorder:
// 4 2 3 1 5
// Postorder:
// 4 3 2 5 1