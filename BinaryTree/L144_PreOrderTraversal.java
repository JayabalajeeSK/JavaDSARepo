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
class Solution144
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List <Integer> result = new ArrayList<Integer>();
        preOrder(root, result);
        return result;
        
    }

    private void preOrder(TreeNode root, List<Integer> result) 
    {
        if(root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}
//--------------------------------------------------
public class L144_PreOrderTraversal {
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

        Solution144 sol = new Solution144();
        List<Integer> output = sol.preorderTraversal(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Pre Output: " + output);
    }
}
// Input: [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]
// Pre Output: [1, 2, 4, 5, 6, 7, 3, 8, 9]