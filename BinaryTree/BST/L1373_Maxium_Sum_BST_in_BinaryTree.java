package BinaryTree.BST;

public class L1373_Maxium_Sum_BST_in_BinaryTree 
{
    int max = 0;
    public int maxSumBST(TreeNode root) 
    {
        post(root);
        return max;
    }
    public int[] post(TreeNode root) 
    {
        //int[]res = {min, max, sum}
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = post(root.left);
        int[] right = post(root.right);

        if (root.val > left[1] && root.val < right[0]) 
        {//valid BST
            int[] res = new int[3];
            res[0] = Math.min(left[0], root.val);//update min
            res[1] = Math.max(right[1], root.val);//update max
            res[2] = root.val + left[2] + right[2];
            max = Math.max(max, res[2]);
            return res;
        }
        //not a valid BST, can't let result be part of greater bst, so apply min/max
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
    
}
