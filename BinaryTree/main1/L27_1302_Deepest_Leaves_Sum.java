package main1;

public class L27_1302_Deepest_Leaves_Sum  extends TreeUtils
{
    public static void main(String[] args) 
    {
        // Example tree: [1,2,3,4,5,null,6,7,null,null,null,null,8]
        Integer[] arr = {1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeNode root = buildBT(arr); // Use buildBT for correct level-order tree

        System.out.println("Binary Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));

        L27_1302_Deepest_Leaves_Sum l27 = new L27_1302_Deepest_Leaves_Sum();
        int result = l27.deepestLeavesSum(root);

        System.out.println("\nDeepest Leaves Sum: " + result);
    }

    //-----------------------------------------------------------

    //1  Calculate the height of the tree
    public int height(TreeNode root) 
    {
        if (root == null) return -1;              //2  Base case: null node contributes -1 to height

        return 1 + Math.max(height(root.left),    //3  Height = 1 + max of left and right subtree heights
                            height(root.right));  //4
    }

    //5  Sum all node values at a specific level
    public int out(TreeNode root, int height) 
    {
        if (root == null) return 0;               //6  Base case: null node contributes 0 to sum

        if (height == 0) return root.val;         //7  If we're at the correct level, return the value

        return out(root.left, height - 1) +       //8  Go left with decreased height
            out(root.right, height - 1);       //9  Go right with decreased height
    }

    //10 Main function to get the sum of the deepest leaves
    public int deepestLeavesSum(TreeNode root) 
    {
        int height = height(root);                //11 Get max depth of tree
        return out(root, height);                 //12 Return sum of nodes at that level
    }

    
}
// Binary Tree Structure:
//             8
//         6
//     3
// 1
//         5
//     2
//         4
//             7

// Tree (Level Order): [1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8]

// Deepest Leaves Sum: 15
// Time Complexity:

// O(N) for height() (visit every node)

// O(N) for out() (visit every node again)
// ✅ Total = O(N) — where N = number of nodes

// Space Complexity:

// O(H) due to recursion stack (H = height of tree)