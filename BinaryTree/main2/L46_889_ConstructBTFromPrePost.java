package main2;

public class L46_889_ConstructBTFromPrePost extends TreeUtils {
    public static void main(String[] args) {
        // Sample input
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        // Build tree
        L46_889_ConstructBTFromPrePost obj = new L46_889_ConstructBTFromPrePost();
        TreeNode root = obj.constructFromPrePost(preorder, postorder);

        // Print result
        System.out.println("🧾 Tree Structure:");
        printTree(root, 0);
        System.out.println("📦 Tree Array: " + treeToString(root));
    }

    //---------------------------------------------------------

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) 
    {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) 
    {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);

        if (preStart == preEnd) return root; // single node

        int leftChildVal = pre[preStart + 1];
        int leftChildIdxInPost = postStart;

        // Find left child index in postorder
        while (post[leftChildIdxInPost] != leftChildVal) leftChildIdxInPost++;
        
        int leftSubtreeSize = leftChildIdxInPost - postStart + 1;

        root.left = build(pre, preStart + 1, preStart + leftSubtreeSize, post, postStart, leftChildIdxInPost);
        
        root.right = build(pre, preStart + leftSubtreeSize + 1, preEnd, post, leftChildIdxInPost + 1, postEnd - 1);

        return root;
    }
    
}
// ? Tree Structure:
//         7
//     3
//         6
// 1
//         5
//     2
//         4
// ? Tree Array: [1, 2, 3, 4, 5, 6, 7]