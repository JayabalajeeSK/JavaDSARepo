package BinaryTree.Set1;

public class L222_Count_Complete_Tree_Nodes 
{
    public int countNodes(TreeNode root) 
    {
        return counter(root);
    }
    public int counter(TreeNode node)
    {
        if(node==null) return 0;
        
        int leftSide = counter(node.left);
        int rightSide = counter(node.right);
        return leftSide + rightSide + 1;
    }
    
}
//------------------------------------
class TreeNode 
 {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) {this.val = val;}
     TreeNode(int val, TreeNode left, TreeNode right) 
     {this.val = val; this.left = left; this.right = right;}
 }