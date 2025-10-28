package D;

import java.util.*;

public class DoublyLinkedListOperation 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        // Insert elements
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Enter value: ");
            list.add(sc.nextInt());
        }

        // Forward print
        System.out.println("\nForward: ");
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) System.out.print(it.next() + " -> ");
        System.out.println("null");

        // Backward print (doubly)
        System.out.println("Backward: ");
        while (it.hasPrevious()) System.out.print(it.previous() + " -> ");
        System.out.println("null");

        // Length / Size
        System.out.println("\nSize: " + list.size());

        // Search
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        System.out.println(list.contains(key) ? "Found" : "Not Found");

        // Delete by key
        System.out.print("Enter key to delete: ");
        list.remove(Integer.valueOf(sc.nextInt()));
        System.out.println("After deleting key: " + list);

        // Delete by position
        System.out.print("Enter position to delete: ");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < list.size()) list.remove(pos);
        System.out.println("After deleting position: " + list);

        // Nth from start
        System.out.print("Enter n from start: ");
        int nth = sc.nextInt();
        if (nth > 0 && nth <= list.size())
            System.out.println(nth + "th from start: " + list.get(nth - 1));

        // Nth from end
        System.out.print("Enter n from end: ");
        int nthEnd = sc.nextInt();
        if (nthEnd > 0 && nthEnd <= list.size())
            System.out.println(nthEnd + "th from end: " + list.get(list.size() - nthEnd));

        sc.close();
    }
}
// Enter number of elements: 
// 5
// Enter value: 10
// Enter value: 20
// Enter value: 30
// Enter value: 40
// Enter value: 50

// Forward:
// 10 -> 20 -> 30 -> 40 -> 50 -> null
// Backward:
// 50 -> 40 -> 30 -> 20 -> 10 -> null

// Size: 5
// Enter key to search: 30
// Found
// Enter key to delete: 20
// After deleting key: [10, 30, 40, 50]
// Enter position to delete: 2
// After deleting position: [10, 30, 50]
// Enter n from start: 2
// 2th from start: 30
// Enter n from end: 3
// 3th from end: 10