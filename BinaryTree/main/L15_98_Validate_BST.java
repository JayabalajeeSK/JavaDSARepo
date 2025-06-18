package main;


public class L15_98_Validate_BST  extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {2,1,3};
        TreeNode root = buildBST(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary search Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L15_98_Validate_BST l15 = new L15_98_Validate_BST();
        boolean isValidBST = l15.isValidBST(root); 
        System.out.println(isValidBST);
    }
    //-------------------------------------------------------------------------------

    // Public method to start validation with the full value range
    public boolean isValidBST(TreeNode root) //1
    { //2
        // We use Long.MIN_VALUE and Long.MAX_VALUE to avoid integer overflow issues
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE); //3
    } //4

    // Helper method with range constraints
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) //5
    { //6
        // Base case: empty tree is a valid BST
        if (root == null) return true; //7

        // Current node must be within valid range
        if (root.val >= maxVal || root.val <= minVal) return false; //8

        // Recursively validate left and right subtrees with updated ranges
        return isValidBST(root.left, minVal, root.val) && //9
            isValidBST(root.right, root.val, maxVal); //10
    } //11
    
}
// Binary search Tree Structure:
//     3
// 2
//     1

// BST: [2, 1, 3]

// true
// ⏱ Time & Space Complexity:
// Time: O(N) → We visit each node once

// Space: O(H) → Call stack size (H = height of tree)

// Balanced tree: O(log N)

// Skewed tree: O(N)