package main;

public class L17_230_kth_Smallest_Element_in_BST extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = buildBST(arr); // Build tree from array
        int k = 3;

        System.out.println();
        System.out.println("\nBinary search Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L17_230_kth_Smallest_Element_in_BST l17 = new L17_230_kth_Smallest_Element_in_BST();
        int kthSmallest = l17.kthSmallest(root, k); 
        System.out.println(kthSmallest);
    }
    //-------------------------------------------------------------------------------

    int ans = 0;    // To store the final answer
    int count = 0;  // To keep track of how many nodes we've visited

    public int kthSmallest(TreeNode root, int k) //1
    { //2
        if (root == null) return 0; //3 — base case

        // Step 1: Recurse on left subtree (smaller values)
        kthSmallest(root.left, k); //4

        // Step 2: Visit current node
        count++;                   //5
        if (count == k)            //6
            return ans = root.val; //7 — if this is the kth node, store value

        // Step 3: Recurse on right subtree (larger values)
        kthSmallest(root.right, k); //8

        return ans; //9 — final answer after traversal
    } //10

}
// Binary search Tree Structure:
//             8
//                 7
//         6
//     5
//         4
// 3
//         2
//     1
//         0

// BST: [3, 1, 5, 0, 2, 4, 6, null, null, null, null, null, null, null, 8, 7]

// 2
// ⏱ Time & Space Complexity:
// Time Complexity: O(H + k)

// Best case: We find the element early.

// Worst case: In skewed BST, O(N).

// Space Complexity:

// O(H) recursion stack

// H = height of tree → O(log N) for balanced, O(N) for skewed.