package BinaryTree.BST;

public class Solution938 
{
    public int rangeSumBST(TreeNode root, int low, int high) 
    {
        if (root == null) return 0; // base case.

        if (root.val < low) return rangeSumBST(root.right, low, high); // left branch excluded.

        if (root.val > high) return rangeSumBST(root.left, low, high); // right branch excluded.

        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high); // count in both children.
    }
    
}
