package main3;

import java.util.*;

public class TreeVisualizer extends TreeUtils {
    public static void main(String[] args) 
    {
        Integer[] arr = {1,3,4,null,2};

        System.out.println("Input Array: " + Arrays.toString(arr));

        TreeNode btRoot = buildBT(arr);    // From TreeUtils
        TreeNode bstRoot = buildBST(arr);  // From TreeUtils

        System.out.println("\nBinary Tree Structure:");
        printTree(btRoot, 0);              // From TreeUtils

        System.out.println("\nBinary Search Tree Structure:");
        printTree(bstRoot, 0);             // From TreeUtils

        System.out.println();
        System.out.println("BT: " + treeToArray(btRoot));
    
        System.out.println("BST: " + treeToArray(bstRoot));
        System.out.println("\n✅ Results:");
        System.out.println();
        System.out.println("BT is Balanced: " + isBalanced(btRoot));   // Defined below
        System.out.println("BST is Balanced: " + isBalanced(bstRoot)); // Defined below
    }

    // 🧠 Problem-specific logic: Balance check
    static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    static int height(TreeNode node) 
    {
        if (node == null) return 0;
        int l = height(node.left), r = height(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
