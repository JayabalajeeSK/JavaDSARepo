package main2;


public class L42_617_Merge_Two_Binary_Trees extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr1 = {1, 3, 2, 5};
        Integer[] arr2 = {2, 1, 3, null, 4, null, 7};

        TreeNode root1 = buildBT(arr1);
        TreeNode root2 = buildBT(arr2);

        System.out.println("Tree 1:");
        printTree(root1, 0);

        System.out.println("\nTree 2:");
        printTree(root2, 0);

        L42_617_Merge_Two_Binary_Trees l42 = new L42_617_Merge_Two_Binary_Trees();
        TreeNode mergedRoot = l42.mergeTrees(root1, root2);

        System.out.println("\nMerged Tree Structure:");
        printTree(mergedRoot, 0);

        System.out.println("\nMerged Tree Level Order: " + treeToArray(mergedRoot));
    }
    //-----------------------------------------
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) 
    {
        if(root1==null) return root2;

        if(root2==null) return root1;

        root1.val = root1.val + root2.val;

        root1.left = mergeTrees(root1.left,root2.left);

        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
    
}
// Tree 1:
//     2
// 1
//     3
//         5

// Tree 2:
//         7
//     3
// 2
//         4
//     1

// Merged Tree Structure:
//         7
//     5
// 3
//         4
//     4
//         5

// Merged Tree Level Order: [3, 4, 5, 5, 4, null, 7]
// Time	O(n)
// Space (rec stack)	O(h) = O(log n) for balanced, O(n) for skewed