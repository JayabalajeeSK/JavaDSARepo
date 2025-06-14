package BinaryTree.Set1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L637_Average_of_Levels_in_BinaryTree 
{
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        q1.add(root);
        while(q1.size() > 0)
        {
            int size = q1.size();
            double sum = 0;
            for(int i = 0; i < size; i++)
            {
                TreeNode node = q1.remove();
                sum = sum + node.val;
                
                if(node.left != null) q2.add(node.left);
    
                if(node.right != null) q2.add(node.right);
                
                if(i == size - 1)
                {
                    res.add(sum/size);
                    q1 = q2;
                    q2 = new ArrayDeque<>();
                    break;
                }
            }
        }
        return res;
    }
    
}
