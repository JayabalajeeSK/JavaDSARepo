package Problems.Custom;

import java.util.Scanner;

class Node 
{
    int data;
    Node next;

    Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

public class LL2_SortedLinkedListCustom 
{
    Node head;

    // Insert elements in sorted order
    void insertSorted(int data, boolean ascending) 
    {
        Node newNode = new Node(data);

        // Empty list or insert at head
        if (head == null || (ascending && data < head.data) || (!ascending && data > head.data)) 
        {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        // Find correct position
        while (temp.next != null && 
              ((ascending && temp.next.data < data) || (!ascending && temp.next.data > data))) 
        {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete a node by value
    void deleteNode(int value) 
    {
        if (head == null) 
        {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == value) 
        {
            head = head.next;
            System.out.println(value + " deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) 
        {
            temp = temp.next;
        }

        if (temp.next == null)
        {
            System.out.println("Value not found!");
        }
        else 
        {
            temp.next = temp.next.next;
            System.out.println(value + " deleted.");
        }
    }

    // Delete all nodes (clear list)
    void deleteAll() 
    {
        head = null;
        System.out.println("All elements deleted. List cleared!");
    }

    // Check if linked list is sorted (ascending or descending)
    void checkSorted() 
    {
        if (head == null || head.next == null) 
        {
            System.out.println("List is sorted (single or empty).");
            return;
        }

        boolean ascending = true, descending = true;
        Node temp = head;

        while (temp.next != null) 
        {
            if (temp.data > temp.next.data) ascending = false;
            if (temp.data < temp.next.data) descending = false;
            temp = temp.next;
        }

        if (ascending) System.out.println("List is sorted in Ascending order.");

        else if (descending) System.out.println("List is sorted in Descending order.");

        else System.out.println("List is NOT sorted.");
    }

    // Display the linked list
    void display() 
    {
        if (head == null) 
        {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LL2_SortedLinkedListCustom list = new LL2_SortedLinkedListCustom();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Enter sort order (asc / desc):");
        String order = sc.next().toLowerCase();
        boolean ascending = order.equals("asc");

        // Insert all elements in sorted order
        for (int num : arr)
        {
            list.insertSorted(num, ascending);
        }

        list.display();
        list.checkSorted();

        System.out.println("\nInsert a new element:");
        int newVal = sc.nextInt();
        list.insertSorted(newVal, ascending);
        list.display();
        list.checkSorted();

        System.out.println("\nEnter element to delete:");
        int delVal = sc.nextInt();
        list.deleteNode(delVal);
        list.display();
        list.checkSorted();

        System.out.println("\nDeleting all elements...");
        list.deleteAll();
        list.display();

        sc.close();
    }
}
// Enter number of elements:
// 5
// Enter elements:
// 30 10 20 02 4
// Enter sort order (asc / desc):
// asc
// Linked List: 2 -> 4 -> 10 -> 20 -> 30 -> null
// List is sorted in Ascending order.

// Insert a new element:
// 28 
// Linked List: 2 -> 4 -> 10 -> 20 -> 28 -> 30 -> null
// List is sorted in Ascending order.

// Enter element to delete:
// 4
// 4 deleted.
// Linked List: 2 -> 10 -> 20 -> 28 -> 30 -> null
// List is sorted in Ascending order.

// Deleting all elements...
// All elements deleted. List cleared!
// List is empty!

//-------------------------------------------------------------------------

// Enter number of elements:
// 5
// Enter elements:
// 30 10 20 02 4
// Enter sort order (asc / desc):
// desc
// Linked List: 30 -> 20 -> 10 -> 4 -> 2 -> null
// List is sorted in Descending order.

// Insert a new element:
// 15
// Linked List: 30 -> 20 -> 15 -> 10 -> 4 -> 2 -> null
// List is sorted in Descending order.

// Enter element to delete:
// 10
// 10 deleted.
// Linked List: 30 -> 20 -> 15 -> 4 -> 2 -> null
// List is sorted in Descending order.

// Deleting all elements...
// All elements deleted. List cleared!
// List is empty!