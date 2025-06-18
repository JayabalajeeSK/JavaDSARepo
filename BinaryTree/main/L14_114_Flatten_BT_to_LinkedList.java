package main;

public class L14_114_Flatten_BT_to_LinkedList extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1,2,5,3,4,null,6};
        TreeNode root = buildBT(arr); 

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L14_114_Flatten_BT_to_LinkedList l14 = new L14_114_Flatten_BT_to_LinkedList();
        // int arrOP[] = new int[]{-10,-3,0,5,9};
        l14.flatten(root);

        
        System.out.println();
        System.out.println("Flatten BT: " + treeToArray(root));
        System.out.println();

    }
    //----------------------------------------------------------------------------------

private TreeNode previous = null; // Global variable to keep track of last visited node

    public void flatten(TreeNode root) //1
    { //2
        if (root == null) return; //3 — base case

        // Step 1: Flatten right subtree first
        flatten(root.right); //4

        // Step 2: Then flatten left subtree
        flatten(root.left); //5

        // Step 3: Set the current node’s right to previous
        root.right = previous; //6

        // Step 4: Make left null to convert to linked list format
        root.left = null; //7

        // Step 5: Move the previous pointer to current node
        previous = root; //8
    } //9

    
}
// Binary Tree Structure:
//         6
//     5
// 1
//         4
//     2
//         3

// BT: [1, 2, 5, 3, 4, null, 6]

// Flatten BT: [1, null, 2, null, 3, null, 4, null, 5, null, 6]

// ⏱ Time & Space Complexity:
// Time: O(N)
// (We visit every node once.)

// Space:

// Recursive stack: O(H) → H is height of tree
// → O(log N) for balanced, O(N) for skewed.

// No extra data structures used.