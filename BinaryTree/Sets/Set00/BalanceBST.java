package Sets.Set00;

import java.util.*;

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

class BalanceBST {
    private List<TreeNode> sortedArr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) 
    {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }

    private void inorderTraverse(TreeNode root) 
    {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedArr.add(new TreeNode(root.val)); // copy to avoid reference issues
        inorderTraverse(root.right);
    }

    private TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        // Unbalanced BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        BalanceBST obj = new BalanceBST();
        TreeNode balancedRoot = obj.balanceBST(root);

        List<String> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(balancedRoot);

        while (!q.isEmpty()) 
        {
            TreeNode node = q.poll();
            if (node != null) 
            {
                result.add(String.valueOf(node.val));
                q.offer(node.left);
                q.offer(node.right);
            } 
            else result.add("null");
            
    }

    // Trim trailing "null"s
        while (result.size() > 0 && result.get(result.size() - 1).equals("null")) result.remove(result.size() - 1);
        System.out.println(result);
    }
}
// [4, 2, 6, 1, 3, 5, 7]