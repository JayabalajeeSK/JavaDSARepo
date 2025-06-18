package main1;

import java.util.HashSet;
import java.util.Set;

public class L33_1261_Find_Elements_in_a_Contaminated_Binary_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {-1, -1, -1, -1, null, -1, -1}; // Contaminated binary tree
        TreeNode root = buildBT(arr); // buildBT builds normal tree with nulls

        System.out.println("\nContaminated Binary Tree Structure:");
        printTree(root, 0);

        L33_1261_Find_Elements_in_a_Contaminated_Binary_Tree l33 = new L33_1261_Find_Elements_in_a_Contaminated_Binary_Tree();
        l33.FindElements(root); // recover the tree

        System.out.println("\nRecovered Tree Structure:");
        printTree(root, 0);

        int[] queries = {1, 3, 5, 6}; // Check for these values in recovered tree
        for (int q : queries) 
        {
            System.out.println("Does " + q + " exist? " + l33.find(q));
        }
    }
    //-----------------------------------------------

    Set<Integer> set = new HashSet<>(); // HashSet to store all recovered values

    // Constructor: used to recover the tree from a corrupted version
    public void FindElements(TreeNode root) {
        recoverTree(root, 0); // Start recovery from root with value 0
    }

    // Recursive function to assign correct values to tree nodes
    private void recoverTree(TreeNode root, int value) {
        if (root == null) return; // Base case

        root.val = value; // Assign the recovered value
        set.add(value);   // Add value to set for O(1) lookup

        // Recur for left and right children with new values
        recoverTree(root.left, 2 * value + 1);
        recoverTree(root.right, 2 * value + 2);
    }

    // Function to check if a target value exists in the recovered tree
    public boolean find(int target) {
        return set.contains(target); // O(1) lookup
    }
    
}
// Contaminated Binary Tree Structure:
//         -1
//     -1
//         -1
// -1
//     -1
//         -1

// Recovered Tree Structure:
//         6
//     2
//         5
// 0
//     1
//         3
// Does 1 exist? true
// Does 3 exist? true
// Does 5 exist? true
// Does 6 exist? true
// Recovery:

// Time: O(n) (every node visited once)

// Space: O(n) (for storing values in HashSet)

// Find:

// Time: O(1) (HashSet lookup)