package main1;

public class L38_700_Search_in_BST extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = buildBT(arr); // BST:      4
                                      //         /   \
                                      //        2     7
                                      //       / \
                                      //      1   3

        System.out.println("\nBinary Search Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (level order): " + treeToArray(root));

        int val = 2;
        L38_700_Search_in_BST l38 = new L38_700_Search_in_BST();
        TreeNode result = l38.searchBST(root, val);

        if (result != null)
        {
            System.out.println("\n✅ Node found with value: " + result.val);
            System.out.println("Subtree rooted at node " + val + ": " + treeToArray(result));
        }
        else
        {
            System.out.println("\n❌ Value " + val + " not found in the BST.");
        }
    }
    //---------------------------------------
    public TreeNode searchBST(TreeNode root, int val) 
    {
        if(root == null) return null;
        
        if(root.val == val) return root;
        
        if(val < root.val) return searchBST(root.left,val);
        
        else return searchBST(root.right,val);
    }
    
}
// Binary Search Tree Structure:
//     7
// 4
//         3
//     2
//         1

// Tree (level order): [4, 2, 7, 1, 3]

// ? Node found with value: 2
// Subtree rooted at node 2: [2, 1, 3]
// Time	O(h)
// Space (stack)	O(h)