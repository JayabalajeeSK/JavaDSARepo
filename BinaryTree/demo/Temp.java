package demo;

import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Temp extends TreeUtils {

    // ✅ Build Binary Tree from level-order array (with nulls)
    public static TreeNode buildBT(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

        public static List<Integer> treeToArray(TreeNode root) 
        {
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) 
            {
                TreeNode curr = q.poll();
                if (curr != null) 
                {
                    res.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                } 
                else 
                {
                    res.add(null);
                }
            }

            // Trim trailing nulls
            int i = res.size() - 1;
            while (i >= 0 && res.get(i) == null) i--;
            return res.subList(0, i + 1);
        }

        public static String treeToString(TreeNode root) 
        {
            return treeToArray(root).toString();
        }

    // ✅ Convert tree back to array (level order)

    // ✅ Recursive DFS (Depth)
    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public int findMAxDepthOfBinaryTree(TreeNode root) {
        return height(root);
    }

    // ✅ Iterative BFS
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return depth;
    }

    // ✅ Main Process
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array input (like [\"3\",\"9\",\"20\",\"null\",\"null\",\"15\",\"7\"]):");
        String raw = sc.nextLine();

        // Clean input: remove [ ] " and convert to array
        String clean = raw.replace("[", "")
                          .replace("]", "")
                          .replace("\"", "")
                          .replace(",", " ")
                          .trim()
                          .replaceAll("\\s+", " ");

        String[] parts = clean.split(" ");

        Integer[] arr = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) 
        {
            if (parts[i].equalsIgnoreCase("null")) 
            {
                arr[i] = null;
            } 
            else 
            {
                arr[i] = Integer.parseInt(parts[i]);
            }
        }

        // Build Binary Tree
        TreeNode root = buildBST(arr);

        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0);

       System.out.println("\nBT: " + treeToString(root));

        System.out.println("\nBT: " + treeToArray(root));
        Temp l12 = new Temp();

        // Recursive DFS
        int maxDepthDFS = l12.findMAxDepthOfBinaryTree(root);
        System.out.println("Maximum Depth (DFS Recursive): " + maxDepthDFS);

        // Iterative BFS
        int maxDepthBFS = l12.maxDepthBFS(root);
        System.out.println("Maximum Depth (BFS Iterative): " + maxDepthBFS);

        sc.close();
    }           
}
