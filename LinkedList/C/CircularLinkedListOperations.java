package C;

import java.util.Scanner;

class Node 
{
    int data;
    Node next;
    Node(int val) { data = val; next = null; }
}

public class CircularLinkedListOperations 
{
    static Node head = null;

    // Insert node at end
    static void insert(int val) 
    {
        Node newNode = new Node(val);
        if (head == null) 
        {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    // Print circular linked list
    static void printList() 
    {
        if (head == null) 
        {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        do 
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Find length / size
    static int length() 
    {
        if (head == null) return 0;
        int count = 0;
        Node temp = head;
        do 
        {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Search by value
    static boolean search(int key) 
    {
        if (head == null) return false;
        Node temp = head;
        do 
        {
            if (temp.data == key) return true;
            temp = temp.next;
        } 
        while (temp != head);
        return false;
    }

    // Delete by key (value)
    static void deleteByKey(int key) 
    {
        if (head == null) return;

        Node curr = head, prev = null;

        // If head node is to be deleted
        if (curr.data == key) 
        {
            Node last = head;
            while (last.next != head) last = last.next;
            if (head == last) head = null;
            else 
            {
                last.next = head.next;
                head = head.next;
            }
            return;
        }

        // Search for the key
        do 
        {
            prev = curr;
            curr = curr.next;
            if (curr.data == key) 
            {
                prev.next = curr.next;
                return;
            }
        } 
        while (curr != head);
    }

    // Delete by position (1-based)
    static void deleteByPosition(int pos) 
    {
        int size = length();
        if (pos < 1 || pos > size) 
        {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) 
        {
            deleteByKey(head.data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) temp = temp.next;
        temp.next = temp.next.next;
    }

    // Nth node from start
    static void nthFromStart(int n) 
    {
        int size = length();
        if (n < 1 || n > size) 
        {
            System.out.println("Invalid position");
            return;
        }
        Node temp = head;
        for (int i = 1; i < n; i++) temp = temp.next;
        System.out.println(n + "th node from start: " + temp.data);
    }

    // Nth node from end
    static void nthFromEnd(int n) 
    {
        int size = length();
        if (n < 1 || n > size) 
        {
            System.out.println("Invalid position");
            return;
        }
        int pos = size - n + 1;
        nthFromStart(pos);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Insert nodes
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) 
        {
            System.out.print("Enter value for node " + i + ": ");
            insert(sc.nextInt());
        }

        // Print list
        System.out.println("\nInitial Circular Linked List:");
        printList();

        // Length / Size
        System.out.println("Length: " + length());

        // Search
        System.out.print("\nEnter key to search: ");
        int key = sc.nextInt();
        System.out.println(search(key) ? "Key found!" : "Key not found.");

        // Delete by key
        System.out.print("\nEnter key to delete: ");
        deleteByKey(sc.nextInt());
        System.out.println("List after deleting by key:");
        printList();

        // Delete by position
        System.out.print("\nEnter position to delete: ");
        deleteByPosition(sc.nextInt());
        System.out.println("List after deleting by position:");
        printList();

        // Nth node from start
        System.out.print("\nEnter position (from start): ");
        nthFromStart(sc.nextInt());

        // Nth node from end
        System.out.print("\nEnter position (from end): ");
        nthFromEnd(sc.nextInt());

        // Final size
        System.out.println("\nFinal Length: " + length());

        sc.close();
    }
}
// Enter number of nodes: 4
// Enter value for node 1: 10
// Enter value for node 2: 20
// Enter value for node 3: 30
// Enter value for node 4: 40

// Initial Circular Linked List:
// List: 10 -> 20 -> 30 -> 40 -> (back to head)
// Length: 4

// Enter key to search: 30
// Key found!

// Enter key to delete: 20
// List after deleting by key:
// List: 10 -> 30 -> 40 -> (back to head)

// Enter position to delete: 2
// List after deleting by position:
// List: 10 -> 40 -> (back to head)

// Enter position (from start): 2
// 2th node from start: 40

// Enter position (from end): 1
// 2th node from start: 40

// Final Length: 2