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
class Solution100
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p==null && q== null) return true;
        if(p==null || q== null) return false;

        if(p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;

    }
}
//--------------------------------------------------
public class L100_SameTreeOrNot 
{
    public static void main(String[] args) 
    {
        Integer[] arrP = {1, 2, 3};
        Integer[] arrQ = {1, 2, 3};

        // Build tree p = [1, 2, 3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Build tree q = [1, 2, 3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        Solution100 sol = new Solution100();
        boolean isSame = sol.isSameTree(p, q);

        System.out.println("p = " + Arrays.toString(arrP));
        System.out.println("q = " + Arrays.toString(arrQ));
        System.out.println("Are the two trees the same? " + isSame);
    }
}
// p = [1, 2, 3]
// q = [1, 2, 3]
// Are the two trees the same? true