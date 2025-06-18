package main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class L04_103_BT_zig_zag_LevelOrder_Traversal  extends TreeUtils
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

        L04_103_BT_zig_zag_LevelOrder_Traversal l04 = new L04_103_BT_zig_zag_LevelOrder_Traversal();
        List<List<Integer>> levels = l04.zigzagLevelOrder(root); // Perform level-order traversal
        System.out.println(levels); // Output: [[3], [9, 20], [15, 7]]
    }



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) //1
    { //2
        List<List<Integer>> result = new ArrayList<>(); //3
        if(root == null) return result; //4
        Deque<TreeNode> queue = new LinkedList<>(); //5
        queue.offer(root); //6
        boolean reverse = false;
        while(!queue.isEmpty()) //7
        { //8
            int levelSize=queue.size(); //9
            List<Integer> currentLevel = new ArrayList<>(levelSize); //10
            for(int i=0; i<levelSize; i++) //11
            { //12
                if(!reverse)
                {
                TreeNode currentNode = queue.pollFirst(); //13
                currentLevel.add(currentNode.val); //14
                if(currentNode.left != null) queue.addLast(currentNode.left); //15
                if(currentNode.right != null) queue.addLast(currentNode.right); //16
                }
                else
                {
                TreeNode currentNode = queue.pollLast(); //13
                currentLevel.add(currentNode.val); //14
                if(currentNode.right != null) queue.addFirst(currentNode.right); //16
                if(currentNode.left != null) queue.addFirst(currentNode.left); //15
                }

            } //17
            reverse = ! reverse; 
            result.add(currentLevel); //18
        } //19
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

// [[3], [20, 9], [15, 7]]