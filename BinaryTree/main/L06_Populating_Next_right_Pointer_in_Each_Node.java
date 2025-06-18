package main;

import java.util.List;


public class L06_Populating_Next_right_Pointer_in_Each_Node extends TreeUtils
{

    public static void main(String[] args) 
    {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildBT(arr); // Build tree from array

        System.out.println();
        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0); 

        System.out.println();
        System.out.println("BT: " + treeToArray(root));
        System.out.println();

        // L06_Populating_Next_right_Pointer_in_Each_Node l01 = new L06_Populating_Next_right_Pointer_in_Each_Node();
        // Node levels = l01.connect(root); // Perform level-order traversal
        // System.out.println(levels); // Output: [[3], [9, 20], [15, 7]]
    }

    public Node connect(Node root)
    {
        if(root==null) return null;
        Node leftMost=root;
        while(leftMost.left != null)
        {
            Node current = leftMost;
            while(current != null)
            {
                current.left.next = current.right;
                if(current.next != null) current.right.next = current.next.left;
                current=current.next;
            }
            leftMost=leftMost.left;
        }
        return root;
    }
}
