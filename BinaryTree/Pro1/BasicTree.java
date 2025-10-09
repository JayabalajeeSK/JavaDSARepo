package Pro1;

import java.util.*;

class TreeNode 
{
    int val;
    TreeNode left, right;


    TreeNode(int val) 
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class BasicTree 
{
    static Scanner sc = new Scanner(System.in);

    public static TreeNode buildBinaryTree(Integer[] arr) 
    {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) 
        {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) 
            {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) 
            {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

 public static TreeNode insertBST(TreeNode root, int val) 
    {
        if (root == null) return new TreeNode(val);

        if (val < root.val) 
        {
            root.left = insertBST(root.left, val);
        } 
        else if (val > root.val) 
        {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    public static TreeNode buildBST(Integer[] arr) 
    {
        TreeNode root = null;
        for (Integer val : arr) 
        {
            if (val != null) 
            { 
                root = insertBST(root, val);
            }
        }
        return root;
    }


    static void levelOrder(TreeNode root) 
    {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) 
        {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }



    public static void main(String[] args) 
    {
        System.out.println("Enter array input (like 1 2 3 or [1,4,6] or [\"3\",\"9\",\"20\",\"null\",\"15\"]):");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) 
        {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break; //stop at empty line
            sb.append(line).append(" ");
        }

        String raw = sb.toString().trim();

        String clean = raw.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(",", " ")
                .trim()
                .replaceAll("\\s+", " "); // multiple spaces → single space

        String[] parts = clean.split(" ");
        Integer[] arr = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) 
        {
            if (parts[i].equalsIgnoreCase("null") || parts[i].equals("-1")) {
                arr[i] = null; 
            } 
            else 
            {
                arr[i] = Integer.parseInt(parts[i]); 
            }
        }


        System.out.println("BT:");
        TreeNode root = buildBinaryTree(arr);
        levelOrder(root);
        System.out.println();

        System.out.println("BST:");
        TreeNode root1 = buildBST(arr);
        levelOrder(root1);
        System.out.println();

    }
}
// Enter array input (like 1 2 3 or [1,4,6] or ["3","9","20","null","15"]):
// 1
// 2
// 4 null
// -1
// 8
// -1 5 3

// BT:
// 1 2 4 8 5 3
// BST:
// 1 2 4 3 8 5