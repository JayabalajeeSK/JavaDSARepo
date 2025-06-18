package main5;

public class L111 extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = buildBT(arr);

        System.out.println("Tree Structure:");
        printTree(root, 0);

        System.out.println("\nBinary Tree (Level Order): " + treeToArray(root));

        L111 l111 = new L111();
        int minDepth = l111.minDepth(root);

        System.out.println("\nMinimum Depth of Tree: " + minDepth);
    }
    //--------------------------------------
    public int minDepth(TreeNode root)
    {
        if(root==null) return 0;
        return findMinDepth(root);
    }

    private int findMinDepth(TreeNode root) 
    {
        if(root.left==null && root.right==null) return 1;
        
        int left = Integer.MAX_VALUE;
        if(root.left!=null)
        {
            left = 1 + findMinDepth(root.left);
        }

        int right = Integer.MAX_VALUE;
        if(root.right!=null)
        {
            right = 1 + findMinDepth(root.right);
        }
        return Math.min(left, right);

    }
}
// Tree Structure:
//         7
//     20
//         15
// 3
//     9

// Binary Tree (Level Order): [3, 9, 20, null, null, 15, 7]

// Minimum Depth of Tree: 2
