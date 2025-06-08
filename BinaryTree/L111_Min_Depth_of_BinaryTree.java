package BinaryTree;
import java.util.Arrays;

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
//------------------------------------------------
class Solution111
{
    public int minDepth(TreeNode root)
    {
        if(root==null) return 0;
        return findMinDepth(root);
    }

    private int findMinDepth(TreeNode root) 
    {
        if(root.left==null && root.right==null) return 1;
        
        int left = Integer.MAX_VALUE;
        if(root.left!=null)
        {
            left = 1 + findMinDepth(root.left);
        }

        int right = Integer.MAX_VALUE;
        if(root.right!=null)
        {
            right = 1 + findMinDepth(root.right);
        }
        return Math.min(left, right);

    }
}
//--------------------------------------------------
public class L111_Min_Depth_of_BinaryTree 
{
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        // Build tree root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution111 sol = new Solution111();
        int minDepth = sol.minDepth(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Minimum Depth: " + minDepth);
    }
}
// Input: [3, 9, 20, null, null, 15, 7]
// Minimum Depth: 2