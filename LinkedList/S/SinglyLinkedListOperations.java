package S;

import java.util.*;

public class SinglyLinkedListOperations 
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

        // Print list
        System.out.println("\nList: " + list);

        // Length / Size
        System.out.println("Size: " + list.size());

        // Search
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        System.out.println(list.contains(key) ? "Found" : "Not Found");

        // Delete by key
        System.out.print("Enter key to delete: ");
        int delKey = sc.nextInt();
        list.remove(Integer.valueOf(delKey));
        System.out.println("After deleting key: " + list);

        // Delete by position
        System.out.print("Enter position to delete: ");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < list.size()) 
        {
            list.remove(pos);
        } 
        else 
        {
            System.out.println("Invalid position!");
        }
        System.out.println("After deleting position: " + list);

        // Nth node from start
        System.out.print("Enter n for nth from start: ");
        int nth = sc.nextInt();
        if (nth > 0 && nth <= list.size())
            System.out.println(nth + "th from start: " + list.get(nth - 1));

        // Nth node from end
        System.out.print("Enter n for nth from end: ");
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

// List: [10, 20, 30, 40, 50]
// Size: 5
// Enter key to search: 40
// Found
// Enter key to delete: 40
// After deleting key: [10, 20, 30, 50]
// Enter position to delete: 2
// After deleting position: [10, 20, 50]
// Enter n for nth from start: 3
// 3th from start: 50
// Enter n for nth from end: 2
// 2th from end: 20