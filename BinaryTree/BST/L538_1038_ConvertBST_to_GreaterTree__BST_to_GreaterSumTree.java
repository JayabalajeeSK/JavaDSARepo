package BinaryTree.BST;

public class L538_1038_ConvertBST_to_GreaterTree__BST_to_GreaterSumTree 
{
    int greater = 0;

    private void convertBSTtoGreaterTree(TreeNode root) 
    {
        if (root == null) return;
    
        convertBSTtoGreaterTree(root.right);

        greater = greater + root.val;
        root.val = greater;

        convertBSTtoGreaterTree(root.left);
    }

    public TreeNode convertBST(TreeNode root) 
    {
        convertBSTtoGreaterTree(root);
        return root;
    }
    
}
