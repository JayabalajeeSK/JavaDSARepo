class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//---------------------------------------------------    
public class ValidateBST 
{
    public boolean isValidBST(TreeNode root) 
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) 
    {
        if (root == null) return true;

        if (root.val >= maxVal || root.val <= minVal) return false;

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    public static void main(String[] args) 
    {
        // Input: [5,1,4,null,null,3,6]
        // Construct the tree manually:
        /*
                    5
                   / \
                  1   4
                     / \
                    3   6
           This is NOT a valid BST (because 3 is in the right subtree of 5)
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        ValidateBST validator = new ValidateBST();

        boolean result = validator.isValidBST(root);

        System.out.println("Is Valid BST? " + result);  // Output: false
    }
}
// Is Valid BST? false