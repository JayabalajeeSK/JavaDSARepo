package BinaryTree.BST;

public class Solution530_783 
{
    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) 
    {
        inOrder(root);
        return ans;
    }
    
    public void inOrder(TreeNode root)
    {
        if(root.left!=null) inOrder(root.left);

        ans = Math.min(ans,Math.abs(root.val-prev));
        
        prev = root.val;
        
        if(root.right!=null) inOrder(root.right);
    }
    
}
