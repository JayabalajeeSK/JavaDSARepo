package Problems.Collections;

import java.util.*;

public class LL2_SortedLinkedListCollections 
{
    LinkedList<Integer> list = new LinkedList<>();

    // Insert element in sorted order
    void insertSorted(int data, boolean ascending) 
    {
        list.add(data);
        if (ascending) Collections.sort(list);
        else list.sort(Collections.reverseOrder());
    }

    // Delete a specific element
    void deleteNode(int value) 
    {
        if (list.isEmpty()) 
        {
            System.out.println("List is empty!");
            return;
        }

        if (list.remove(Integer.valueOf(value))) System.out.println(value + " deleted.");
        else System.out.println("Value not found!");
    }

    // Delete all elements
    void deleteAll() 
    {
        list.clear();
        System.out.println("All elements deleted. List cleared!");
    }

    // Check if list is sorted (ascending or descending)
    void checkSorted() 
    {
        if (list.size() <= 1) 
        {
            System.out.println("List is sorted (single or empty).");
            return;
        }

        boolean ascending = true, descending = true;

        for (int i = 0; i < list.size() - 1; i++) 
        {
            if (list.get(i) > list.get(i + 1)) ascending = false;
            if (list.get(i) < list.get(i + 1)) descending = false;
        }

        if (ascending) System.out.println("List is sorted in Ascending order.");
        else if (descending) System.out.println("List is sorted in Descending order.");
        else System.out.println("List is NOT sorted.");
    }

    // Display the linked list
    void display() 
    {
        if (list.isEmpty()) 
        {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("Linked List: ");
        for (int val : list) 
        {
            System.out.print(val + " -> ");
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LL2_SortedLinkedListCollections obj = new LL2_SortedLinkedListCollections();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) 
        {
            int val = sc.nextInt();
            obj.list.add(val);
        }

        System.out.println("Enter sort order (asc / desc):");
        String order = sc.next().toLowerCase();
        boolean ascending = order.equals("asc");

        // Sort initially
        if (ascending) Collections.sort(obj.list);
        else obj.list.sort(Collections.reverseOrder());

        obj.display();
        obj.checkSorted();

        System.out.println("\nInsert a new element:");
        int newVal = sc.nextInt();
        obj.insertSorted(newVal, ascending);
        obj.display();
        obj.checkSorted();

        System.out.println("\nEnter element to delete:");
        int delVal = sc.nextInt();
        obj.deleteNode(delVal);
        obj.display();
        obj.checkSorted();

        System.out.println("\nDeleting all elements...");
        obj.deleteAll();
        obj.display();

        sc.close();
    }
}
// Enter number of elements:
// 5
// Enter elements:
// 30 10 20 02 04
// Enter sort order (asc / desc):
// asc
// Linked List: 2 -> 4 -> 10 -> 20 -> 30 -> null
// List is sorted in Ascending order.

// Insert a new element:
// 27 
// Linked List: 2 -> 4 -> 10 -> 20 -> 27 -> 30 -> null
// List is sorted in Ascending order.

// Enter element to delete:
// 20
// 20 deleted.
// Linked List: 2 -> 4 -> 10 -> 27 -> 30 -> null
// List is sorted in Ascending order.

// Deleting all elements...
// All elements deleted. List cleared!
// List is empty!

//-------------------------------

// Enter number of elements:
// 5
// Enter elements:
// 30 10 20 02 04
// Enter sort order (asc / desc):
// desc
// Linked List: 30 -> 20 -> 10 -> 4 -> 2 -> null
// List is sorted in Descending order.

// Insert a new element:
// 17
// Linked List: 30 -> 20 -> 17 -> 10 -> 4 -> 2 -> null
// List is sorted in Descending order.

// Enter element to delete:
// 20
// 20 deleted.
// Linked List: 30 -> 17 -> 10 -> 4 -> 2 -> null
// List is sorted in Descending order.

// Deleting all elements...
// All elements deleted. List cleared!
// List is empty!