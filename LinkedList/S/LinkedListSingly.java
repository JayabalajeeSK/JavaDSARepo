package S;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class LinkedListSingly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, temp = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode; // first node
                temp = head;
            } else {
                temp.next = newNode; // link next node
                temp = temp.next;
            }
        }

        // Display the linked list
        System.out.print("\nLinked List: ");
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        sc.close();
    }
}
// Enter number of nodes: 3
// Enter value for node 1: 10
// Enter value for node 2: 20
// Enter value for node 3: 30

// Linked List: 10 -> 20 -> 30 -> null