package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L02_637_Average_of_Levels_in_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L02_637_Average_of_Levels_in_BT l02_637_Average_of_Levels_in_BT = new L02_637_Average_of_Levels_in_BT();
        List<Integer> averageOfLevels = l02_637_Average_of_Levels_in_BT.averageOfLevels(root); //double // Perform level-order traversal
        System.out.println(averageOfLevels); 
    }
        

    public List<Integer> averageOfLevels(TreeNode root) // double
    {
        List<Integer> result = new ArrayList<>(); //double
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int levelSize=queue.size();
            int averageLevel=0; //double
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize; i++)
            {
                TreeNode currentNode = queue.poll();
                averageLevel = averageLevel + currentNode.val;
                currentLevel.add(currentNode.val);
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
            averageLevel = averageLevel / levelSize;
            result.add(averageLevel);
        }
        return result;
    }
}
// Binary Tree Structure:
//         7
//     20
//         15
// 3
//     9

// BT: [3, 9, 20, null, null, 15, 7]

// [3, 14, 11]