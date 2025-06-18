package main3;

public class L59_129_Sum_Root_To_Leaf_Numbers extends TreeUtils {
    public static void main(String[] args) {
        // Example: Tree = [1,2,3]
        Integer[] arr = {1, 2, 3};
        TreeNode root = buildBT(arr);

        System.out.println("🧾 Binary Tree (Visual):");
        printTree(root, 0);

        L59_129_Sum_Root_To_Leaf_Numbers obj = new L59_129_Sum_Root_To_Leaf_Numbers();
        int result = obj.sumNumbers(root);

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
        System.out.println("🧮 Sum of Root-to-Leaf Numbers: " + result);
    }
    //-----------------------------------------------
    public int sumNumbers(TreeNode root) 
    {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int sum) 
    {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) return sum;

        else return dfs(node.left, sum) + dfs(node.right, sum);  
    }
    
}
// ? Binary Tree (Visual):
//     3
// 1
//     2

// ? Tree as Array: [1, 2, 3]
// ? Sum of Root-to-Leaf Numbers: 25