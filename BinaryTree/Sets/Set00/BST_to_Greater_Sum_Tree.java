class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BST_to_Greater_Sum_Tree {
    int greater = 0;

    private void convertBSTtoGreaterTree(TreeNode root) 
    {
        if (root == null) return;

        convertBSTtoGreaterTree(root.right);
        greater = greater + root.val;
        root.val = greater;

        convertBSTtoGreaterTree(root.left);
    }

    public TreeNode bstToGst(TreeNode root) 
    {
        convertBSTtoGreaterTree(root); return root;
    }

    private void inorder(TreeNode root) 
    {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BST_to_Greater_Sum_Tree obj = new BST_to_Greater_Sum_Tree();

        // Constructing BST
        //     11
        //    /  \
        //   2    29
        //  / \   / \
        // 1   7 15  40
        //             \
        //              50
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(2);
        root.right = new TreeNode(29);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(40);
        root.right.right.right = new TreeNode(50);

        TreeNode updated = obj.bstToGst(root);
        System.out.println("Inorder of Greater Tree:");
        obj.inorder(updated);
    }
}
// Inorder of Greater Tree:
// 155 154 152 145 134 119 90 50 