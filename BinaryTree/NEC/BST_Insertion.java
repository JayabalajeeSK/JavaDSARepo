package NEC;

import java.util.*;

public class BST_Insertion extends TreeUtils 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Integer[] arr = new Integer[n];
        System.out.println("Enter nodes level-wise (use 'null' for no node):");
        for (int i = 0; i < n; i++) 
        {
            String val = sc.next();
            if (val.equalsIgnoreCase("null")) 
            {
                arr[i] = null;
            } 
            else 
            {
                arr[i] = Integer.parseInt(val);
            }
        }

        TreeNode root = buildBST(arr);

        System.out.println("\n🧾 Binary Search Tree (Visual):");
        printTree(root, 0);


        System.out.println("\n Tree as Array: " + treeToArray(root));

        sc.close();
    }

}

// Enter number of nodes: 6
// Enter nodes level-wise (use 'null' for no node):
// 5 3 7 2 4 8

// ? Binary Search Tree (Visual):
//         8
//     7
// 5
//         4
//     3
//         2

//  Tree as Array: [5, 3, 7, 2, 4, null, 8] 