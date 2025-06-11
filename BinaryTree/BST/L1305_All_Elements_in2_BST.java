package BinaryTree.BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1305_All_Elements_in2_BST 
{
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        List<Integer> list =new ArrayList<>();

        inOrder(root1,list);
        inOrder(root2,list);

        Collections.sort(list);
        return list;
    }

    public void inOrder(TreeNode root,List<Integer> list)
    {
        if(root==null)return;

        list.add(root.val);
        
        inOrder(root.left,list);
        inOrder(root.right,list);
    }
    
}
