package Problems.Collections;


import java.util.*;

public class LL4_ReverseLinkedList_Collection 
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

        System.out.println("\nOriginal LinkedList:");
        System.out.println(list);

        // Reverse using Collections.reverse()
        Collections.reverse(list);
        System.out.println("\nAfter Reverse (Collections.reverse):");
        System.out.println(list);

        sc.close();
    }
}

// Enter number of elements: 5
// Enter elements:
// 30 10 20 02 4

// Original LinkedList:
// [30, 10, 20, 2, 4]

// After Reverse (Collections.reverse):
// [4, 2, 20, 10, 30]

//ase, desc, stream