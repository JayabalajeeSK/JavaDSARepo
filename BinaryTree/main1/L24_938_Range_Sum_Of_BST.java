package main1;

public class L24_938_Range_Sum_Of_BST extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {10,5,15,3,7,null,18};
        int low = 7;
        int high = 15;
        TreeNode root = buildBST(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBST  Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L24_938_Range_Sum_Of_BST l24 = new L24_938_Range_Sum_Of_BST();
        int rangeSumBST = l24.rangeSumBST(root, low, high); 
        System.out.println(rangeSumBST);
    }
    //-------------------------------------------------------------------------------
    
    public int rangeSumBST(TreeNode root, int low, int high) //1
    {
        if (root == null) return 0; //2 — base case: empty tree or reached leaf

        //3 — If root is smaller than low, ignore left subtree
        if (root.val < low) 
            return rangeSumBST(root.right, low, high);

        //4 — If root is greater than high, ignore right subtree
        if (root.val > high) 
            return rangeSumBST(root.left, low, high);

        //5 — root is within range: include root + left + right
        return root.val 
            + rangeSumBST(root.left, low, high) 
            + rangeSumBST(root.right, low, high);
    }

    
}
// BST  Structure:
//         18
//     15
// 10
//         7
//     5
//         3

// BST: [10, 5, 15, 3, 7, null, 18]

// 32
// ⏱ Time & Space Complexity:
// Time: O(N) in worst case (no pruning, full traversal)
// Best case: O(log N) for balanced tree with pruning

// Space: O(H) due to recursion (H = height of tree)