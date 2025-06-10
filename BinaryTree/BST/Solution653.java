package BinaryTree.BST;

import java.util.HashSet;
import java.util.Set;

public class Solution653 
{
    Set<Integer> result = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) 
    {
        if(root==null) return false;
        if(result.contains(k - root.val)) return true; result.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
    
}
