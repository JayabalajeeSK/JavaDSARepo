package NEC;

import java.util.*;

public class BST_InsDelCom extends TreeUtils 
{

    //Insertion
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
///////////////////////////////////////

        // Deletion
        public static TreeNode deleteNode(TreeNode root, int key) 
        {
            if(root==null) return root;

            if(key < root.val) root.left = deleteNode(root.left, key);

            else if(key > root.val) root.right = deleteNode(root.right, key);
            
            else
            {
                if(root.left==null) return root.right;
                else if(root.right==null) return root.left;

                root.val = minVal(root.right);
                root.right = deleteNode(root.right, root.val);
            }
            return root;
        }

        public static int minVal(TreeNode root)
        {
            int min=root.val;
            while(root.left!=null)
            {
                min=root.left.val;
                root=root.left;
            }
            return min;
        }

////////////////////
//Print Tree
    public static void printTree(TreeNode root, int level) 
    {
        if (root == null) return;
        printTree(root.right, level + 1);
        System.out.println("    ".repeat(level) + root.val);
        printTree(root.left, level + 1);
    }

/////////////////////////
// Tree to Array and String
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

/////////////////////////////////////////////////////////////

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Integer[] arr = new Integer[n];
        System.out.println("Enter nodes level-wise (use 'null' for no node):");
        for (int i = 0; i < n; i++) 
        {
            String val = sc.next();
            if (val.equalsIgnoreCase("null")) 
            {
                arr[i] = null;
            } 
            else 
            {
                arr[i] = Integer.parseInt(val);
            }
        }

        TreeNode root = buildBST(arr);

        System.out.println("\n🧾 Binary Search Tree (Visual):");
        printTree(root, 0);
        System.out.println("\n Tree : " + treeToString(root));

        System.out.print("Enter Element to Delete:");
        int key = sc.nextInt();
        deleteNode(root, key);
        

        System.out.println("\n🧾 Binary Search Tree (Visual):");
        printTree(root, 0);
        System.out.println("\n Tree : " + treeToString(root));

        sc.close();
    }

}

// Enter number of nodes: 6
// Enter nodes level-wise (use 'null' for no node):
// 5 3 8 2 4 8

// ? Binary Search Tree (Visual):
//         8
//     8
// 5
//         4
//     3
//         2

//  Tree : [5, 3, 8, 2, 4, 8]
// Enter Element to Delete:2

// ? Binary Search Tree (Visual):
//         8
//     8
// 5
//         4
//     3

//  Tree : [5, 3, 8, 4, 8]