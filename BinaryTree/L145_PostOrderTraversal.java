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
class Solution145 
{
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List <Integer> result = new ArrayList<Integer>();
        postOrder(root, result);
        return result;
        
    }

    private void postOrder(TreeNode root, List<Integer> result) 
    {
        if(root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
//--------------------------------------------------
public class L145_PostOrderTraversal {
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

        Solution145 sol = new Solution145();
        List<Integer> output = sol.postorderTraversal(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("postorder Output: " + output);
    }
}
// Input: [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]
// postorder Output: [4, 6, 7, 5, 2, 9, 8, 3, 1]