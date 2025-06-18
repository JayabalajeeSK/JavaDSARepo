package main;



public class L00_2_988_Lexico_Smallest_String_Starting_From_Leaf extends TreeUtils 
{
    public static void main(String[] args) 
    {
        // Test Input: [0,1,2,3,4,3,4] => Tree structure as per level-order
        Integer[] arr = {0, 1, 2, 3, 4, 3, 4};
        TreeNode root = buildBT(arr);

        L00_2_988_Lexico_Smallest_String_Starting_From_Leaf obj = new L00_2_988_Lexico_Smallest_String_Starting_From_Leaf();
        String smallest = obj.smallestFromLeaf(root);

        System.out.println("🌳 Binary Tree:");
        printTree(root, 0);

        System.out.println("\n🔡 Smallest String From Leaf: " + smallest); // Example expected: "dba"
    }

    //----------------------------------------------------------------------------------
    private String smallestString = null;
    public String smallestFromLeaf(TreeNode root) 
    {
        // Start the DFS traversal from the root node with an empty path and the mapping from values to alphabet characters
        DFS(root, "", "abcdefghijklmnopqrstuvwxyz");
        return smallestString;
    }

    private void DFS(TreeNode node, String path, String mapping) 
    {
        // If the current node is null, return
        if (node == null) return;

        // Get the alphabet character corresponding to the current node's value
        char currentChar = mapping.charAt(node.val);

        // Append the current character to the path
        String currentPath = currentChar + path;

        // If the current node is a leaf node, update the smallest string found so far
        if (node.left == null && node.right == null) updateSmallestString(currentPath);

        // Recursively traverse the left subtree with the updated path and mapping
        DFS(node.left, currentPath, mapping);

        // Recursively traverse the right subtree with the updated path and mapping
        DFS(node.right, currentPath, mapping);
    }

    private void updateSmallestString(String path) 
    {
        // If the smallest string is null or the current path is lexicographically smaller, update the smallest string
        if (smallestString == null || path.compareTo(smallestString) < 0) smallestString = path;
    }

    
}
// ? Binary Tree:
//         4
//     2
//         3
// 0
//         4
//     1
//         3

// ? Smallest String From Leaf: dba

// ⏱️ Time Complexity:
// ✅ O(N) — where N is the number of nodes.

// We visit every node once in DFS.

// 📦 Space Complexity:
// ✅ O(H) — where H is the height of the tree due to recursion stack.

// Best case (balanced tree): O(log N)

// Worst case (skewed tree): O(N)