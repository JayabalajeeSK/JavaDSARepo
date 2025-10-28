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

public class LL1_LinkedListOperationsCustom 
{

    // count nodes
    static int countNodes(Node head) 
    {
        int count = 0;
        Node temp = head;
        while (temp != null) 
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // sum of elements
    static int sumOfNodes(Node head) 
    {
        int sum = 0;

        Node temp = head;
        while (temp != null) 
        {
            sum = sum + temp.data;
            temp = temp.next;
        }
        return sum;
    }

    // search element (return true/false and position)
    static void searchElement(Node head, int key) 
    {
        Node temp = head;
        int position = 1;
        boolean found = false;

        while (temp != null) 
        {
            if (temp.data == key) 
            {
                System.out.println("Element " + key + " found at position " + position);
                found = true;
                break;
            }
            temp = temp.next;
            position++;
        }

        if (!found) 
        {
            System.out.println("Element " + key + " not found in the list.");
        }
    }

    // find maximum element
    static int findMax(Node head) 
    {
        if (head == null) return Integer.MIN_VALUE;

        int max = head.data;
        Node temp = head.next;

        while (temp != null) 
        {
            if (temp.data > max)
            {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    // find minimum element
    static int findMin(Node head) 
    {
        if (head == null) return Integer.MAX_VALUE;

        int min = head.data;
        Node temp = head.next;

        while (temp != null) 
        {
            if (temp.data < min)
            {
                min = temp.data;
            }
            temp = temp.next;
        }
        return min;
    }

    // display list
    static void display(Node head) 
    {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // insert at beginning
    static Node insertAtBeginning(Node head, int data) 
    {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;  // new head
    }

    // insert at end
    static Node insertAtEnd(Node head, int data) 
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // insert at specific position (1-based)
    static Node insertAtPosition(Node head, int data, int pos) 
    {
        Node newNode = new Node(data);

        if (pos == 1) 
        { 
            // beginning
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) 
        {
            temp = temp.next;
        }

        if (temp == null) 
        {
            System.out.println("Position out of range! Node added at the end.");
            return insertAtEnd(head, data);
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // Sort Linked List (ascending order)
    static Node sortLinkedList(Node head) 
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node current, index;
        int temp;

        for (current = head; current != null; current = current.next) 
        {
            for (index = current.next; index != null; index = index.next) 
            {
                if (current.data > index.data) 
                {
                    // swap data
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }

        return head;
    }

    // Sort Linked List (ascending order)
    static Node sortLinkedListDesc(Node head) 
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node current, index;
        int temp;

        for (current = head; current != null; current = current.next) 
        {
            for (index = current.next; index != null; index = index.next) 
            {
                if (current.data < index.data) 
                {
                    // swap data
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }

        return head;
    }

    // Delete first node
    static Node deleteAtBeginning(Node head) 
    {
        if (head == null) 
        {
            System.out.println("List is empty! Nothing to delete.");
            return null;
        }
        System.out.println("Deleted element: " + head.data);
        return head.next; // new head
    }

    // Delete last node
    static Node deleteAtEnd(Node head) 
    {
        if (head == null) 
        {
            System.out.println("List is empty! Nothing to delete.");
            return null;
        }
        if (head.next == null) 
        {
            System.out.println("Deleted element: " + head.data);
            return null; // only one element
        }

        Node temp = head;
        while (temp.next.next != null) 
        { // stop at second last node
            temp = temp.next;
        }

        System.out.println("Deleted element: " + temp.next.data);
        temp.next = null; // remove last node
        return head;
    }

    // Delete node at specific position (1-based)
    static Node deleteAtPosition(Node head, int pos) 
    {
        if (head == null) 
        {
            System.out.println("List is empty! Nothing to delete.");
            return null;
        }

        if (pos == 1) 
        {
            System.out.println("Deleted element: " + head.data);
            return head.next;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) 
        {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) 
        {
            System.out.println("Position out of range!");
            return head;
        }

        System.out.println("Deleted element: " + temp.next.data);
        temp.next = temp.next.next; // unlink node
        return head;
    }

    // Delete node by value
    static Node deleteByValue(Node head, int key) 
    {
        if (head == null) 
        {
            System.out.println("List is empty! Nothing to delete.");
            return null;
        }

        if (head.data == key) 
        {
            System.out.println("Deleted element: " + key);
            return head.next;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) 
        {
            temp = temp.next;
        }

        if (temp.next == null) 
        {
            System.out.println("Element " + key + " not found!");
            return head;
        }

        System.out.println("Deleted element: " + key);
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null, tail = null;

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            int data = sc.nextInt();
            Node newNode = new Node(data);

            if (head == null) 
            {
                head = newNode;
                tail = newNode;
            } 
            else 
            {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Display linked list
        display(head);

        // Count and sum
        System.out.println("Total Nodes: " + countNodes(head));
        System.out.println("Sum of All Elements: " + sumOfNodes(head));

        // Search
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        searchElement(head, key);

        // Max and Min
        System.out.println("Maximum Element: " + findMax(head));
        System.out.println("Minimum Element: " + findMin(head));

        // --- Insert Operations ---
        System.out.print("Enter element to insert at beginning: ");
        int first = sc.nextInt();
        head = insertAtBeginning(head, first);
        display(head);

        System.out.print("Enter element to insert at end: ");
        int last = sc.nextInt();
        head = insertAtEnd(head, last);
        display(head);

        System.out.print("Enter element and position to insert: ");
        int value = sc.nextInt();
        int pos = sc.nextInt();
        head = insertAtPosition(head, value, pos);
        display(head);

        //Sorting
        sortLinkedList(head);
        display(head);

        sortLinkedListDesc(head);
        display(head);

        //Delete
        head = deleteAtBeginning(head);
        display(head);

        deleteAtEnd(head);
        display(head);

        int posDel = sc.nextInt();
        deleteAtPosition(head, posDel);
        display(head);

        int keyDel = sc.nextInt();
        deleteByValue(head, keyDel);
        display(head);

        sc.close();
    }
}
// Enter number of nodes: 5

// Enter 5 elements:
// 30 10 20 02 04

// Linked List: 30 -> 10 -> 20 -> 2 -> 4 -> null

// Total Nodes: 5

// Sum of All Elements: 66

// Enter element to search: 4

// Element 4 found at position 5

// Maximum Element: 30
// Minimum Element: 2

// Enter element to insert at beginning: 90
// Linked List: 90 -> 30 -> 10 -> 20 -> 2 -> 4 -> null

// Enter element to insert at end: 10
// Linked List: 90 -> 30 -> 10 -> 20 -> 2 -> 4 -> 10 -> null

// Enter element and position to insert: 50 3
// Linked List: 90 -> 30 -> 50 -> 10 -> 20 -> 2 -> 4 -> 10 -> null

// Linked List: 2 -> 4 -> 10 -> 10 -> 20 -> 30 -> 50 -> 90 -> null
// Linked List: 90 -> 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> 2 -> null

// Deleted element: 90
// Linked List: 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> 2 -> null

// Deleted element: 2
// Linked List: 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> null

// 2
// Deleted element: 30
// Linked List: 50 -> 20 -> 10 -> 10 -> 4 -> null

// 10
// Deleted element: 10
// Linked List: 50 -> 20 -> 10 -> 4 -> null
// Enter number of nodes: 5

///------------------------IGNORE-------------------------------

// Deleted element: 2
// Linked List: 90 -> 50 -> 30 -> 20 -> 10 -> 10 -> 4 -> null

// 2
// Deleted element: 50
// Linked List: 90 -> 30 -> 20 -> 10 -> 10 -> 4 -> null

// 20
// Deleted element: 20
// Linked List: 90 -> 30 -> 10 -> 10 -> 4 -> null

//------------------------IGNORE-------------------------------