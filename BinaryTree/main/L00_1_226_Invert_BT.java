package main;

public class L00_1_226_Invert_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {4,2,7,1,3,6,9};
        TreeNode root = buildBT(arr); // Build tree from array
            

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L00_1_226_Invert_BT l10 = new L00_1_226_Invert_BT();
        TreeNode invert = l10.invertTree(root); // Perform level-order traversal
        
        System.out.println();
        System.out.println("\nInverted Binary Tree Structure:");
        printTree(invert, 0); 

        System.out.println();
        System.out.println("Inverted BT: " + treeToArray(invert));
        System.out.println();
    }
    //----------------------------------------------------------------------------------

public TreeNode invertTree(TreeNode root) 
{
    if (root == null) return null;    // Step 1: Base condition (empty node)

    TreeNode temp;                    // Step 2: Create a temp variable
    temp = root.left;                // Step 3: Save left in temp
    root.left = root.right;         // Step 4: Swap left with right
    root.right = temp;              // Step 5: Assign temp (original left) to right

    invertTree(root.left);          // Step 6: Recursively invert left subtree
    invertTree(root.right);         // Step 7: Recursively invert right subtree

    return root;                    // Step 8: Return modified tree
}
}
// Binary Tree Structure:
//         9
//     7
//         6
// 4
//         3
//     2
//         1

// BT: [4, 2, 7, 1, 3, 6, 9]



// Inverted Binary Tree Structure:
//         1
//     2
//         3
// 4
//         6
//     7
//         9

// Inverted BT: [4, 7, 2, 9, 6, 3, 1]
// ⏱️ Time Complexity:
// ✅ O(N) — where N is the number of nodes in the tree.
// 👉 Because each node is visited once to swap its children.

// 📦 Space Complexity:
// Recursive Stack Space:
// ✅ O(H) — where H is the height of the tree.

// Best case: O(log N) for balanced tree

// Worst case: O(N) for skewed tree