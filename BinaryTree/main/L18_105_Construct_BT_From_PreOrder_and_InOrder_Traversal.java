package main;

import java.util.Arrays;

public class L18_105_Construct_BT_From_PreOrder_and_InOrder_Traversal extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] pre = {3,9,20,15,7};
        Integer[] in = {9,3,15,20,7};
        TreeNode root = buildBT(pre); // Build tree from array
        TreeNode root1 = buildBT(in);

        System.out.println();
        System.out.println("\nBinary Tree Structure:(pre)");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        System.out.println();
        System.out.println("\nBinary Tree Structure: (in)");
        printTree(root1, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root1));
        System.out.println();

        L18_105_Construct_BT_From_PreOrder_and_InOrder_Traversal l18 = new L18_105_Construct_BT_From_PreOrder_and_InOrder_Traversal();
        int arrOP1[] = new int[]{3,9,20,15,7};
        int arrOP2[] = new int[]{9,3,15,20,7};
        TreeNode bt = l18.buildTree(arrOP1, arrOP2);

        
        System.out.println();
        System.out.println("Constructed to BT: " + treeToArray(bt));
        System.out.println();

    }
    //----------------------------------------------------------------------------------
    public TreeNode buildTree(int[] preorder, int[] inorder) //1
    { //2
        // Base case: if preorder is empty, return null
        if(preorder.length == 0) return null; //3

        // First element in preorder is always the root
        TreeNode root = new TreeNode(preorder[0]); //4

        // Find the index of root in inorder array
        for(int i = 0; i < inorder.length; i++) //5
        { //6
            if(inorder[i] == preorder[0]) //7
            {
                // Build left subtree using left part of preorder and inorder
                root.left = buildTree(
                    Arrays.copyOfRange(preorder, 1, i + 1),   // elements after root up to left count
                    Arrays.copyOfRange(inorder, 0, i)         // left part in inorder
                ); //8

                // Build right subtree using right part of preorder and inorder
                root.right = buildTree(
                    Arrays.copyOfRange(preorder, i + 1, preorder.length),
                    Arrays.copyOfRange(inorder, i + 1, inorder.length)
                ); //9

                break; //10 — no need to continue the loop once root is found
            }
        } //11

        return root; //12
    } //13
}

//---------------------------------------------------

// Binary Tree Structure:(pre)
//     20
// 3
//         7
//     9
//         15

// BT: [3, 9, 20, 15, 7]



// Binary Tree Structure: (in)
//     15
// 9
//         7
//     3
//         20

// BT: [9, 3, 15, 20, 7]


// Constructed to BT: [3, 9, 20, null, null, 15, 7]
// ⏱ Time & Space Complexity:
// Time Complexity:

// Worst case: O(N^2)

// Because of Arrays.copyOfRange() inside every recursive call.

// Space Complexity:

// Also O(N^2) due to new arrays being created at each level.