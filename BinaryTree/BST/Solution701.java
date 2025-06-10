package BinaryTree.BST;

public class Solution701 
{
    public TreeNode insertIntoBST(TreeNode root, int num) 
    {
        if(root == null) return new TreeNode(num);

        if(num < root.val) root.left = insertIntoBST(root.left, num);

        else root.right = insertIntoBST(root.right, num);
        
        return root;
    }

    
}
