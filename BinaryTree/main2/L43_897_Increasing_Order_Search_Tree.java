package main2;


public class L43_897_Increasing_Order_Search_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {5,3,6,2,4,null,8,1,null,null,null,7,9};
        TreeNode root = buildBT(arr);

        System.out.println("Original Tree:");
        printTree(root, 0);

        L43_897_Increasing_Order_Search_Tree l43 = new L43_897_Increasing_Order_Search_Tree();
        TreeNode newRoot = l43.increasingBST(root);

        System.out.println("\nIncreasing Order Search Tree:");
        printTree(newRoot, 0);

        System.out.println("BT: " + treeToArray(newRoot));
    }
    //----------------------------------------

    public TreeNode increasingBST(TreeNode root) 
    {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) 
    
    {
        if (root == null) return tail;

        TreeNode result = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return result;
    }
    
}
// Original Tree:
//             9
//         8
//             7
//     6
// 5
//         4
//     3
//         2
//             1

// Increasing Order Search Tree:
//                                 9
//                             8
//                         7
//                     6
//                 5
//             4
//         3
//     2
// 1
// BT: [1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9]
// Time	O(n)
// Space (Stack)	O(h), → O(log n) for balanced, O(n) worst case