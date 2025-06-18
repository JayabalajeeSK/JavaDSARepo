package main;

public class L10_543_Diameter_Of_BST extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1,2,3,4,5};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L10_543_Diameter_Of_BST l10 = new L10_543_Diameter_Of_BST();
        int diameter = l10.diameterOfBinaryTree(root); // Perform level-order traversal
        System.out.println(diameter); // Output: [[3], [9, 20], [15, 7]]
    }
    //----------------------------------------------------------------------------------

    int diameter = 0; // To store the maximum diameter found

    // This method calculates the height of the tree and updates diameter as a side effect
    public int height(TreeNode root) //1
    { //2
        // Base case: if node is null, height is 0
        if(root == null) return 0; //3

        // Recursively find height of left and right subtrees
        int leftSide = height(root.left); //4
        int rightSide = height(root.right); //5

        // The diameter at this node is left height + right height
        // Update global diameter if this is the largest so far
        diameter = Math.max(leftSide + rightSide, diameter); //6

        // Return the height of the current node
        return Math.max(leftSide, rightSide) + 1; //7
    } //8

    // Main function to return the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) //9
    { //10
        height(root); // Start height calculation which also updates diameter
        return diameter; // Return the largest diameter found
    } //11
}

// Binary Tree Structure:
//     3
// 1
//         5
//     2
//         4

// BT: [1, 2, 3, 4, 5]

// 3