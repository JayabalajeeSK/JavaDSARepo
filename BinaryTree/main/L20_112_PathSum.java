package main;

public class L20_112_PathSum extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = buildBT(arr); // Build tree from array
        int targetSum = 22;

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L20_112_PathSum l20 = new L20_112_PathSum();
        boolean hasPathSum = l20.hasPathSum(root, targetSum); 
        System.out.println(hasPathSum);
    }
    //-------------------------------------------------------------------------------
    
    public boolean hasPathSum(TreeNode root, int targetSum) //1
    {
        // Base case: if tree is empty, no path exists
        if (root == null) return false; //2

        // If it's a leaf node (no children)
        if (root.left == null && root.right == null) //3
        {
            // Check if subtracting root value gives 0 (i.e., path matches)
            return targetSum - root.val == 0; //4
        }

        // Subtract current node's value from targetSum
        targetSum = targetSum - root.val; //5

        // Recursively check if left or right subtree has the remaining sum
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum); //6
    }

}
// Binary Tree Structure:
//             1
//         4
//     8
//         13
// 5
//     4
//             2
//         11
//             7

// BT: [5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1]

// true
//  Time & Space Complexity:
// Time: O(N) — visits all nodes once (in worst case)

// Space:

// Recursion stack = O(H) where H is the height

// Balanced tree → O(log N), skewed tree → O(N)