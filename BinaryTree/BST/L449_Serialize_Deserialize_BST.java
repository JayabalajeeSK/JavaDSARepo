package BinaryTree.BST;

public class L449_Serialize_Deserialize_BST 
{
    static TreeNode node;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        node = root;
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        return node;
    }
    
}
