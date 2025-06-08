package BinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
class Solution 
{
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List <Integer> result = new ArrayList<Integer>();
        inOrder(root, result);
        return result;
        
    }

    private void inOrder(TreeNode root, List<Integer> result) 
    {
        if(root == null) return;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

//--------------------------------------
}
public class L94_InOrderTraversal {
    public static void main(String[] args) {
        // Input as array (only for reference, actual tree is built manually)
        Integer[] arr = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};

        // Build tree manually based on the above array
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(9);

        Solution sol = new Solution();
        List<Integer> output = sol.inorderTraversal(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Inorder Output: " + output);
    }
}
// Input: [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]
// Inorder Output: [4, 2, 6, 5, 7, 1, 3, 9, 8]