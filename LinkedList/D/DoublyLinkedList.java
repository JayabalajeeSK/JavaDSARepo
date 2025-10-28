package D;

import java.util.LinkedList;
import java.util.Scanner;

public class DoublyLinkedList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            list.add(sc.nextInt());
        }

        System.out.println("Forward: " + list);

        System.out.print("Enter element to add at first: ");
        int first = sc.nextInt();
        list.addFirst(first);

        System.out.print("Enter element to add at last: ");
        int last = sc.nextInt();
        list.addLast(last);

        System.out.println("After additions: " + list);

        System.out.println("Removing first (" + list.getFirst() + ") and last (" + list.getLast() + ")...");
        list.removeFirst();
        list.removeLast();

        System.out.println("After removals: " + list);

        sc.close();
    }
}
// Enter number of elements: 3
// Enter 3 elements:
// 10 20 30
// Forward: [10, 20, 30]
// Enter element to add at first: 40
// Enter element to add at last: 5
// After additions: [40, 10, 20, 30, 5]
// Removing first (40) and last (5)...
// After removals: [10, 20, 30]