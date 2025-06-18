package BinaryTree.Set2;

public class L1302_Deepest_Leaves_Sum 
{
        
    // Calculate the height of the tree
    public int height(TreeNode root) 
    {
        if (root == null) return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Sum all node values at a specific level (deepest level)
    public int out(TreeNode root, int height) 
    {
        if (root == null) return 0;

        if (height == 0) return root.val;

        return out(root.left, height - 1) + out(root.right, height - 1);
    }

    // Main function to get the sum of the deepest leaves
    public int deepestLeavesSum(TreeNode root) 
    {
        int height = height(root);  // Get height (deepest level)
        return out(root, height);   // Sum all nodes at that level
    }
    
}
