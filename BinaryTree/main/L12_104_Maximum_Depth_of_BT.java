package main;

public class L12_104_Maximum_Depth_of_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L12_104_Maximum_Depth_of_BT l12 = new L12_104_Maximum_Depth_of_BT();
        int maxDepth = l12.findMAxDepthOfBinaryTree(root); 
        System.out.println(maxDepth); 
    }
    //----------------------------------------------------------------------------------

    public int height(TreeNode root) //1
    { //2
        // Base case: If the node is null, height is 0
        if(root == null) return 0; //3

        // Recursively get the height of left subtree
        int leftSide = height(root.left); //4

        // Recursively get the height of right subtree
        int rightSide = height(root.right); //5

        // The height at this node is 1 + max(left, right)
        return Math.max(leftSide, rightSide) + 1; //6
    } //7

    // Wrapper function to start the process from the root
    public int findMAxDepthOfBinaryTree(TreeNode root) //8
    { //9
        // If root is null, depth is 0
        if (root == null) return 0; //10

        // Call height function to get the max depth
        return height(root); //11
    } //12
}

// Binary Tree Structure:
//         7
//     20
//         15
// 3
//     9

// BT: [3, 9, 20, null, null, 15, 7]

// 3
// Time Complexity: O(N)
// (Each node is visited once)

// Space Complexity: O(H)
// (Recursion stack = height of the tree)

// Balanced tree → O(log N)

// Skewed tree → O(N)