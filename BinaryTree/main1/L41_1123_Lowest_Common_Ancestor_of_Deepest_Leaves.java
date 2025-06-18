package main1;

public class L41_1123_Lowest_Common_Ancestor_of_Deepest_Leaves extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = buildBT(arr);

        System.out.println("Tree Structure:");
        printTree(root, 0);

        System.out.println("Binary Tree (Level Order): " + treeToArray(root));

        L41_1123_Lowest_Common_Ancestor_of_Deepest_Leaves l41 = new L41_1123_Lowest_Common_Ancestor_of_Deepest_Leaves();
        TreeNode lca = l41.lcaDeepestLeaves(root);
        System.out.println("Binary Tree (Level Order): " + treeToArray(lca));

        
    }
    //-------------------------------------------------

    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        return lowestCommonAncestorOfDeepest(root);
    }

    public TreeNode lowestCommonAncestorOfDeepest(TreeNode root)
    {

        if(root == null) return null;

        if(root.left == null && root.right == null) return root;

        if(height(root.left) > height(root.right)) return lowestCommonAncestorOfDeepest(root.left);
        
        else if(height(root.left) < height(root.right)) return lowestCommonAncestorOfDeepest(root.right);
        
        else return root;
    
    }

    public int height(TreeNode root)
    {
   
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        return 1 + Math.max(height(root.left), height(root.right));
    }    
}
// Tree Structure:
//         8
//     1
//         0
// 3
//             4
//         2
//             7
//     5
//         6
// Binary Tree (Level Order): [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]
// Binary Tree (Level Order): [2, 7, 4]
// Time	O(N)
// Space (list + stack)	O(N)