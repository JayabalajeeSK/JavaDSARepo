package BinaryTree.BST;

import java.util.ArrayList;
import java.util.List;

public class Solution95 
{
    public List<TreeNode> generateTrees(int n) 
    {
        return recursion(1,n);
    }
    //-----------------------------------------
    List<TreeNode> recursion(int start ,int end)
    {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> left,right;

        if(start > end)
        {
            list.add(null);
            return list;
        }

        if(start == end)
        {
            list.add(new TreeNode(start));
            return list;
        }
        
        //------
        for(int i = start;i<=end;i++)
        {
            left = recursion(start,i-1);
            right = recursion(i+1,end);
            for(TreeNode lft : left)
            {
                for(TreeNode rgt : right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lft;
                    root.right = rgt;
                    list.add(root);
                }
            }
        }
        return list;
    }

    
}
