package main1;

public class L30_1315_Sum_of_Nodes_with_Even_Valued_Grandparent extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeNode root = buildBT(arr); // Build the tree

        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));

        L30_1315_Sum_of_Nodes_with_Even_Valued_Grandparent l30 = new L30_1315_Sum_of_Nodes_with_Even_Valued_Grandparent();
        int result = l30.sumEvenGrandparent(root);

        System.out.println("\nSum of nodes with even-valued grandparent: " + result);
    }
    //------------------------------------------------------------


    int sum = 0; // Global sum to hold the final result

    //1 Entry point: starts the recursive helper function with dummy values for parent & grandparent
    public int sumEvenGrandparent(TreeNode root) 
    {
        return gs(root, 1, 1); // Start with parent = 1 and grandparent = 1 (both odd)
    }

    //2 Recursive helper function with 3 parameters: current node, its parent, and grandparent
    public int gs(TreeNode node, int parent, int grandParent) 
    {    
        if (node == null) return 0; //3 Base case: return 0 if node is null

        gs(node.left, node.val, parent);   //4 Recursive call for left child
        gs(node.right, node.val, parent);  //5 Recursive call for right child

        if (grandParent % 2 == 0)          //6 Check if grandparent is even
            sum += node.val;               //7 If yes, add current node's value to the global sum

        return sum; //8 Return the final result
    }
}
// Binary Tree Structure:
//             5
//         3
//     8
//         1
// 6
//             4
//         7
//             1
//     7
//         2
//             9

// Tree (Level Order): [6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5]

// Sum of nodes with even-valued grandparent: 18
// ⏱ Time and Space Complexity:
// Time: O(N)
// Visit every node once.

// Space: O(H)
// Recursive call stack. H is height of the tree.