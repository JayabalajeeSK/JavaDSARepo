package main2;

public class L55_538_1038_BST_to_GST extends TreeUtils {
    public static void main(String[] args) 
    {
        // 🔢 Sample input
        Integer[] arr = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = buildBT(arr);

        System.out.println("🌲 Original BST (Visual):");
        printTree(root, 0);

        L55_538_1038_BST_to_GST obj = new L55_538_1038_BST_to_GST();
        TreeNode updated = obj.convertBST(root);

        System.out.println("\n🔁 Converted to Greater Tree (Visual):");
        printTree(updated, 0);

        System.out.println("\n📦 Tree as Array: " + treeToString(updated));
    }
    //--------------------------------------------
    int greater = 0;

    private void convertBSTtoGreaterTree(TreeNode root) 
    {
        if (root == null) return;
    
        convertBSTtoGreaterTree(root.right);

        greater = greater + root.val;
        root.val = greater;

        convertBSTtoGreaterTree(root.left);
    }

    public TreeNode convertBST(TreeNode root) 
    {
        convertBSTtoGreaterTree(root);
        return root;
    }
    
}
// ? Original BST (Visual):
//             8
//         7
//     6
//         5
// 4
//             3
//         2
//     1
//         0

// ? Converted to Greater Tree (Visual):
//             8
//         15
//     21
//         26
// 30
//             33
//         35
//     36
//         36

// ? Tree as Array: [30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8]