package main2;

import java.util.List;

public class L53_701_Insert_Into_BST extends TreeUtils {

    public static void main(String[] args) {
        Integer[] arr = {4, 2, 7, 1, 3};  // Initial BST
        TreeNode root = buildBST(arr);   // Use BST builder for correct structure

        System.out.println("🌲 Original BST:");
        printTree(root, 0);

        int numToInsert = 5;

        L53_701_Insert_Into_BST obj = new L53_701_Insert_Into_BST();
        TreeNode updatedRoot = obj.insertIntoBST(root, numToInsert);

        System.out.println("\n✅ After Inserting: " + numToInsert);
        printTree(updatedRoot, 0);

        List<Integer> arrayView = treeToArray(updatedRoot);
        System.out.println("\n📦 Tree as Array: " + arrayView);
    }
    //---------------------------------------------

    public TreeNode insertIntoBST(TreeNode root, int num) 
    {
        if(root == null) return new TreeNode(num);

        if(num < root.val) root.left = insertIntoBST(root.left, num);

        else root.right = insertIntoBST(root.right, num);
        
        return root;
    }
    
}
// ? Original BST:
//     7
// 4
//         3
//     2
//         1

// ? After Inserting: 5
//     7
//         5
// 4
//         3
//     2
//         1

// ? Tree as Array: [4, 2, 7, 1, 3, 5]