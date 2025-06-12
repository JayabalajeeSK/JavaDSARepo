package BinaryTree.Set6;

public class L979_Distribute_Coins_in_BinaryTree
{
    int ans=0;
    public int distributeCoins(TreeNode root) 
    {
        root.val=ans(root);
        return ans;
    }
    public int ans(TreeNode root)
    {
        if(root==null) return 0;
        root.val = (root.val-1) + ans(root.left) + ans(root.right);
        ans = ans + Math.abs(root.val);
        return root.val;
    }
    
}
