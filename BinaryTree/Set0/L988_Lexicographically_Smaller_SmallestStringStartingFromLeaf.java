package BinaryTree.Set0;
public class L988_Lexicographically_Smaller_SmallestStringStartingFromLeaf 
{
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
