package BinaryTree.BST;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution108
{
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        return contructTreeFromArray(nums, 0, nums.length - 1);
    }

    private TreeNode contructTreeFromArray(int[] nums, int left, int right) 
    {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = contructTreeFromArray(nums, left, mid - 1);
        root.right = contructTreeFromArray(nums, mid + 1, right);
        return root;
    }
}
public class L108_SortedArrayToBST {
    
    // Level Order print including nulls to match the output format
    public static List<String> levelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }
        
        // Remove trailing nulls for cleaner output (optional)
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        // Manual Tree as per your given output
        TreeNode manualRoot = new TreeNode(0);
        manualRoot.left = new TreeNode(-3);
        manualRoot.right = new TreeNode(9);
        manualRoot.left.left = new TreeNode(-10);
        manualRoot.right.left = new TreeNode(5);

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Manual Output (Level Order): " + levelOrder(manualRoot));

        // Using Solution108 to build tree automatically
        Solution108 sol = new Solution108();
        TreeNode autoRoot = sol.sortedArrayToBST(nums);
        System.out.println("Auto Output (Level Order): " + levelOrder(autoRoot));
    }
}
// Input: nums = [-10, -3, 0, 5, 9]
// Manual Output (Level Order): [0, -3, 9, -10, null, 5]
// Auto Output (Level Order): [0, -10, 5, null, -3, null, 9]