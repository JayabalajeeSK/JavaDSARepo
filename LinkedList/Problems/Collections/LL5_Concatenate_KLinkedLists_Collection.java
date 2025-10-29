package Problems.Collections;

import java.util.*;

public class LL5_Concatenate_KLinkedLists_Collection 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of linked lists (K): ");
        int k = sc.nextInt();

        LinkedList<Integer> resultList = new LinkedList<>();

        for (int i = 0; i < k; i++) 
        {
            System.out.print("\nEnter number of elements in list " + (i + 1) + ": ");
            int n = sc.nextInt();

            System.out.println("Enter " + n + " elements:");
            for (int j = 0; j < n; j++) 
            {
                int data = sc.nextInt();
                resultList.add(data); 
            }
        }

        System.out.println("\nConcatenated Linked List:");
        for (int num : resultList) 
        {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
// Enter number of linked lists (K): 2

// Enter number of elements in list 1: 3
// Enter 3 elements:
// 3 1 5

// Enter number of elements in list 2: 2
// Enter 2 elements:
// 7
// 5

// Concatenated Linked List:
// 3 1 5 7 5