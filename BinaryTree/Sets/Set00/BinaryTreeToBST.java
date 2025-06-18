import java.util.ArrayList;
import java.util.Collections;
class Node 
{
    int val;
    Node left, right;
    Node(int x) 
    {
        val = x;
        left = null;
        right = null;
    }
}
//-------------------------------------------------
public class BinaryTreeToBST 
{

    // Step 1: Store inorder traversal of the binary tree
    static void storeInorder(Node root, ArrayList<Integer> inorder) 
    {
        if (root == null) return;

        storeInorder(root.left, inorder);

        inorder.add(root.val);

        storeInorder(root.right, inorder);
    }

    // Step 2: Convert list into BST using inorder traversal
    static void arrayToBST(Node root, ArrayList<Integer> inorder, int[] index) 
    {
        if (root == null) return;

        arrayToBST(root.left, inorder, index);

        root.val = inorder.get(index[0]);
        index[0]++;

        arrayToBST(root.right, inorder, index);
    }

    // Main function to convert Binary Tree to BST
    static Node binaryTreeToBST(Node root) 
    {
        ArrayList<Integer> inorder = new ArrayList<>();
        
        // Get inorder traversal of the binary tree
        storeInorder(root, inorder);

        // Sort the list to get elements in BST order
        Collections.sort(inorder);

        // Convert binary tree to BST using sorted values
        int[] index = {0}; // Using array to pass by reference

        arrayToBST(root, inorder, index);

        return root;
    }

    // Traversal functions
    static void printInorder(Node root) 
    {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    static void printPreorder(Node root) 
    {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    static void printPostorder(Node root) 
    {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) 
    {
        // Creating the tree:
        //         10
        //        /  \
        //       2    7
        //      / \
        //     8   4
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(4);

        Node ans = binaryTreeToBST(root);

        // Printing all traversals
        System.out.print("Inorder of converted BST: ");
        printInorder(ans);
        System.out.println();

        System.out.print("Preorder of converted BST: ");
        printPreorder(ans);
        System.out.println();

        System.out.print("Postorder of converted BST: ");
        printPostorder(ans);
        System.out.println();
    }
}
// Inorder of converted BST: 2 4 7 8 10 
// Preorder of converted BST: 8 4 2 7 10 
// Postorder of converted BST: 2 7 4 10 8 