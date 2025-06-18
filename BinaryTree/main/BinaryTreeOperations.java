package main;

import java.util.*;


// 🌲 All-in-One Binary Tree Utility
public class BinaryTreeOperations extends TreeUtils{

    // 🧱 Build Tree from Level Order Array
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length && arr[i] != null)
                q.add(curr.left = new TreeNode(arr[i]));
            i++;
            if (i < arr.length && arr[i] != null)
                q.add(curr.right = new TreeNode(arr[i]));
            i++;
        }
        return root;
    }

    // 🟡 Inorder Traversal (LNR)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 🟣 Preorder Traversal (NLR)
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 🔵 Postorder Traversal (LRN)
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // 🔘 Level Order Traversal (BFS)
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    // 📏 Max Depth
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // ➕ Insert Node (Level Order)
    public static TreeNode insertNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left == null) {
                t.left = new TreeNode(val);
                break;
            } else q.add(t.left);
            if (t.right == null) {
                t.right = new TreeNode(val);
                break;
            } else q.add(t.right);
        }
        return root;
    }

    // ❌ Delete Node (Replace with Deepest)
    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.left == null && root.right == null)
            return root.val == val ? null : root;

        TreeNode target = null, last = null, parent = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            last = q.poll();
            if (last.val == val) target = last;
            if (last.left != null) { q.add(last.left); parent = last; }
            if (last.right != null) { q.add(last.right); parent = last; }
        }

        if (target != null) {
            target.val = last.val;
            if (parent.right == last) parent.right = null;
            else parent.left = null;
        }
        return root;
    }

    // 📊 Enumeration of All Unique BSTs (1 to n)
    public static List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode l : generate(start, i - 1)) {
                for (TreeNode r : generate(i + 1, end)) {
                    res.add(new TreeNode(i, l, r));
                }
            }
        }
        return res;
    }

    // 🌳 Print Tree Rotated
    public static void printTree(TreeNode root, int level) {
        if (root == null) return;
        printTree(root.right, level + 1);
        System.out.println("    ".repeat(level) + root.val);
        printTree(root.left, level + 1);
    }

    // 🧪 Main
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, 4, 5};
        TreeNode root = buildTree(arr);

        System.out.println("🌲 Original Tree:");
        printTree(root, 0);

        System.out.println("\n🟡 Inorder:");
        inorder(root);

        System.out.println("\n🟣 Preorder:");
        preorder(root);

        System.out.println("\n🔵 Postorder:");
        postorder(root);

        System.out.println("\n🔘 Level Order:");
        levelOrder(root);

        System.out.println("\n📏 Max Depth: " + maxDepth(root));

        root = insertNode(root, 10);
        System.out.println("\n➕ After Inserting 10:");
        printTree(root, 0);

        root = deleteNode(root, 3);
        System.out.println("\n❌ After Deleting 3:");
        printTree(root, 0);

        System.out.println("\n📊 Enumerating all unique BSTs for n = 3:");
        List<TreeNode> trees = generateTrees(3);
        int count = 1;
        for (TreeNode t : trees) {
            System.out.println("Tree " + (count++) + ":");
            printTree(t, 0);
            System.out.println();
        }
    }
}

// ? Original Tree:
//     3
//         5
// 1
//         4
//     2

// ? Inorder:
// 2 4 1 5 3

// ? Preorder:
// 1 2 4 3 5

// ? Postorder:
// 4 2 5 3 1

// ? Level Order:
// 1 2 3 4 5

// ? Max Depth: 3

// ? After Inserting 10:
//     3
//         5
// 1
//         4
//     2
//         10

// ? After Deleting 3:
//     5
// 1
//         4
//     2
//         10

// ? Enumerating all unique BSTs for n = 3:
// Tree 1:
//         3
//     2
// 1

// Tree 2:
//     3
//         2
// 1

// Tree 3:
//     3
// 2
//     1

// Tree 4:
// 3
//         2
//     1

// Tree 5:
// 3
//     2
//         1