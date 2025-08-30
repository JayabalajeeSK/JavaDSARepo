package Heap;

import java.util.*;

class MaxHeap 
{
    private List<Integer> heap;

    public MaxHeap() 
    {
        heap = new ArrayList<>();
    }

    // Insert element into Max-Heap
    public void insert(int val) 
    {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Delete root (largest element)
    public int deleteRoot() 
    {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) 
        {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    // Delet particular element
    public boolean deleteElement(int val) 
    {
        int index = heap.indexOf(val);  
        if (index == -1) return false;  

        int last = heap.remove(heap.size() - 1);  

        if (index < heap.size())  
        {
            heap.set(index, last);

            // restore heap property
            heapifyUp(index);
            heapifyDown(index);
        }

        return true; 
    }

    // Heapify Up (for insertion)
    private void heapifyUp(int i) 
    {
        int parent = (i - 1) / 2;
        if (i > 0 && heap.get(i) > heap.get(parent)) 
        {
            Collections.swap(heap, i, parent);
            heapifyUp(parent);
        }
    }

    // Heapify Down (for deletion)
    private void heapifyDown(int i) 
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) largest = left;
        if (right < heap.size() && heap.get(right) > heap.get(largest)) largest = right;

        if (largest != i) 
        {
            Collections.swap(heap, i, largest);
            heapifyDown(largest);
        }
    }

    // Peek at root (largest element)
    public int peek() 
    {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    // Display heap
    public String heapToString() 
    {
        return heap.toString();
    }

    // Size of heap
    public int size() 
    {
        return heap.size();
    }
}

public class MaxHeapDel 
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

        MaxHeap heap = new MaxHeap();

        // Insert elements into MaxHeap
        for (String p : parts) 
        {
            if (!p.equalsIgnoreCase("null")) 
            {
                heap.insert(Integer.parseInt(p));
            }
        }

        // Print initial heap
        System.out.println("Max-Heap as Array: " + heap.heapToString());

        // Peek and delete demo
        if (heap.size() > 0) 
        {
            System.out.println("Peek root (largest): " + heap.peek());
            System.out.println("Delete root: " + heap.deleteRoot());
            System.out.println("Heap after deletion: " + heap.heapToString());
        }
        sc.close();
    }
}

