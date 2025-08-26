package BT_BST;

import java.util.Stack;

public class DFS_Iter extends TreeUtils
{
    public static void inorderIterative(TreeNode root) 
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) 
        {
            while (curr != null) 
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static void preorderIterative(TreeNode root) 
    {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) 
        {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public static void postorderIterative(TreeNode root) 
    {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) 
        {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }
        while (!stack2.isEmpty()) 
        {
            System.out.print(stack2.pop().val + " ");
        }
    }
    
}
