package BinaryTree.Set2;

public class L1315_Sum_of_Nodes_with_Even_Valued_Grandparent 
{
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) 
    {
        return gs(root, 1, 1);
    }
    public int gs(TreeNode node, int parent, int grandParent) 
    {    
        if(node == null)  return 0;

        gs(node.left, node.val, parent);

        gs(node.right, node.val, parent);

        if(grandParent % 2 == 0) sum = sum + node.val;

        return sum;
    }
    
}
