package main2;

import java.util.ArrayList;
import java.util.List;

public class L44_94_Inorder_Traversal extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1, null, 2, 3};
        TreeNode root = buildBT(arr);

        L44_94_Inorder_Traversal obj = new L44_94_Inorder_Traversal();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0);    

        List<Integer> result = obj.inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);

        List<Integer> levelOrder = treeToArray(root);
        System.out.println("Tree to Array (Level Order): " + levelOrder);
    }
    //---------------------------------------
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
}
// Binary Tree Structure:
//     2
//         3
// 1
// Inorder Traversal: [1, 3, 2]
// Tree to Array (Level Order): [1, null, 2, 3]
// Time	O(n)
// Space	O(n)
// Recursion Depth	O(h) (tree height)