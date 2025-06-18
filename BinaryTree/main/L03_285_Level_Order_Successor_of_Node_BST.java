package main;

import java.util.LinkedList;

import java.util.Queue;

public class L03_285_Level_Order_Successor_of_Node_BST extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        int key = 9;
        TreeNode root = buildBST(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Search Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L03_285_Level_Order_Successor_of_Node_BST l03_285_Level_Order_Successor_of_Node = new L03_285_Level_Order_Successor_of_Node_BST();
        TreeNode sucessor = l03_285_Level_Order_Successor_of_Node.findSuccessor(root, key); //double // Perform level-order traversal
        System.out.println("Key: "+key);
        System.out.println(sucessor); 
    }
        

    public TreeNode findSuccessor(TreeNode root, int key) // double //1
    { //2

        if(root == null) return null; //4
        Queue<TreeNode> queue = new LinkedList<>(); //5
        queue.offer(root); //6
        while(!queue.isEmpty()) //7
        { //8
                //int levelSize=queue.size(); //9
                TreeNode currentNode = queue.poll(); //13
                if(currentNode.left != null) queue.offer(currentNode.left); //15
                if(currentNode.right != null) queue.offer(currentNode.right); //16
                if(currentNode.val==key) break;
        } //19
        return queue.peek(); //20
    } //21
} //22
// Binary Search Tree Structure:
//         20
//             15
//     9
//         7
// 3

// BST: [3, null, 9, 7, 20, null, null, 15]

// Key: 9
// 7