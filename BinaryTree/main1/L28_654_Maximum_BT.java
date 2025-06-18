package main1;

public class L28_654_Maximum_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        int[] nums = {3, 2, 1, 6, 0, 5};

        L28_654_Maximum_BT l28 = new L28_654_Maximum_BT();
        TreeNode root = l28.constructMaximumBinaryTree(nums);

        System.out.println("\nConstructed Maximum Binary Tree:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));
    }
    //-------------------------------------------------

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
// Constructed Maximum Binary Tree:
//     5
//         0
// 6
//             1
//         2
//     3

// Tree (Level Order): [6, 3, 5, null, 2, 0, null, null, 1]