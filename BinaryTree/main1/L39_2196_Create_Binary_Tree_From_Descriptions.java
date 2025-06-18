package main1;

import java.util.HashMap;
import java.util.Map;

public class L39_2196_Create_Binary_Tree_From_Descriptions extends TreeUtils
{
    public static void main(String[] args) 
    {
        int[][] descriptions = {
            {20, 15, 1},
            {20, 17, 0},
            {50, 20, 1},
            {50, 80, 0},
            {80, 19, 1}
        };

        L39_2196_Create_Binary_Tree_From_Descriptions l39 = new L39_2196_Create_Binary_Tree_From_Descriptions();
        TreeNode root = l39.createBinaryTree(descriptions);

        System.out.println("\nConstructed Binary Tree:");
        printTree(root, 0);

        System.out.println("\nTree (level order): " + treeToArray(root));
    }

    //-----------------------------------------------------

    public TreeNode createBinaryTree(int[][] descriptions) 
    {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int[] desc : descriptions) 
        {
            int parentVal = desc[0], childVal = desc[1], isLeft = desc[2];

            TreeNode parent = nodeMap.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = nodeMap.computeIfAbsent(childVal, TreeNode::new);

            if (isLeft == 1) parent.left = child;
            else parent.right = child;
        }
        for (int[] desc : descriptions) nodeMap.remove(desc[1]); 

        return nodeMap.values().iterator().next();
    }
    
}
// Constructed Binary Tree:
//     80
//         19
// 50
//         17
//     20
//         15

// Tree (level order): [50, 20, 80, 15, 17, 19]