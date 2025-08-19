package NEC;

import java.util.*;

public class L57_222_Count_Complete_Tree_Nodes extends TreeUtils 
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

        L57_222_Count_Complete_Tree_Nodes obj = new L57_222_Count_Complete_Tree_Nodes();

        // DFS Recursive
        int countDFS = obj.countNodesDFS(root);

        // BFS Iterative
        int countBFS = obj.countNodesBFS(root);

        System.out.println("\n📦 Tree as Array: " + treeToArray(root));
        System.out.println("🔢 Total Nodes (DFS Recursive): " + countDFS);
        System.out.println("🔢 Total Nodes (BFS Iterative): " + countBFS);

        sc.close();
    }

    //----------------------------------------
    // ✅ DFS Recursive
    public int countNodesDFS(TreeNode root) 
    {
        if (root == null) return 0;

        int leftSide = countNodesDFS(root.left);

        int rightSide = countNodesDFS(root.right);

        return leftSide + rightSide + 1;
    }

    // ✅ BFS Iterative
    public int countNodesBFS(TreeNode root) 
    {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();

            count++;

            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }

        return count;
    }
}
// Enter number of nodes: 6
// Enter nodes level-wise (use 'null' for no node):
// 1 2 3 4 5 6

// ? Binary Tree (Visual):
//     3
//         6
// 1
//         5
//     2
//         4

// ? Tree as Array: [1, 2, 3, 4, 5, 6]
// ? Total Nodes (DFS Recursive): 6
// ? Total Nodes (BFS Iterative): 6