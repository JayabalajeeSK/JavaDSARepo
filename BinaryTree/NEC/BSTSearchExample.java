package NEC;

import java.util.*;

public class BSTSearchExample extends TreeUtils
{

    // 🔎 Search logic
    public static boolean searchBST(TreeNode root, int key) 
    {
        if (root == null) return false;

        if (root.val == key) return true;

        if (key < root.val) return searchBST(root.left, key);
        
        return searchBST(root.right, key);
    }

    // 🔎 Iterative Search logic
public static boolean searchBSTIter(TreeNode root, int key) 
{
    while (root != null) 
    {
        if (root.val == key) 
        {
            return true;
        } 
        else if (key < root.val) 
        {
            root = root.left; 
        } 
        else 
        {
            root = root.right; 
        }
    }
    return false; 
}

    public static void main(String[] args) {
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
            } else 
            {
                arr[i] = Integer.parseInt(val);
            }
        }

        TreeNode root = buildBST(arr);

        System.out.println("\n🧾 Binary Search Tree (Visual):");
        printTree(root, 0);

        System.out.println("\n Tree as Array: " + treeToArray(root));

        // ✅ Search input
        System.out.print("\nEnter value to search: ");
        int key = sc.nextInt();
        boolean found = searchBST(root, key);
        boolean foundIter = searchBSTIter(root, key);



        if (found) 
        {
            System.out.println("✅ " + key + " found in the BST.");
        } 
        else 
        {
            System.out.println("❌ " + key + " not found in the BST.");
        }

        if (foundIter) 
        {
            System.out.println("✅ " + key + " found in the BST.");
        } 
        else 
        {
            System.out.println("❌ " + key + " not found in the BST.");
        }

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

// Enter value to search: 4
// ? 4 found in the BST.
// ? 4 found in the BST.