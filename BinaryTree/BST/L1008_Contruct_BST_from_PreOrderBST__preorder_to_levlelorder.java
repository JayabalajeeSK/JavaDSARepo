package BinaryTree.BST;

public class L1008_Contruct_BST_from_PreOrderBST__preorder_to_levlelorder 
{
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        TreeNode root= new TreeNode( preorder[0] );
        
        for(int i: preorder)
        {
            createTree(i, root);
        }
        return root;
    }
    
    public TreeNode createTree(int i, TreeNode root)
    {
        if(root == null)
        {
            root= new TreeNode(i);
            return root;
        }
        
        if(root.val > i) root.left= createTree(i, root.left);
    
        
        if(root.val < i) root.right= createTree(i, root.right);
        
        
        return root;
    }
    
}
