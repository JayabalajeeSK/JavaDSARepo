package main;



import java.util.*;


public class BSTOperations extends TreeUtils{

    // ➕ Insertion (Allow duplicates on right)
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val); // duplicates go right
         // 👇 This `else` skips duplicates (val == root.val)
        return root;
    }

    // 🔍 Search
    public static boolean search(TreeNode root, int val) {
        if (root == null) return false;
        if (val == root.val) return true;
        return val < root.val ? search(root.left, val) : search(root.right, val);
    }

    // ❌ Deletion
    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) root.left = delete(root.left, val);
        else if (val > root.val) root.right = delete(root.right, val);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            TreeNode minRight = minNode(root.right);
            root.val = minRight.val;
            root.right = delete(root.right, minRight.val);
        }
        return root;
    }

    // 🟢 Min
    public static TreeNode minNode(TreeNode root) {
        while (root != null && root.left != null)
            root = root.left;
        return root;
    }

    // 🔴 Max
    public static TreeNode maxNode(TreeNode root) {
        while (root != null && root.right != null)
            root = root.right;
        return root;
    }

    // 🔽 Floor (greatest <= val)
    public static Integer floor(TreeNode root, int val) {
        Integer ans = null;
        while (root != null) {
            if (root.val == val) return root.val;
            if (root.val > val) root = root.left;
            else {
                ans = root.val;
                root = root.right;
            }
        }
        return ans;
    }

    // 🔼 Ceil (smallest >= val)
    public static Integer ceil(TreeNode root, int val) {
        Integer ans = null;
        while (root != null) {
            if (root.val == val) return root.val;
            if (root.val < val) root = root.right;
            else {
                ans = root.val;
                root = root.left;
            }
        }
        return ans;
    }

    // ⏫ Inorder Successor
    public static TreeNode inorderSuccessor(TreeNode root, int val) {
        TreeNode curr = root, succ = null;
        while (curr != null) {
            if (val < curr.val) {
                succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return succ;
    }

    // ⏬ Inorder Predecessor
    public static TreeNode inorderPredecessor(TreeNode root, int val) {
        TreeNode curr = root, pred = null;
        while (curr != null) {
            if (val > curr.val) {
                pred = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return pred;
    }

    // 🟡 Inorder (LNR)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 🟣 Preorder (NLR)
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 🔵 Postorder (LRN)
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // 🟠 Level Order
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.print(n.val + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    // 🧪 Main
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 5, 15, 25, 35, 15, 30};
        TreeNode root = null;
        for (int val : arr)
            root = insert(root, val);

        System.out.println("🌲 BST Created (with duplicates):");
        System.out.print("Inorder: "); inorder(root);
        System.out.print("\nPreorder: "); preorder(root);
        System.out.print("\nPostorder: "); postorder(root);
        System.out.print("\nLevel Order: "); levelOrder(root);

        System.out.println("\n\n🔍 Search 25: " + search(root, 25));
        System.out.println("🔍 Search 100: " + search(root, 100));

        System.out.println("🟢 Min: " + minNode(root).val);
        System.out.println("🔴 Max: " + maxNode(root).val);

        System.out.println("🔽 Floor of 28: " + floor(root, 28));
        System.out.println("🔼 Ceil of 28: " + ceil(root, 28));

        TreeNode suc = inorderSuccessor(root, 15);
        TreeNode pre = inorderPredecessor(root, 15);
        System.out.println("⏫ Inorder Successor of 15: " + (suc != null ? suc.val : "None"));
        System.out.println("⏬ Inorder Predecessor of 15: " + (pre != null ? pre.val : "None"));

        root = delete(root, 10);
        System.out.print("❌ After Deleting 10 (Inorder): ");
        inorder(root);
    }
}

// ? BST Created (with duplicates):
// Inorder: 5 10 15 15 20 25 30 30 35 

// Preorder: 20 10 5 15 15 30 25 35 30 

// Postorder: 5 15 15 10 25 30 35 30 20 

// Level Order: 20 10 30 5 15 25 35 15 30 

// ? Search 25: true

// ? Search 100: false

// ? Min: 5

// ? Max: 35

// ? Floor of 28: 25

// ? Ceil of 28: 30

// ? Inorder Successor of 15: 20

// ? Inorder Predecessor of 15: 10

// ? After Deleting 10 (Inorder): 5 15 15 20 25 30 30 35