package main1;

public class L31_2236_Root_Equals_Sum_of_Children extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {10, 4, 6}; // 10 = 4 + 6 → true
        TreeNode root = buildBT(arr);

        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));

        L31_2236_Root_Equals_Sum_of_Children l31 = new L31_2236_Root_Equals_Sum_of_Children();
        boolean result = l31.checkTree(root);

        System.out.println("\nIs Root Equal to Sum of Children? " + result);
    }
    //-----------------------------------------------------
    public boolean checkTree(TreeNode root) 
    {
        return root.val == root.left.val + root.right.val;
    }
    
}
// Binary Tree Structure:
//     6
// 10
//     4

// Tree (Level Order): [10, 4, 6]
// Time: O(1) → Only one check.

// Space: O(1) → No extra memory used.