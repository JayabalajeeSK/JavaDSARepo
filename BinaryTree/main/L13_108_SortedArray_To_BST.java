package main;

public class L13_108_SortedArray_To_BST extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {-10,-3,0,5,9};
        TreeNode root = buildBST(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Search Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BST: " + treeToArray(root));
        System.out.println();

        L13_108_SortedArray_To_BST l12 = new L13_108_SortedArray_To_BST();
        int arrOP[] = new int[]{-10,-3,0,5,9};
        TreeNode sortedArrayToBST = l12.sortedArrayToBST(arrOP);

        
        System.out.println();
        System.out.println("Sorted array to BST: " + treeToArray(sortedArrayToBST));
        System.out.println();

    }
    //----------------------------------------------------------------------------------

    // Main function to convert a sorted array into a height-balanced BST
    public TreeNode sortedArrayToBST(int[] nums) //1
    { //2
        // Start recursive construction from full array range
        return contructTreeFromArray(nums, 0, nums.length - 1); //3
    } //4

    // Helper function to build BST from subarray range
    private TreeNode contructTreeFromArray(int[] nums, int left, int right) //5
    { //6
        // Base case: if left > right, no elements to use → return null
        if (left > right) return null; //7

        // Choose middle element to keep the tree balanced
        int mid = (left + right) / 2; //8

        // Create a node with the middle element
        TreeNode root = new TreeNode(nums[mid]); //9

        // Recursively build left subtree using left half
        root.left = contructTreeFromArray(nums, left, mid - 1); //10

        // Recursively build right subtree using right half
        root.right = contructTreeFromArray(nums, mid + 1, right); //11

        return root; //12
    } //13

}

// Binary Search Tree Structure:
//                 9
//             5
//         0
//     -3
// -10

// BST: [-10, null, -3, null, 0, null, 5, null, 9]


// Sorted array to BST: [0, -10, 5, null, -3, null, 9]
//  Time & Space Complexity:
// Time Complexity: O(N)
// (Each element is visited once)

// Space Complexity: O(log N)
// (For recursion stack in a balanced tree)
// Worst case (skewed): O(N)