package C;

import java.util.Scanner;

class Node 
{
    int data;
    Node next;

    Node(int value) 
    {
        data = value;
        next = null;
    }
}

public class CircularLinkedList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Node head = null, temp = null, last = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) 
        {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) 
            {
                head = newNode;
                temp = head;
            } 
            else 
            {
                temp.next = newNode;
                temp = newNode;
            }
            last = temp;
        }

        if (last != null) 
        {
            last.next = head;
        }

        System.out.println("\nCircular Linked List:");
        temp = head;
        if (head != null) 
        {
            do 
            {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } 
            while (temp != head);
            System.out.println("(back to head)");
        }

        sc.close();
    }
}
// Enter number of nodes: 3
// Enter value for node 1: 10
// Enter value for node 2: 20
// Enter value for node 3: 30

// Circular Linked List:
// 10 -> 20 -> 30 -> (back to head)