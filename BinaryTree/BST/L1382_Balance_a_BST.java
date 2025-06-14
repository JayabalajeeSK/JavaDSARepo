package BinaryTree.BST;

import java.util.ArrayList;
import java.util.List;

public class L1382_Balance_a_BST 
{
    private List<TreeNode> sortedArr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) 
    {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }

    private void inorderTraverse(TreeNode root) 
    {
        if (root == null) return;

        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }

    private TreeNode sortedArrayToBST(int start, int end) 
    {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }
    
}
