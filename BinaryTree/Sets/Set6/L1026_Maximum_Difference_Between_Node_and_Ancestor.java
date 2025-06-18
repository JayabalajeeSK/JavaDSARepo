package BinaryTree.Set6;


public class L1026_Maximum_Difference_Between_Node_and_Ancestor 
{
    public int maxAncestorDiff(TreeNode root) 
    {
        return maxDiff(root,root.val,root.val);      
    }

    public int maxDiff(TreeNode root , int min , int max) 
    {
        return root!=null? Math.max(maxDiff(root.left, Math.min(min,root.val), Math.max(max,root.val)),
                                    maxDiff(root.right,Math.min(min,root.val),Math.max(max,root.val))) 
                                    : max-min;    
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
