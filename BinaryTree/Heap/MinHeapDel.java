package Heap;

import java.util.*;

class MinHeap 
{
    private List<Integer> heap;

    public MinHeap() 
    {
        heap = new ArrayList<>();
    }

    // Insert element into Min-Heap
    public void insert(int val) 
    {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Delete root (smallest element)
    public int deleteRoot() 
    {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) 
        {
            heap.sket(0, last);
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
        if (i > 0 && heap.get(i) < heap.get(parent)) 
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
        int smallest = i;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;

        if (smallest != i) 
        {
            Collections.swap(heap, i, smallest);
            heapifyDown(smallest);
        }
    }

    // Peek at root (smallest element)
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

public class MinHeapDel 
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

        // Insert elements into MinHeap
        for (String p : parts) 
        {
            if (!p.equalsIgnoreCase("null")) 
            {
                heap.insert(Integer.parseInt(p));
            }
        }

        // Print initial heap
        System.out.println("Min-Heap as Array: " + heap.heapToString());

        // Peek and delete demo
        if (heap.size() > 0) 
        {
            System.out.println("Peek root (smallest): " + heap.peek());
            System.out.println("Delete root: " + heap.deleteRoot());
            System.out.println("Heap after deletion: " + heap.heapToString());
        }
        sc.close();
    }
}

