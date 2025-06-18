package main;
public class L21_129_Sum_Root_to_Leaf_Number extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {4,9,0,5,1};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L21_129_Sum_Root_to_Leaf_Number l21 = new L21_129_Sum_Root_to_Leaf_Number();
        int sumNumbers = l21.sumNumbers(root); 
        System.out.println(sumNumbers);
    }
    //-------------------------------------------------------------------------------

    public int sumNumbers(TreeNode root) //1
    {
        return dfs(root, 0); //2 — start DFS with sum = 0
    }

    private int dfs(TreeNode node, int sum) //3
    {
        if (node == null) return 0; //4 — null node adds 0 to result

        // Append the current digit to the running number
        sum = sum * 10 + node.val; //5 — like turning 1 then 2 → 12

        // If it's a leaf node, return the final number formed
        if (node.left == null && node.right == null) return sum; //6

        // Recursively calculate the sum from left and right subtrees
        return dfs(node.left, sum) + dfs(node.right, sum); //7
    }

}
// Binary Tree Structure:
//     0
// 4
//         1
//     9
//         5

// BT: [4, 9, 0, 5, 1]

// 1026
// Time: O(N) — we visit every node once

// Space: O(H) — recursion stack (H = height)