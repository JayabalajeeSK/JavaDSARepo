package main5;

public class L572 extends TreeUtils
{
    public static void main(String[] args) 
    {
        // 🔷 Main Tree
        Integer[] arr1 = {3, 4, 5, 1, 2};
        TreeNode root = buildBT(arr1);

        // 🔹 Subtree to check
        Integer[] arr2 = {4, 1, 2};
        TreeNode subRoot = buildBT(arr2);

        System.out.println("Main Tree Structure:");
        printTree(root, 0);
        System.out.println("\nMain Tree (Level Order): " + treeToArray(root));

        System.out.println("\nSub Tree Structure:");
        printTree(subRoot, 0);
        System.out.println("\nSub Tree (Level Order): " + treeToArray(subRoot));

        L572 l572 = new L572();
        boolean result = l572.isSubtree(root, subRoot);

        System.out.println("\nIs subRoot a subtree of root? " + result);
    }
    //---------------------------------------

    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    { // takes O(m x n)
        if (root == null) return subRoot == null;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) 
    { // takes O(n)
        if (root == null && subRoot == null) return true;

        if (root == null || subRoot == null) return false;
        
        if (root.val != subRoot.val) return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
    
}
// Main Tree Structure:
//     5
// 3
//         2
//     4
//         1

// Main Tree (Level Order): [3, 4, 5, 1, 2]

// Sub Tree Structure:
//     2
// 4
//     1

// Sub Tree (Level Order): [4, 1, 2]

// Is subRoot a subtree of root? true