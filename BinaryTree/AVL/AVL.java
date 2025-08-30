package AVL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TreeNode  
{
     int val;
     TreeNode left;
     TreeNode right;
     
     TreeNode() {}

     TreeNode(int val) {this.val = val;}
     
     TreeNode(int val, TreeNode left, TreeNode right) 
     {
        this.val = val; 
        this.left = left; 
        this.right = right;
    }

    @Override
    public String toString() 
    {
        return String.valueOf(val);
    }
};

public class AVL extends TreeUtils 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array input (like [\"3\",\"9\",\"20\",\"null\",\"null\",\"15\",\"7\"]):");
        String raw = sc.nextLine();

        // Clean input
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
            if (parts[i].equalsIgnoreCase("null")) arr[i] = null;
            else arr[i] = Integer.parseInt(parts[i]);
        }

        // Build AVL tree instead of normal BT

        // TreeNode root = new TreeNode(13);
        // TreeNode root = insertAVL(arr);

        TreeNode root = null;
        for (Integer x : arr) 
        {
            if (x != null) root = insertAVL(root, x); 
        }

        printTree(root, 0); //optional
        System.out.println(treeToString(root));

        //////////////////////////////////////////////

        // System.out.println("Enter Any element:");
        // int newVal = sc.nextInt();
        // root = insertAVL(root, newVal);
        // printTree(root, 0); //optional
        // System.out.println(treeToString(root));

        sc.close();
        
    }

    //////////////////////////////////////////////////////////////////
    // AVL insertion
    static int height(TreeNode node) 
    {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static int getBalance(TreeNode node) 
    {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    static TreeNode rightRotate(TreeNode y) 
    {
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    static TreeNode leftRotate(TreeNode x) 
    {
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }

    static TreeNode insertAVL(TreeNode node, int key) 
    {
        if (node == null) return new TreeNode(key);

        if (key < node.val) node.left = insertAVL(node.left, key);

        else if (key > node.val) node.right = insertAVL(node.right, key);
        else return node; // no duplicate keys

        int balance = getBalance(node);

        

        // RR = -
        if (balance < -1 && key > node.right.val) return leftRotate(node);

        // RL = -
        if (balance < -1 && key < node.right.val) 
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        // LL = +
        if (balance > 1 && key < node.left.val) return rightRotate(node);

        // LR = +
        if (balance > 1 && key > node.left.val) 
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        return node;
    }
////////////////////////
/// 
/// Delete AVL
/// 
    static TreeNode deleteAVL(TreeNode root, int key) 
    {
        if (root == null) return root;

        // Normal BST delete
        if (key < root.val) 
        {
            root.left = deleteAVL(root.left, key);
        } 
        else if (key > root.val) 
        {
            root.right = deleteAVL(root.right, key);
        } 
        else 
        {
            // Node found
            if ((root.left == null) || (root.right == null)) 
            {
                TreeNode temp = (root.left != null) ? root.left : root.right;

                if (temp == null) 
                {
                    // No child
                    root = null;
                } 
                else 
                {
                    // One child
                    root = temp;
                }
            } 
            else 
            {
                // Two children
                TreeNode successor = minValueNode(root.right);
                root.val = successor.val;
                root.right = deleteAVL(root.right, successor.val);
            }
        }

        // If tree had only one node
        if (root == null) return root;

        // Balance factor
        int balance = getBalance(root);

        // Rebalance
        // LL
        if (balance > 1 && getBalance(root.left) >= 0) 
            return rightRotate(root);

        // LR
        if (balance > 1 && getBalance(root.left) < 0) 
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balance < -1 && getBalance(root.right) <= 0) 
            return leftRotate(root);

        // RL
        if (balance < -1 && getBalance(root.right) > 0) 
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    // Helper for inorder successor
    static TreeNode minValueNode(TreeNode node) 
    {
        TreeNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }
    ///////////////////////////////////////////////////////////////

    public static void printTree(TreeNode root, int level) 
    {
        if (root == null) return;
        printTree(root.right, level + 1);
        System.out.println(" ".repeat(level * 4) + root.val);
        printTree(root.left, level + 1);
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
        int i = res.size() - 1;
        while (i >= 0 && res.get(i) == null) i--;
        return res.subList(0, i + 1);
    }

    public static String treeToString(TreeNode root) 
    {
        return treeToArray(root).toString();
    }

    ////////////////////////////////////////////
 
    
}
// RR
// Enter array input (like ["3","9","20","null","null","15","7"]):
// 10 20 30
//     30
// 20
//     10
// [20, 10, 30]

//RL
// Enter array input (like ["3","9","20","null","null","15","7"]):
// 10 30 20
//     30
// 20
//     10
// [20, 10, 30]

//LL
// Enter array input (like ["3","9","20","null","null","15","7"]):
// 30 20 10
//     30
// 20
//     10
// [20, 10, 30]

//LR
// Enter array input (like ["3","9","20","null","null","15","7"]):
// 30 10 20
//     30
// 20
//     10
// [20, 10, 30]