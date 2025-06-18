package main1;

public class L25_2415_Reverse_Odd_Levels_of_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {2,3,5,8,13,21,34};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBT Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("Before Reverse Odd Levels: " + treeToArray(root));
        System.out.println();

        L25_2415_Reverse_Odd_Levels_of_BT l25 = new L25_2415_Reverse_Odd_Levels_of_BT();
        l25.dfs(root.left, root.right, 1); 

        System.out.println();
        System.out.println("After Reverse Odd Levels: " + treeToArray(root));
        System.out.println();
    }
    //-------------------------------------------------------------------------------
    public void dfs(TreeNode left, TreeNode right, int level) //1
    {
        // base case: if either child is null, stop
        if (left == null || right == null) return; //2

        // if level is odd (1, 3, 5...), swap node values
        if ((level & 1) == 1) //3
        {
            int temp; //4
            temp = left.val; //5
            left.val = right.val; //6
            right.val = temp; //7
        }

        // recursively go deeper: outer pair
        dfs(left.left, right.right, level + 1); //8

        // recursively go deeper: inner pair
        dfs(left.right, right.left, level + 1); //9
    }

}
// BT Structure:
//         34
//     5
//         21
// 2
//         13
//     3
//         8

// Before Reverse Odd Levels: [2, 3, 5, 8, 13, 21, 34]


// After Reverse Odd Levels: [2, 5, 3, 8, 13, 21, 34]
// Time: O(N) — each node is visited once

// Space: O(H) — recursion stack (H = height of the tree)