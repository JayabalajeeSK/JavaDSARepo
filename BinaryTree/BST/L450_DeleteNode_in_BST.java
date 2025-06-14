package BinaryTree.BST;

public class L450_DeleteNode_in_BST 
{
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root==null) return root;

        if(key < root.val) root.left = deleteNode(root.left, key);

        else if(key > root.val) root.right = deleteNode(root.right, key);
        
        else
        {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            root.val = minVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public int minVal(TreeNode root)
    {
        int min=root.val;
        while(root.left!=null)
        {
            min=root.left.val;
            root=root.left;
        }
        return min;
    }
    
}
