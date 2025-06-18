package main;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L01_107_BT_Reverse_LevelOrder_Traversal extends TreeUtils
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

        L01_107_BT_Reverse_LevelOrder_Traversal l01 = new L01_107_BT_Reverse_LevelOrder_Traversal();
        List<List<Integer>> levels = l01.revserseLevelOrder(root); // Perform level-order traversal
        System.out.println(levels); // Output: [[3], [9, 20], [15, 7]]
    }
        

    public List<List<Integer>> revserseLevelOrder(TreeNode root) //1
    { //2
        List<List<Integer>> result = new ArrayList<>(); //3
        if(root == null) return result; //4
        Queue<TreeNode> queue = new LinkedList<>(); //5
        queue.offer(root); //6
        while(!queue.isEmpty()) //7
        { //8
            int levelSize=queue.size(); //9
            List<Integer> currentLevel = new ArrayList<>(levelSize); //10
            for(int i=0; i<levelSize; i++) //11
            { //12
                TreeNode currentNode = queue.poll(); //13
                currentLevel.add(currentNode.val); //14
                if(currentNode.left != null) queue.offer(currentNode.left); //15
                if(currentNode.right != null) queue.offer(currentNode.right); //16
            } //17
            result.add(0, currentLevel); //18
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

// [[15, 7], [9, 20], [3]]