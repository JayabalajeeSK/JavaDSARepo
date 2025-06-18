// Java Program to find Inorder Successor in a BST
class Node 
{
    int value;
    Node left, right;

    Node(int value) 
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
//----------------------------------------
public class InorderSuccessor 
{
    // Function to find the leftmost (smallest) node in a subtree
    static Node findLeftmost(Node node) 
    {
        while (node != null && node.left != null) node = node.left;
        return node;
    }

    // Function to find inorder successor of a given value in BST
    static Node findInorderSuccessor(Node root, int key) 
    {
        Node successor = null;
        Node current = root;

        while (current != null) 
        {
            if (key < current.value) // Current node could be successor; go left to find closer one
            {
                
                successor = current;
                current = current.left;
            } 
          	else if (key > current.value) current = current.right;
                // Go right to find the node
                
            else 
            {
                // If node is found
                if (current.right != null)  successor = findLeftmost(current.right);
                    // Successor is the leftmost node in right subtree
                break;
            }
        }
        return successor;
    }
//--------------------------------------------------------
    public static void main(String[] args) 
    {
        // Construct the BST
        /*
                    20
                   /  \
                 8     22
                / \
              4   12
                 /  \
               10   14
        */
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int key = 14;
        Node successor = findInorderSuccessor(root, key);

        if (successor != null) System.out.println("Inorder Successor of " + key + " is: " + successor.value);
        else System.out.println("Inorder Successor of " + key + " does not exist.");
    }
}
// Inorder Successor of 14 is: 20