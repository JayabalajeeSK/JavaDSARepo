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
class Solution110 
{
    public boolean isBalanced(TreeNode root)
    {
        if(root==null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode root) 
    {
        if(root==null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        int balanceFactor = Math.abs(left-right);
        if(balanceFactor > 1 || left == -1 || right == -1) return -1;

        return 1 + Math.max(left, right);
    }
}

//--------------------------------------------------
public class L110_BalancedBinaryTree {
    public static void main(String[] args) 
    {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};

        // Build tree root = [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution110 sol = new Solution110();
        boolean balanced = sol.isBalanced(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Is Balanced: " + balanced);
    }
}
// Input: [3, 9, 20, null, null, 15, 7]
// Is Balanced: true