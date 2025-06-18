package main4;

import java.util.HashSet;
import java.util.Set;

public class L66_653_Two_Sum_IV_Input_is_a_BST extends TreeUtils {
    public static void main(String[] args) {
        // Input: BST = [5, 3, 6, 2, 4, null, 7], k = 9
        Integer[] arr = {5, 3, 6, 2, 4, null, 7};
        TreeNode root = buildBST(arr);

        L66_653_Two_Sum_IV_Input_is_a_BST obj = new L66_653_Two_Sum_IV_Input_is_a_BST();
        int k = 9;
        boolean result = obj.findTarget(root, k);

        System.out.println("🧮 Tree:");
        printTree(root, 0);

        System.out.println("\n🎯 Find Target " + k + ": " + result); // Output: true
    }
//--------------------------------------------
    Set<Integer> result = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) 
    {
        if(root==null) return false;
        if(result.contains(k - root.val)) return true; result.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
// ? Tree:
//         7
//     6
// 5
//         4
//     3
//         2

// ? Find Target 9: true