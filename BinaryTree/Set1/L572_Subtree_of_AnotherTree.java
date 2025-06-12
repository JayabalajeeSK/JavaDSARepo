package BinaryTree.Set1;

public class L572_Subtree_of_AnotherTree 
{
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    { // takes O(m x n)
        if (root == null) return subRoot == null;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) 
    { // takes O(n)
        if (root == null && subRoot == null) return true;

        if (root == null || subRoot == null) return false;
        
        if (root.val != subRoot.val) return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
    
}
