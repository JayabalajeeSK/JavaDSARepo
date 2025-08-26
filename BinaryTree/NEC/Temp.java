package NEC;

import java.util.*;



public class Temp extends TreeUtils {

    public static void inorder(TreeNode root) 
    {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void preorder(TreeNode root) 
    {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(TreeNode root) 
    {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
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
            if (parts[i].equalsIgnoreCase("-1")) 
            {
                arr[i] = null;
            } 
            else 
            {
                arr[i] = Integer.parseInt(parts[i]);
            }
        }

        // Build Binary Tree
        
        TreeNode root = buildBT(arr);

        System.out.println("in");
        inorder(root);

        System.out.println();
        System.out.println("post");
        postorder(root);

        System.out.println();
        System.out.println("pre");
        preorder(root);

        // System.out.println("\nBT: " inorderIterative(root));

        sc.close();
    }           
}
