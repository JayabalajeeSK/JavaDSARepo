package BinaryTree.Set6;

public class L1325_Delete_Leaves_With_a_Given_Value 
{

    public TreeNode removeLeafNodes(TreeNode root, int target) 
    {
        //Base Condition.
        if(root == null) return null;

        //left sub-tree
        root.left = removeLeafNodes(root.left,target);

        //right sub-tree
        root.right = removeLeafNodes(root.right,target);

        //check weather the target match with the root.val and check weather it is leaf or not if yes return null else node.
        if(root.left == null && root.right== null && root.val == target) return null;

        return root;
    }
    
}
