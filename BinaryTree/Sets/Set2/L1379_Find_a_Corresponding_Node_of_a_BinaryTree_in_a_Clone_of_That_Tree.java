package BinaryTree.Set2;

public class L1379_Find_a_Corresponding_Node_of_a_BinaryTree_in_a_Clone_of_That_Tree 
{
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
		if (original == null || original == target) return cloned;

		TreeNode result = getTargetCopy(original.left, cloned.left, target);

		if (result != null) return result;
        
		return getTargetCopy(original.right, cloned.right, target);
	}
    
}
