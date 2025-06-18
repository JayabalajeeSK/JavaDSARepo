import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//-----------------------------------------
public class BSTToHeapViewOnly {

    static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static void simulateMinHeap(TreeNode root, List<Integer> list, int[] index) {
        if (root == null) return;
        System.out.print(list.get(index[0]++) + " ");
        simulateMinHeap(root.left, list, index);
        simulateMinHeap(root.right, list, index);
    }

    static void simulateMaxHeap(TreeNode root, List<Integer> list, int[] index) {
        if (root == null) return;
        simulateMaxHeap(root.left, list, index);
        simulateMaxHeap(root.right, list, index);
        System.out.print(list.get(index[0]++) + " ");
    }

    public static void main(String[] args) {
        // Unbalanced BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList); // Gives [1,2,3,4,5,6,7]

        System.out.println("Min Heap View (Preorder on sorted list):");
        simulateMinHeap(root, inorderList, new int[]{0}); // prints 1 2 3 4 5 6 7

        System.out.println("\nMax Heap View (Postorder on reversed list):");
        Collections.reverse(inorderList); // Becomes [7,6,5,4,3,2,1]
        simulateMaxHeap(root, inorderList, new int[]{0}); // prints 1 2 3 4 5 6 7
    }
}
// Min Heap View (Preorder on sorted list):
// 1 2 3 4 5 6 7 
// Max Heap View (Postorder on reversed list):
// 7 6 5 4 3 2 1 