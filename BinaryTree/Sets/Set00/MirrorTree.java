import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) { this.val = val; }
}

public class MirrorTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse on children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // Level Order Traversal
    public void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Input Tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MirrorTree obj = new MirrorTree();
        root = obj.invertTree(root);

        // Expected Mirror:
        //       1
        //      / \
        //     3   2
        //        / \
        //       5   4

        System.out.println("Level Order after Mirroring:");
        obj.levelOrder(root);
    }
}
// Level Order after Mirroring:
// 1 3 2 5 4 