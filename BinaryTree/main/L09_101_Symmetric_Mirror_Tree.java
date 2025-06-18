package main;

public class L09_101_Symmetric_Mirror_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {1,2,2,3,4,4,3};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        L09_101_Symmetric_Mirror_Tree l09 = new L09_101_Symmetric_Mirror_Tree();
        boolean isSymmetric = l09.isSymmetric(root); // Perform level-order traversal
        System.out.println(isSymmetric); // Output: [[3], [9, 20], [15, 7]]
    }
    //----------------------------------------------------------------------------------

    public boolean isSymmetric(TreeNode root) //1
    { //2
        // Start by checking if the left and right subtrees are mirror images
        return check(root.left, root.right); //3
    } //4

    private boolean check(TreeNode t1, TreeNode t2) //5
    { //6
        // Case 1: If both nodes are null, they are symmetric
        if (t1 == null && t2 == null) return true; //7

        // Case 2: If one node is null and the other is not, not symmetric
        if (t1 == null || t2 == null) return false; //8

        // Case 3: If the values are different, not symmetric
        if (t1.val != t2.val) return false; //9

        // Case 4: Check recursively:
        // - Left subtree of t1 with right subtree of t2
        // - Right subtree of t1 with left subtree of t2
        return check(t1.left, t2.right) && check(t1.right, t2.left); //10
    } //11


}
// Binary Tree Structure:
//         3
//     2
//         4
// 1
//         4
//     2
//         3

// BT: [1, 2, 2, 3, 4, 4, 3]

// true
// ✅ Time Complexity: O(N)
// Because we visit each node once.

// 🧠 Space Complexity:
// O(H) in worst case due to recursive call stack (H = height of tree)

// Skewed Tree → O(N)

// Balanced Tree → O(log N)