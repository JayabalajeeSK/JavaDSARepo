package BinaryTree.Set6;

public class L889_Construct_BinaryTree_from_Preorder_and_Postorder_Traversal 
{
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
