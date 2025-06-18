package BinaryTree.Set4;

import java.util.ArrayList;
import java.util.List;

public class L894_All_Possible_Full_BinaryTrees 
{
    public List<TreeNode> allPossibleFBT(int n) 
    {
        List<TreeNode> result = new ArrayList<>();

        if (n == 1) 
        {
            result.add(new TreeNode(0));
            return result;
        }

        if (n % 2 == 0) return result; 
    

        for (int i = 1; i < n; i= i + 2) 
        {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);

            for (TreeNode left : leftSubtrees) 
            {
                for (TreeNode right : rightSubtrees) 
                {
                    TreeNode root = new TreeNode(0, left, right);
                    result.add(root);
                }
            }
        }

        return result;
    }
    
}
//-----------------------------------------
class TreeNode 
 {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) {this.val = val;}
     TreeNode(int val, TreeNode left, TreeNode right) 
     {this.val = val; this.left = left; this.right = right;}
 }