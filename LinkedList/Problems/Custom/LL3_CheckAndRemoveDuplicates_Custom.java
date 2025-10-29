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

public class LL3_CheckAndRemoveDuplicates_Custom 
{
    Node head;

    // Insert element at the end
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

    // Display list
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

    // Check for duplicates
    boolean hasDuplicates() 
    {
        Node current = head;
        while (current != null) 
        {
            Node check = current.next;
            while (check != null) 
            {
                if (current.data == check.data) 
                {
                    return true; // duplicate found
                }
                check = check.next;
            }
            current = current.next;
        }
        return false;
    }

    // Remove duplicates 
    void removeDuplicates() 
    {
        Node current = head;

        while (current != null) 
        {
            Node runner = current;
            while (runner.next != null) 
            {
                if (runner.next.data == current.data) 
                {
                    runner.next = runner.next.next; // remove duplicate
                } 
                else 
                {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LL3_CheckAndRemoveDuplicates_Custom list = new LL3_CheckAndRemoveDuplicates_Custom();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) 
        {
            int data = sc.nextInt();
            list.insert(data);
        }

        System.out.println("\nBefore checking/removing duplicates:");
        list.display();

        // Check duplicates first
        if (list.hasDuplicates()) 
        {
            System.out.println("Duplicates found in the list!");
        } 
        else 
        {
            System.out.println("No duplicates found in the list.");
        }

        // Remove duplicates
        list.removeDuplicates();

        System.out.println("\nAfter removing duplicates:");
        list.display();

        sc.close();
    }
}
// Enter number of elements: 5
// Enter elements:
// 30 10 20 02 2

// Before checking/removing duplicates:
// Linked List: 30 10 20 2 2
// Duplicates found in the list!

// After removing duplicates:
// Linked List: 30 10 20 2