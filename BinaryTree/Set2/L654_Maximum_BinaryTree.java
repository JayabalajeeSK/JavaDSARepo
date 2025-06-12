package BinaryTree.Set2;

public class L654_Maximum_BinaryTree 
{
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
        //first we create function return tree node with left right args passed 
        //the function searches all numbers to find highest and returns a treenode with high val
        //assign to left for left fun and vice versa for right
        return createTree(nums, 0, nums.length - 1);
    }

    public TreeNode createTree(int[] nums, int left, int right) 
    {
        if (left > right) return null; 

        int maxIndex = left;

        for (int i = left + 1; i <= right; i++) 
        {
            if (nums[i] > nums[maxIndex]) 
            {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = createTree(nums, left, maxIndex - 1); 
           
        root.right = createTree(nums, maxIndex + 1, right);  

        return root;
    }
    
}
