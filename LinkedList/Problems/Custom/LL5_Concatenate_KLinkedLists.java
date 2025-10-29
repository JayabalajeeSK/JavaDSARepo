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

class LinkedListCustom 
{
    Node head;

    // Insert at end
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

    // Display linked list
    void display() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Concatenate another list at end
    void concat(LinkedListCustom other) 
    {
        if (head == null) 
        {
            head = other.head;
            return;
        }
        Node temp = head;

        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = other.head;
    }
}

public class LL5_Concatenate_KLinkedLists 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of linked lists (K): ");
        int k = sc.nextInt();

        LinkedListCustom[] lists = new LinkedListCustom[k];

        // Input K linked lists
        for (int i = 0; i < k; i++) 
        {
            lists[i] = new LinkedListCustom();
            System.out.print("\nEnter number of elements in list " + (i + 1) + ": ");
            int n = sc.nextInt();

            System.out.println("Enter " + n + " elements:");
            for (int j = 0; j < n; j++) 
            {
                int data = sc.nextInt();
                lists[i].insert(data);
            }
        }

        // Concatenate all lists
        LinkedListCustom result = lists[0];
        for (int i = 1; i < k; i++) 
        {
            result.concat(lists[i]);
        }

        // Display final list
        System.out.println("\nConcatenated Linked List:");
        result.display();

        sc.close();
    }
}
// Enter number of linked lists (K): 2

// Enter number of elements in list 1: 3
// Enter 3 elements:
// 3 1 5

// Enter number of elements in list 2: 2
// Enter 2 elements:
// 3 6 

// Concatenated Linked List:
// 3 1 5 3 6