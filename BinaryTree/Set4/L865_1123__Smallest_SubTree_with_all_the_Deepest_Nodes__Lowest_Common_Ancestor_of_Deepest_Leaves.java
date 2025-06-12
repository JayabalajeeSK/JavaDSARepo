package BinaryTree.Set4;

public class L865_1123__Smallest_SubTree_with_all_the_Deepest_Nodes__Lowest_Common_Ancestor_of_Deepest_Leaves 
{
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
    // public TreeNode lcaDeepestLeaves(TreeNode root) 
    // {
    //     // Approach : Recursion
    //     // Intuition : Let's check the height of every node
    //     // If the height of the left subtree is big, the deepest node is available at the left subtree
    //     // Else, move to the right subtree
    //     // If both the heights are equal, the current node itself is the lowest common ancestor of deepest leaves
    //     // The helper function calculates and we'll simply return the answer
    //     return lowestCommonAncestorOfDeepest(root);
    // }

    // public TreeNode lowestCommonAncestorOfDeepest(TreeNode root){
    //     // Base case 1 : 
    //     // If the tree is empty, there is no ancestor, hence, return null
    //     if(root == null) return null;

    //     // Base case 2 : 
    //     // If there is a single node, it is the ancestor itself
    //     if(root.left == null && root.right == null) return root;


    //     // Deeper tree is available at left subtree, hence move to the left subtree
    //     if(height(root.left) > height(root.right)) return lowestCommonAncestorOfDeepest(root.left);
        

    //     // Deeper tree is available at right subtree, hence move to the right subtree
    //     else if(height(root.left) < height(root.right)) return lowestCommonAncestorOfDeepest(root.right);
        

    //     // Equal left subtree and right subtree. Hence, return the node because it is the common ancestor
    //     else return root;
    
    // }

    // public int height(TreeNode root){
    //     // Base Case 1 : If the root is empty, height is zero;
    //     if(root == null) return 0;

    //     // Base Case 2 : If the node consists of a single child, height is one;
    //     if(root.left == null && root.right == null) return 1;

    //     //Height of the level is the maximum of height of left subtree and right subtree + the node itself
    //     return 1 + Math.max(height(root.left), height(root.right));
    // }