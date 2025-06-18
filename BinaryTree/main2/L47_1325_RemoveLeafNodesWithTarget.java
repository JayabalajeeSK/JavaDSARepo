package main2;

public class L47_1325_RemoveLeafNodesWithTarget extends TreeUtils 
{
    public static void main(String[] args) 
    {
        // Sample Input: Tree and target
        Integer[] input = {1, 2, 3, 2, null, 2, 4};
        int target = 2;

        TreeNode root = buildBT(input);
        System.out.println("🧾 Original Tree:");
        printTree(root, 0);
        System.out.println("📦 Tree Array: " + treeToString(root));

        // Remove target leaf nodes
        L47_1325_RemoveLeafNodesWithTarget obj = new L47_1325_RemoveLeafNodesWithTarget();
        TreeNode result = obj.removeLeafNodes(root, target);

        System.out.println("\n🔥 After Removing Target Leaf Nodes (target = " + target + "):");
        printTree(result, 0);
        System.out.println("📦 Resulting Tree Array: " + treeToString(result));
    }
    //---------------------------------------
    public TreeNode removeLeafNodes(TreeNode root, int target) 
    {
        //Base Condition.
        if(root == null) return null;

        //left sub-tree
        root.left = removeLeafNodes(root.left,target);

        //right sub-tree
        root.right = removeLeafNodes(root.right,target);

        //check weather the target match with the root.val and check weather it is leaf or not if yes return null else node.
        if(root.left == null && root.right== null && root.val == target) return null;

        return root;
    }
}
// ? Original Tree:
//         4
//     3
//         2
// 1
//     2
//         2
// ? Tree Array: [1, 2, 3, 2, null, 2, 4]

// ? After Removing Target Leaf Nodes (target = 2):
//         4
//     3
// 1
// ? Resulting Tree Array: [1, null, 3, null, 4]