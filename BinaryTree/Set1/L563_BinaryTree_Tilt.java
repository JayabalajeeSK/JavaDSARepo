package BinaryTree.Set1;

public class L563_BinaryTree_Tilt 
{
    int tilt = 0;
    public int solve(TreeNode root)
    {
        if(root==null) return 0;
    
        int leftSide = solve(root.left);

        int rightSide = solve(root.right);
        tilt = tilt + Math.abs(leftSide - rightSide);
        return leftSide +rightSide + root.val;
        
    }
    public int findTilt(TreeNode root) 
    {
        solve(root);
        return tilt;
    }
    
}
//------------------------
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