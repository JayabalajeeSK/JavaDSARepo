package main;

public class L16_236_Lowest_Common_Ancestor_of_a_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = buildBT(arr); // Build tree from array
        TreeNode p = root.left;   // Node with value 5
        TreeNode q = root.right;  // Node with value 1

        System.out.println();
        System.out.println("\nBinary search Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L16_236_Lowest_Common_Ancestor_of_a_BT l16 = new L16_236_Lowest_Common_Ancestor_of_a_BT();
        TreeNode lca = l16.lowestCommonAncestor(root, p, q); 
        System.out.println(lca);
    }
    //-------------------------------------------------------------------------------
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) //1
    { //2
        // If root is null or matches one of the target nodes, return root
        if (root == null || root == p || root == q) return root; //3

        // Recurse left subtree
        TreeNode leftSide = lowestCommonAncestor(root.left, p, q); //4

        // Recurse right subtree
        TreeNode rightSide = lowestCommonAncestor(root.right, p, q); //5

        // If left is null, both nodes must be on right side
        if (leftSide == null) return rightSide; //6

        // If right is null, both nodes must be on left side
        if (rightSide == null) return leftSide; //7

        // If both sides returned non-null, current node is LCA
        return root; //8
    } //9

}
// Binary Tree Structure:
//         8
//     1
//         0
// 3
//             4
//         2
//             7
//     5
//         6

// BT: [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]

// 3
// ⏱ Time & Space Complexity:
// Time Complexity: O(N)
// (Each node visited once)

// Space Complexity:

// Recursion Stack: O(H)

// Balanced tree → O(log N)

// Skewed tree → O(N)