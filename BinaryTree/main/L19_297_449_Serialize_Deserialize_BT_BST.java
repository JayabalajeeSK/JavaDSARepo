package main;

public class L19_297_449_Serialize_Deserialize_BT_BST extends TreeUtils
{
        public static void main(String[] args) 
    {
        Integer[] arrBT = {1,2,3,null,null,4,5};
        Integer[] arrBsT = {2,1,3};

        TreeNode rootBT = buildBT(arrBT); // Build tree from array
        TreeNode rootBsT = buildBST(arrBsT); // Build tree from array

        System.out.println();
        System.out.println("\nBinary search Tree Structure:");
        printTree(rootBsT, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(rootBsT));
        System.out.println();

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(rootBT, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(rootBT));
        System.out.println();

    }
    //--------------------------------------------------------------------
    
    static TreeNode node;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        node = root;
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        return node;
    }
    
}
// Binary search Tree Structure:
//     3
// 2
//     1

// BST: [2, 1, 3]



// Binary Tree Structure:
//         5
//     3
//         4
// 1
//     2

// BT: [1, 2, 3, null, null, 4, 5]
// ⏱ Time & Space Complexity:
// Time: O(N) for both serialize and deserialize

// Space: O(N) for recursion stack and result string