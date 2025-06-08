package BinaryTree;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; this.left = left; this.right = right;
    }
}
//------------------------------------------------
class Solution112 
{
    public boolean hasPathSum (TreeNode root, int targetSum)
    {
        if(root==null) return false;
        if(root.left == null && root.right==null)
        {
            return targetSum - root.val == 0;
        }
        targetSum = targetSum - root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
//--------------------------------------------------
public class L112_PathSum {
    public static void main(String[] args) {
        // Build tree from array: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.right = null;

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.left.left = null;
        root.right.left.right = null;

        root.right.right.left = null;
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        Solution112 sol = new Solution112();
        boolean result = sol.hasPathSum(root, targetSum);

        Integer[] inputArr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        System.out.println("Input: " + Arrays.toString(inputArr));
        System.out.println("Target Sum: " + targetSum);
        System.out.println("Has Path Sum: " + result);
    }
}
// Input: [5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1]
// Target Sum: 22
// Has Path Sum: true