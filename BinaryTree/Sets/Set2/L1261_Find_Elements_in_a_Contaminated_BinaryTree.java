package BinaryTree.Set2;

import java.util.HashSet;
import java.util.Set;

public class L1261_Find_Elements_in_a_Contaminated_BinaryTree 
{
    Set<Integer> set = new HashSet<>();
    public L1261_Find_Elements_in_a_Contaminated_BinaryTree(TreeNode root)  //FindElements(TreeNode root) - constructor
    {
        recoverTree(root,0);
    }
    public void recoverTree(TreeNode root,int value)
    {
        if(root==null) return;
    
        root.val=value;
        set.add(value);

        recoverTree(root.left, 2*value + 1);
        recoverTree(root.right, 2*value + 2);
    }
    
    public boolean find(int target) 
    {
        return set.contains(target);
    }
    
}
