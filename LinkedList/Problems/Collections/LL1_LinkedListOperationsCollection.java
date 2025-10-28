package Problems.Collections;

import java.util.*;

public class LL1_LinkedListOperationsCollection 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();

        // Input elements
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            list.add(sc.nextInt());
        }

        // Display LinkedList
        display(list);

        // Count and Sum
        System.out.println("Total Nodes: " + list.size());
        System.out.println("Sum of All Elements: " + sumOfNodes(list));

        // Search Element
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        searchElement(list, key);

        // Max and Min
        System.out.println("Maximum Element: " + Collections.max(list));
        System.out.println("Minimum Element: " + Collections.min(list));

        // Insert at beginning
        System.out.print("Enter element to insert at beginning: ");
        int first = sc.nextInt();
        list.addFirst(first);
        display(list);

        // Insert at end
        System.out.print("Enter element to insert at end: ");
        int last = sc.nextInt();
        list.addLast(last);
        display(list);

        // Insert at specific position
        System.out.print("Enter element and position to insert: ");
        int value = sc.nextInt();
        int pos = sc.nextInt();
        insertAtPosition(list, value, pos);
        display(list);

        // Sort ascending
        Collections.sort(list);
        System.out.println("Sorted Ascending:");
        display(list);

        // Sort descending
        list.sort(Collections.reverseOrder());
        System.out.println("Sorted Descending:");
        display(list);

        // Delete first
        System.out.println("Deleted element: " + list.removeFirst());
        display(list);

        // Delete last
        System.out.println("Deleted element: " + list.removeLast());
        display(list);

        // Delete at specific position
        System.out.print("Enter position to delete: ");
        int posDel = sc.nextInt();
        deleteAtPosition(list, posDel);
        display(list);

        // Delete by value
        System.out.print("Enter value to delete: ");
        int keyDel = sc.nextInt();
        deleteByValue(list, keyDel);
        display(list);

        sc.close();
    }

    // ---------- METHODS ----------

    static void display(LinkedList<Integer> list) 
    {
        System.out.print("Linked List: ");
        for (int num : list) 
        {
            System.out.print(num + " -> ");
        }
        System.out.println("null");
    }

    static int sumOfNodes(LinkedList<Integer> list) 
    {
        int sum = 0;
        for (int num : list) 
        {
            sum = sum + num;
        }
        return sum;
    }

    static void searchElement(LinkedList<Integer> list, int key) 
    {
        int pos = list.indexOf(key);
        if (pos != -1) System.out.println("Element " + key + " found at position " + (pos + 1));
        else System.out.println("Element " + key + " not found.");
    }

    static void insertAtPosition(LinkedList<Integer> list, int data, int pos) 
    {
        if (pos < 1 || pos > list.size() + 1) 
        {
            System.out.println("Position out of range! Node added at end.");
            list.add(data);
        } 
        else 
        {
            list.add(pos - 1, data);
        }
    }

    static void deleteAtPosition(LinkedList<Integer> list, int pos) 
    {
        if (pos < 1 || pos > list.size()) 
        {
            System.out.println("Invalid position!");
        } 
        else 
        {
            System.out.println("Deleted element: " + list.remove(pos - 1));
        }
    }

    static void deleteByValue(LinkedList<Integer> list, int key) 
    {
        if (list.remove((Integer) key)) 
        {
            System.out.println("Deleted element: " + key);
        } 
        else 
        {
            System.out.println("Element " + key + " not found!");
        }
    }
}
// Enter number of nodes: 5

// Enter 5 elements:
// 30 10 20 02 04

// Linked List: 30 -> 10 -> 20 -> 2 -> 4 -> null

// Total Nodes: 5

// Sum of All Elements: 66

// Enter element to search: 04
// Element 4 found at position 5

// Maximum Element: 30
// Minimum Element: 2

// Enter element to insert at beginning: 90
// Linked List: 90 -> 30 -> 10 -> 20 -> 2 -> 4 -> null

// Enter element to insert at end: 10
// Linked List: 90 -> 30 -> 10 -> 20 -> 2 -> 4 -> 10 -> null

// Enter element and position to insert: 50 5
// Linked List: 90 -> 30 -> 10 -> 20 -> 50 -> 2 -> 4 -> 10 -> null

// Sorted Ascending:
// Linked List: 2 -> 4 -> 10 -> 10 -> 20 -> 30 -> 50 -> 90 -> null

// Sorted Descending:
// Linked List: 90 -> 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> 2 -> null

// Deleted element: 90
// Linked List: 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> 2 -> null

// Deleted element: 2
// Linked List: 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> null

// Enter position to delete: 3
// Deleted element: 20
// Linked List: 50 -> 30 -> 10 -> 10 -> 4 -> null

// Enter value to delete: 10
// Deleted element: 10
// Linked List: 50 -> 30 -> 10 -> 4 -> null