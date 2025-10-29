package Problems.Collections;

import java.util.*;

public class LL3_CheckAndRemoveDuplicates_Collection 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) 
        {
            list.add(sc.nextInt());
        }

        System.out.println("\nBefore removing duplicates:");
        System.out.println("Linked List: " + list);

        // Check for duplicates
        boolean hasDuplicates = list.size() != new HashSet<>(list).size();
        if (hasDuplicates) 
        {
            System.out.println("Duplicates found in the list!");
        } 
        else 
        {
            System.out.println("No duplicates found in the list.");
        }

        // Remove duplicates
        // HashSet automatically removes duplicates
        LinkedList<Integer> uniqueList = new LinkedList<>(new LinkedHashSet<>(list));

        System.out.println("\nAfter removing duplicates:");
        System.out.println("Linked List: " + uniqueList);

        sc.close();
    }
}
// Enter number of elements: 5
// Enter elements:
// 30 10 20 02 20

// Before removing duplicates:
// Linked List: [30, 10, 20, 2, 20]
// Duplicates found in the list!

// After removing duplicates:
// Linked List: [30, 10, 20, 2]