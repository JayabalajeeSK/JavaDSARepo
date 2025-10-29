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

public class LL4_ReverseLinkedListCustom 
{
    Node head;

    // Insert element at end
    void insert(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
            return;
        }
        Node temp = head;

        while (temp.next != null) 
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display Linked List
    void display() 
    {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Reverse Iteratively
    void reverseIterative() 
    {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) 
        {
            next = current.next; // store next
            current.next = prev; // reverse link
            prev = current;      // move prev one step
            current = next;      // move current one step
        }
        head = prev;
    }

    // Reverse Recursively
    Node reverseRecursive(Node current) 
    {
        if (current == null || current.next == null) return current;

        Node newHead = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return newHead;
    }

    // Reverse using Two Pointer (Sliding Window logic)
    void reverseTwoPointer() 
    {
        Node first = null;
        Node second = head;

        while (second != null) 
        {
            Node temp = second.next; // move window forward
            second.next = first;     // reverse link
            first = second;          // slide window right
            second = temp;
        }
        head = first;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LL4_ReverseLinkedListCustom list = new LL4_ReverseLinkedListCustom();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) 
        {
            int data = sc.nextInt();
            list.insert(data);
        }

        System.out.println("\nOriginal List:");
        list.display();

        // Iterative
        list.reverseIterative();
        System.out.println("\nAfter Iterative Reverse:");
        list.display();

        // Recursive
        list.head = list.reverseRecursive(list.head);
        System.out.println("\nAfter Recursive Reverse:");
        list.display();

        // Two Pointer (Sliding Window)
        list.reverseTwoPointer();
        System.out.println("\nAfter Two Pointer Reverse:");
        list.display();

        sc.close();
    }
}
// Enter number of elements: 5
// Enter elements:
// 30 10 20 02 4

// Original List:
// Linked List: 30 10 20 2 4

// After Iterative Reverse:
// Linked List: 4 2 20 10 30

// After Recursive Reverse:
// Linked List: 30 10 20 2 4

// After Two Pointer Reverse:
// Linked List: 4 2 20 10 30