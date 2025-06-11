package BinaryTree.Set0;
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
class Solution101
{
    public boolean isSymmetric(TreeNode root)
    {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode t1, TreeNode t2)
    {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        return check(t1.left, t2.right) && check(t1.right, t2.left);
    }
}
//--------------------------------------------------
public class L101_SymmetricTree {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4, 3};

        // Build tree root = [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution101 sol = new Solution101();
        boolean isSymmetric = sol.isSymmetric(root);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Is tree symmetric? " + isSymmetric);
    }
}
// Input: [1, 2, 2, 3, 4, 4, 3]
// Is tree symmetric? true