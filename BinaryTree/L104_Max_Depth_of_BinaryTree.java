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
class Solution104 
{ // Using Leetcode problem number 104 for Max Depth
    public int maxDepth(TreeNode root) 
    {
        if (root == null) return 0;
        return findMaxDepth(root);
    }

    private int findMaxDepth(TreeNode root) 
    {
        if (root == null) return 0;

        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}

//--------------------------------------------------
public class L104_Max_Depth_of_BinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        // Build tree root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution104 sol = new Solution104();
        int maxDepth = sol.maxDepth(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Maximum Depth: " + maxDepth);
    }
}
// Input: [3, 9, 20, null, null, 15, 7]
// Maximum Depth: 3