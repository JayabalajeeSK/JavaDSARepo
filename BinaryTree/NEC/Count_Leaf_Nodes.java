package NEC;

import java.util.*;

public class Count_Leaf_Nodes extends TreeUtils 
{
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

        TreeNode root = buildBT(arr);

        System.out.println("\n🧾 Binary Tree (Visual):");
        printTree(root, 0);

        Count_Leaf_Nodes obj = new Count_Leaf_Nodes();

        // DFS Recursive
        int leavesDFS = obj.countLeavesDFS(root);

        
        // BFS Iter7ative
        int leavesBFS = obj.countLeavesBFS(root);

        System.out.println("\n Tree as Array: " + treeToArray(root));
        System.out.println(" Leaf Nodes (DFS Recursive): " + leavesDFS);
        System.out.println(" Leaf Nodes (BFS Iterative): " + leavesBFS);

        sc.close();
    }

    //----------------------------------------
    // DFS Recursive
    public int countLeavesDFS(TreeNode root) 
    {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1; // Leaf node

        return countLeavesDFS(root.left) + countLeavesDFS(root.right);
    }

    // BFS Iterative
    public int countLeavesBFS(TreeNode root) 
    {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leafCount = 0;

        while (!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();

            if (node.left == null && node.right == null) 
            {
                leafCount++;
            }

            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }
        return leafCount;
    }
}

// Enter number of nodes: 7
// Enter nodes level-wise (use 'null' for no node):
// 1 2 3 4 5 null 6

// ? Binary Tree (Visual):
//         6
//     3
// 1
//         5
//     2
//         4

// ? Tree as Array: [1, 2, 3, 4, 5, null, 6]
// ? Leaf Nodes (DFS Recursive): 3
// ? Leaf Nodes (BFS Iterative): 3