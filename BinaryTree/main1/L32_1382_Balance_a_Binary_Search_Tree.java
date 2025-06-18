package main1;

import java.util.ArrayList;
import java.util.List;

public class L32_1382_Balance_a_Binary_Search_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1, null, 2, null, 3, null, 4}; // Unbalanced right-skewed BST
        TreeNode root = buildBST(arr);

        System.out.println("\nUnbalanced BST Structure:");
        printTree(root, 0);

        System.out.println("\nBST (Level Order): " + treeToArray(root));

        L32_1382_Balance_a_Binary_Search_Tree l32 = new L32_1382_Balance_a_Binary_Search_Tree();
        TreeNode balancedRoot = l32.balanceBST(root);

        System.out.println("\nBalanced BST Structure:");
        printTree(balancedRoot, 0);

        System.out.println("\nBalanced BST (Level Order): " + treeToArray(balancedRoot));
    }
    //------------------------------------------------------------------

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
// Unbalanced BST Structure:
//             4
//         3
//     2
// 1

// BST (Level Order): [1, null, 2, null, 3, null, 4]

// Balanced BST Structure:
//         4
//     3
// 2
//     1

// Balanced BST (Level Order): [2, 1, 3, null, null, null, 4]
// Time:

// O(n) for inorder traversal

// O(n) for building balanced tree
// ✅ Total: O(n)

// Space:

// O(n) for storing nodes in sortedArr

// O(log n) recursive stack (average)
// ✅ Total: O(n)

