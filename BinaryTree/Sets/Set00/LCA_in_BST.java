class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//--------------------------------------------
public class LCA_in_BST {

    // Static method to find LCA in BST
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);

        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {
        // Constructing BST:
        /*
                    20
                   /  \
                  8    22
                /   \
               4    12
                   /  \
                 10   14
        */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        TreeNode n1 = root.left.left;            // Node 4
        TreeNode n2 = root.left.right.right;     // Node 14

        TreeNode res = lowestCommonAncestor(root, n1, n2);
        System.out.println("LCA of " + n1.val + " and " + n2.val + " is: " + res.val);
    }
}
// LCA of 4 and 14 is: 8