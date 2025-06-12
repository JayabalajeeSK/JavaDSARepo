package BinaryTree.Set1;

import java.util.ArrayList;

public class L872_Leaf_Similar_Trees 
{
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        ArrayList<Integer> treeLeaf1 = new ArrayList<>();
        treeLeaf1 = check(root1, treeLeaf1);

        ArrayList<Integer> treeLeaf2 = new ArrayList<>();
        treeLeaf2 = check(root2, treeLeaf2);

        return treeLeaf1.equals(treeLeaf2);
    }

    ArrayList<Integer> check(TreeNode root, ArrayList<Integer> treeLeaf)
    {
        if(root == null) return treeLeaf;
    
        if(root.left == null && root.right == null) treeLeaf.add(root.val);
        
        treeLeaf = check(root.left, treeLeaf);
        treeLeaf = check(root.right, treeLeaf);
        return treeLeaf;
    }
    
}
