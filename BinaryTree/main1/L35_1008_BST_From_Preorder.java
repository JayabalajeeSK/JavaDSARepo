package main1;

public class L35_1008_BST_From_Preorder extends TreeUtils
{
    public static void main(String[] args) 
    {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        L35_1008_BST_From_Preorder l35 = new L35_1008_BST_From_Preorder();
        TreeNode root = l35.bstFromPreorder(preorder);

        System.out.println("\nConstructed BST from Preorder:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));
    }
    //------------------------------------------------

    public TreeNode bstFromPreorder(int[] preorder) 
    {
        TreeNode root= new TreeNode( preorder[0] );
        
        for(int i: preorder)
        {
            createTree(i, root);
        }
        return root;
    }
    
    public TreeNode createTree(int i, TreeNode root)
    {
        if(root == null)
        {
            root= new TreeNode(i);
            return root;
        }
        
        if(root.val > i) root.left= createTree(i, root.left);
    
        if(root.val < i) root.right= createTree(i, root.right);
        
        return root;
    }
}
// Constructed BST from Preorder:
//         12
//     10
// 8
//         7
//     5
//         1

// Tree (Level Order): [8, 5, 10, 1, 7, null, 12]
//  Time & Space Complexity:
// Time Complexity:

// Average: O(n log n)

// Worst-case: O(n^2) (when input is sorted)

// Space Complexity:

// O(n) for recursion stack in worst case.