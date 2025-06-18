package BinaryTree.Set4;

import java.util.HashMap;
import java.util.Map;

public class L2196_Create_Binary_Tree_From_Descriptions 
{
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
