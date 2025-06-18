package main2;

import java.util.ArrayList;
import java.util.List;

public class L54_144_BT_Preorder_Traversal extends TreeUtils {

    public static void main(String[] args) {
        // 👇 Sample input
        Integer[] arr = {1, null, 2, 3};
        TreeNode root = buildBT(arr);  // Build Binary Tree (level order)

        System.out.println("🧾 Binary Tree (Visual):");
        printTree(root, 0);

        L54_144_BT_Preorder_Traversal obj = new L54_144_BT_Preorder_Traversal();
        List<Integer> result = obj.preorderTraversal(root);

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
        System.out.println("📤 Preorder Traversal: " + result);
    }
    //------------------------------------------
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
// ? Binary Tree (Visual):
//     2
//         3
// 1

// ? Tree as Array: [1, null, 2, 3]
// ? Preorder Traversal: [1, 2, 3]