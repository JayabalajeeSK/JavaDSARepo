package main1;

public class L23_1038_BST_to_Greater_Sum_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = buildBST(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Search Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L23_1038_BST_to_Greater_Sum_Tree l23 = new L23_1038_BST_to_Greater_Sum_Tree();
        TreeNode gst = l23.bstToGst(root);
        
        System.out.println();
        System.out.println("Sorted array to BST: " + treeToArray(gst));
        System.out.println();

    }
    //-----------------------------------------------------------------
    
    int greater = 0; // global variable to keep track of running sum

    // This method modifies the tree in-place
    private void convertBSTtoGreaterTree(TreeNode root) //1
    {
        if (root == null) return; //2 — base case: null node

        convertBSTtoGreaterTree(root.right); //3 — visit right (greater values first)

        greater = greater + root.val; //4 — accumulate the current value
        root.val = greater; //5 — update the node’s value with accumulated sum

        convertBSTtoGreaterTree(root.left); //6 — visit left (smaller values)
    }

    // Main method that calls the helper
    public TreeNode bstToGst(TreeNode root) //7
    {
        convertBSTtoGreaterTree(root); //8
        return root; //9 — return the modified root
    }

    
}
// Binary Search Tree Structure:
//             8
//         7
//     6
//         5
// 4
//             3
//         2
//     1
//         0

// BST: [4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8]


// Sorted array to BST: [30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8]
// ⏱ Time and Space Complexity:
// Time: O(N) — each node is visited once

// Space: O(H) — due to recursion stack (H = height of the tree)