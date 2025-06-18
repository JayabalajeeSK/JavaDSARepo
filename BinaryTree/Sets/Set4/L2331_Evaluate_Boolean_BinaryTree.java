package BinaryTree.Set4;

public class L2331_Evaluate_Boolean_BinaryTree 
{
    public boolean evaluateTree(TreeNode root) 
    {
        return root.left == null ? root.val == 1 : root.val == 2 
                                 ? evaluateTree(root.left) || evaluateTree(root.right) : evaluateTree(root.left) && evaluateTree(root.right);
    }
    
}
