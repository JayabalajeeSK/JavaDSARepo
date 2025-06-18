package main1;

public class L37_2331_Evaluate_Boolean_Binary_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {2,1,3,null,null,0,1};  // OR root, true OR (false AND true)

        TreeNode root = buildBT(arr);

        System.out.println("\nBoolean Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (level order): " + treeToArray(root));

        L37_2331_Evaluate_Boolean_Binary_Tree l37 = new L37_2331_Evaluate_Boolean_Binary_Tree();
        boolean result = l37.evaluateTree(root);

        System.out.println("\nEvaluated Boolean Expression Result: " + result);
    }
//-------------------------------------------------------------------------
    public boolean evaluateTree(TreeNode root) 
    {
        return root.left == null ? root.val == 1 
                                 : root.val == 2 
                                 ? evaluateTree(root.left) || evaluateTree(root.right) 
                                 : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
// Boolean Tree Structure:
//         1
//     3
//         0
// 2
//     1

// Tree (level order): [2, 1, 3, null, null, 0, 1]

// Evaluated Boolean Expression Result: true
// Type	Complexity
// Time	O(n)
// Space (avg)	O(log n)
// Space (worst)	O(n)