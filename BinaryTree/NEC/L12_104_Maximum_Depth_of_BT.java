package NEC;

import java.util.*;

public class L12_104_Maximum_Depth_of_BT extends TreeUtils
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

        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println("\nBT: " + treeToArray(root));
        System.out.println();

        L12_104_Maximum_Depth_of_BT l12 = new L12_104_Maximum_Depth_of_BT();

        // Recursive DFS
        int maxDepthDFS = l12.findMAxDepthOfBinaryTree(root); 
        System.out.println("Maximum Depth (DFS Recursive): " + maxDepthDFS);

        // Iterative BFS
        int maxDepthBFS = l12.maxDepthBFS(root);
        System.out.println("Maximum Depth (BFS Iterative): " + maxDepthBFS);

        sc.close();
    }

    //----------------------------------------------------------------------------------
    // Recursive DFS
    public int height(TreeNode root) 
    {
        if (root == null) return 0;

        int leftSide = height(root.left);

        int rightSide = height(root.right);

        return Math.max(leftSide, rightSide) + 1;
    }

    public int findMAxDepthOfBinaryTree(TreeNode root) 
    {
        if (root == null) return 0;
    
        return height(root);
    }

    //----------------------------------------------------------------------------------
    // Iterative BFS approach using Queue
    public int maxDepthBFS(TreeNode root) 
    {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) 
        {
            int size = queue.size(); // number of nodes at current level
            for (int i = 0; i < size; i++) 
            {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);

                if (node.right != null) queue.add(node.right);
            }

            depth++; // finished one level
        }
        return depth;
    }
}
// Enter number of nodes: 7
// Enter nodes level-wise (use 'null' for no node):
// 3 9 20 null null 15 7

// Binary Tree Structure:
//         7
//     20
//         15
// 3
//     9

// BT: [3, 9, 20, null, null, 15, 7]

// Maximum Depth (DFS Recursive): 3
// Maximum Depth (BFS Iterative): 3