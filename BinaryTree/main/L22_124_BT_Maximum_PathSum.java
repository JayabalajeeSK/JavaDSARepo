package main;

public class L22_124_BT_Maximum_PathSum extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {-10,9,20,null,null,15,7};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L22_124_BT_Maximum_PathSum l22 = new L22_124_BT_Maximum_PathSum();
        int maxPathSum = l22.maxPathSum(root); 
        System.out.println(maxPathSum);
    }
    //-------------------------------------------------------------------------------

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) //1
    {
        if (root == null) return 0; //2 — base case: null node contributes 0

        int ls = maxPathSum(root.left);  //3 — max sum from left subtree
        int rs = maxPathSum(root.right); //4 — max sum from right subtree

        // 5 — temp is max sum **going up**, either:
        // just the node itself or
        // node + one of the subtrees (left or right)
        int temp = Math.max(Math.max(ls, rs) + root.val, root.val);

        // 6 — max is max sum **including both subtrees and root**
        int max = Math.max(temp, ls + rs + root.val);

        // 7 — update result (global max path sum)
        result = Math.max(result, max);

        return temp; //8 — return path sum upward to parent
    }
}
// Binary Tree Structure:
//         7
//     20
//         15
// -10
//     9

// BT: [-10, 9, 20, null, null, 15, 7]

// 42
// ⏱ Time and Space Complexity:
// Time: O(N) — visits every node once

// Space: O(H) — recursion stack (H = height)