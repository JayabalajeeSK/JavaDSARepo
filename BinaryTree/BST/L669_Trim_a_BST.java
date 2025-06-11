package BinaryTree.BST;

public class L669_Trim_a_BST 
{
    public TreeNode trimBST(TreeNode node, int low, int high) 
    {
        if(node == null) return null;

        node.left = trimBST(node.left, low, high);
        node.right = trimBST(node.right, low, high);

        if(node.val > high || node.val < low)
        {
            if(node.left != null) return node.left;
            else return node.right;
        }
        else return node;
    }
    
}
