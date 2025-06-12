package BinaryTree.Set1;

public class L543_Diameter_of_Binarytree 
{
    int diameter=0;
    public int height(TreeNode root) 
    {
        if(root==null) return 0;

        int leftSide = height(root.left);
        int rightSide = height(root.right);

        diameter=Math.max((leftSide + rightSide), diameter);

        return Math.max(leftSide ,rightSide) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) 
    {
        height(root);
        return diameter;
    }
}
//----------------------------------
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