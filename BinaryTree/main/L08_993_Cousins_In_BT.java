package main;


public class L08_993_Cousins_In_BT extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1,2,3,null,4,null,5};
        TreeNode root = buildBT(arr); // Build tree from array
        int x = 5;
        int y = 4;

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L08_993_Cousins_In_BT l08 = new L08_993_Cousins_In_BT();
        boolean isCousins = l08.isCousins(root, x, y); // Perform level-order traversal
        System.out.println(isCousins); // Output: [[3], [9, 20], [15, 7]]
    }
    //-----------------------------------------------------------------------------
    boolean ans = false;
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        dfs(root, x, y, 0);
        return ans;
    }

    private int dfs(TreeNode root, int x, int y, int depth)
    {
        if(root == null) return 0;

        int left = dfs(root.left, x, y, depth + 1);
        int right = dfs(root.right, x, y, depth + 1);

        if(left != 0 && right != 0 && left == right && left != depth + 1) ans = true;
    
        if(left != 0) return left;
        
        if(right != 0) return right;
        
        if(root.val == x || root.val == y) return depth;

        return 0;
    }

}

// Binary Tree Structure:
//         5
//     3
// 1
//         4
//     2

// BT: [1, 2, 3, null, 4, null, 5] -- 4,5

// true