import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {this.val = val;}

    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//--------------------------------------------
public class MedianBST 
{

    // Inorder traversal to get sorted values
    static void inorder(TreeNode root, List<Integer> list) 
    {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Median function
    static double findMedian(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int n = list.size();
        if (n % 2 == 1) return list.get(n / 2); //odd
        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0; //even
    }

    // Main
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("Median: " + findMedian(root));
    }
}
// Median: 6.0