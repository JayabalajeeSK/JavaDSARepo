package main4;

public class L67_404_sum_of_Left_Leaves extends TreeUtils {
    public static void main(String[] args) {
        // Sample Input: [3,9,20,null,null,15,7]
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildBT(arr);

        L67_404_sum_of_Left_Leaves obj = new L67_404_sum_of_Left_Leaves();
        int sum = obj.sumOfLeftLeaves(root);

        System.out.println("🌳 Tree:");
        printTree(root, 0);

        System.out.println("\n🍃 Sum of Left Leaves: " + sum); // Output should be 24 (9 + 15)
    }
    //--------------------------------------------

    public int sumOfLeftLeaves(TreeNode root) 
    {
        return sumofLeftLeaves(root,false);
    }
    
    int sumofLeftLeaves(TreeNode root, boolean isLeft) 
    {
        if (root == null) return 0;
    
        if (root.left == null && root.right == null) return isLeft ? root.val : 0;

        int leftSum = sumofLeftLeaves(root.left, true);
        int rightSum = sumofLeftLeaves(root.right, false);
        return leftSum + rightSum;
    }
    
}
// ? Tree:
//         7
//     20
//         15
// 3
//     9

// ? Sum of Left Leaves: 24