package BT_BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


 class TreeUtils extends TreeNode
{
    public static void printTree(TreeNode root, int level) 
    {
        if (root == null) return;
        printTree(root.right, level + 1);
        System.out.println("    ".repeat(level) + root.val);
        printTree(root.left, level + 1);
    }
    // 🧱 Build Binary Tree (level order)
    static TreeNode buildBT(Integer[] arr) 
    {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) 
        {
            TreeNode curr = q.poll();
            if (i < arr.length && arr[i] != null)
            {
                q.add(curr.left = new TreeNode(arr[i]));
            }
            i++;
            if (i < arr.length && arr[i] != null)
            {
                q.add(curr.right = new TreeNode(arr[i]));
            }
            i++;
        }
        return root;
    }

    // 🌲 Build BST by inserting one by one
public static TreeNode buildBST(Integer[] arr) 
{
    TreeNode root = null;

    // Loop through the input array
    for (Integer val : arr) 
    {
        // Ignore nulls (they represent missing nodes in level-order)
        if (val != null) 
        {
            root = insertBST(root, val);
        }
    }

    return root;
}

static TreeNode insertBST(TreeNode root, int val) 
{
    // Base case: empty spot found, insert node here
    if (root == null) return new TreeNode(val);

    // BST rule: insert to left if smaller, else right
    if (val < root.val) 
    {
        root.left = insertBST(root.left, val);
    } 
    else 
    {
        root.right = insertBST(root.right, val);
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
                // else 
                // {
                //     res.add(null);
                // }
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
}
// Enter array input (like ["3","9","20","null","null","15","7"]):
// ["3","9","20","null","null","15","7"]

// Binary Tree Structure:

//           7

//      20

//           15

// 3

//      9

// BT: [3, 9, 20, null, null, 15, 7]

// BT: [3, 9, 20, null, null, 15, 7]
// Maximum Depth (DFS Recursive): 3
// Maximum Depth (BFS Iterative): 3