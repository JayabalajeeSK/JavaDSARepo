package main;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L01_102_BT_LevelOrder_Traversal extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L01_102_BT_LevelOrder_Traversal l01_102_BT_LevelOrder_Traversal = new L01_102_BT_LevelOrder_Traversal();
        List<List<Integer>> levels = l01_102_BT_LevelOrder_Traversal.levelOrder(root); // Perform level-order traversal
        System.out.println(levels); // Output: [[3], [9, 20], [15, 7]]
    }
        

    public List<List<Integer>> levelOrder(TreeNode root) //1
    { //2
        // Create the final list to store level-by-level node values
        List<List<Integer>> result = new ArrayList<>(); //3

        // If tree is empty, return the empty result
        if(root == null) return result; //4

        // Use a queue to help with level-order (BFS) traversal
        Queue<TreeNode> queue = new LinkedList<>(); //5

        // Start with the root node
        queue.offer(root); //6

        // Keep processing while the queue has nodes
        while(!queue.isEmpty()) //7
        { //8
            // Number of nodes at the current level
            int levelSize = queue.size(); //9

            // List to store node values of the current level
            List<Integer> currentLevel = new ArrayList<>(levelSize); //10

            // Process all nodes at the current level
            for(int i = 0; i < levelSize; i++) //11
            { //12
                // Get the next node from the queue
                TreeNode currentNode = queue.poll(); //13

                // Add its value to the current level list
                currentLevel.add(currentNode.val); //14

                // Add its left child to the queue, if it exists
                if(currentNode.left != null) queue.offer(currentNode.left); //15

                // Add its right child to the queue, if it exists
                if(currentNode.right != null) queue.offer(currentNode.right); //16
            } //17

            // Add the list of this level to the final result
            result.add(currentLevel); //18
        } //19

        // Return the complete level-order traversal
        return result; //20
    } //21
} 

// Binary Tree Structure:
//         7
//     20
//         15
// 3
//     9

// BT: [3, 9, 20, null, null, 15, 7]

// [[3], [9, 20], [15, 7]]

// ⏱️ Time & Space Complexity:
// Time Complexity: O(N) – We visit every node once.

// Space Complexity: O(N) – Due to queue and result storage.