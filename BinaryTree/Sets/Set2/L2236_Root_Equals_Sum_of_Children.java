package BinaryTree.Set2;

public class L2236_Root_Equals_Sum_of_Children 
{
    public boolean checkTree(TreeNode root) 
    {
        return root.val == root.left.val + root.right.val;
    }
}
