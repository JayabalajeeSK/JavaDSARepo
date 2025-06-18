package main2;

import java.util.ArrayList;
import java.util.List;

public class L49_145_PostorderTraversal extends TreeUtils {
    public static void main(String[] args) {
        // 🌳 Sample Input Tree: [1, null, 2, 3]
        Integer[] arr = {1, null, 2, 3};
        TreeNode root = buildBT(arr);

        System.out.println("🧾 Binary Tree (visual):");
        printTree(root, 0);

        L49_145_PostorderTraversal obj = new L49_145_PostorderTraversal();
        List<Integer> result = obj.postorderTraversal(root);

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
        System.out.println("📥 Postorder Traversal: " + result);
    }
    //---------------------------------------------------
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List <Integer> result = new ArrayList<Integer>();
        postOrder(root, result);
        return result;
        
    }

    private void postOrder(TreeNode root, List<Integer> result) 
    {
        if(root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
    
}
// ? Binary Tree (visual):
//     2
//         3
// 1

// ? Tree as Array: [1, null, 2, 3]
// ? Postorder Traversal: [3, 2, 1]
