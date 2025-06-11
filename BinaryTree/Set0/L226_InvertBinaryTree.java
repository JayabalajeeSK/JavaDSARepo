package BinaryTree.Set0;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val; this.left = left; this.right = right;
    }
}
//------------------------------------------------
class Solution226
{
    public TreeNode invertTree(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;        
    
    }

}
//--------------------------------------------------
public class L226_InvertBinaryTree {
    public static void main(String[] args) {
        // Build tree manually from input array:
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.right = null;

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        Solution112 sol = new Solution112();
        boolean result = sol.hasPathSum(root, targetSum);

        // Manual input array for printing (including nulls)
        Integer[] inputArr = {
            5, 
            4, 8, 
            11, null, 13, 4, 
            7, 2, null, null, null, 1
        };

        System.out.println("Input: " + Arrays.toString(inputArr));
        System.out.println("Target Sum: " + targetSum);
        System.out.println("Output: " + result);
        System.out.println("Explanation: The root-to-leaf path with the target sum is shown.");
    }
}