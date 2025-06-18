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
//--------------------------------------------
public class CountPairsFrom2BSTs 
{

    // Search value in second BST
    static boolean find(TreeNode root, int target) 
    {
        while (root != null) 
        {
            if (root.val == target) return true;
            root = (target < root.val) ? root.left : root.right;
            // else if (target < root.val)
            //     root = root.left;
            // else
            //     root = root.right;
        }
        return false;
    }

    // Count pairs from both BSTs whose sum equals x
    static int countPairs(TreeNode root1, TreeNode root2, int x) 
    {
        if (root1 == null) return 0;

        int count = find(root2, x - root1.val) ? 1 : 0;
        // int count = 0;
        // if (find(root2, x - root1.val)) { count = 1;}

        count = count + countPairs(root1.left, root2, x);
        count = count + countPairs(root1.right, root2, x);

        return count;
    }

    public static void main(String[] args) {
        // BST1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // BST2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);

        int x = 6;
        int result = countPairs(root1, root2, x);
        System.out.println("Total pairs with sum " + x + ": " + result);
    }
}
// Total pairs with sum 6: 2