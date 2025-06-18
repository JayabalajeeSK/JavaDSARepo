package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L07_199_BT_RightSide_View extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1,2,3,null,5,null,4};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L07_199_BT_RightSide_View l01_102_BT_LevelOrder_Traversal = new L07_199_BT_RightSide_View();
        List<Integer> rhsView = l01_102_BT_LevelOrder_Traversal.rightSideView(root); // Perform level-order traversal
        System.out.println(rhsView); // Output: [[3], [9, 20], [15, 7]]
    }
    //-----------------------------------------------------------------------------

    public List<Integer> rightSideView(TreeNode root) //1
    { //2
        List<Integer> result = new ArrayList<>(); //3
        if(root == null) return result; //4
        Queue<TreeNode> queue = new LinkedList<>(); //5
        queue.offer(root); //6
        while(!queue.isEmpty()) //7
        { //8
            int levelSize=queue.size(); //9

            for(int i=0; i<levelSize; i++) //11
            { //12
                TreeNode currentNode = queue.poll(); //13
                if(i== levelSize - 1) result.add(currentNode.val);
                // currentLevel.add(currentNode.val); //14
                if(currentNode.left != null) queue.offer(currentNode.left); //15
                if(currentNode.right != null) queue.offer(currentNode.right); //16
            } //17

        } //19
        return result; //20
    } //21

}

// Binary Tree Structure:
//         4
//     3
// 1
//         5
//     2

// BT: [1, 2, 3, null, 5, null, 4]

// [1, 3, 4]