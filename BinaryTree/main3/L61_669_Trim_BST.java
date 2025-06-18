package main3;

public class L61_669_Trim_BST extends TreeUtils {
    public static void main(String[] args) {
        // Input BST: [3,0,4,null,2,null,null,1]
        Integer[] arr = {3, 0, 4, null, 2, null, null, 1};
        TreeNode root = buildBST(arr);

        System.out.println("🌳 Original Tree:");
        printTree(root, 0);

        int low = 1, high = 3;
        L61_669_Trim_BST obj = new L61_669_Trim_BST();
        TreeNode trimmed = obj.trimBST(root, low, high);

        System.out.println("\n✂️ Trimmed Tree ([" + low + ", " + high + "]):");
        printTree(trimmed, 0);

        System.out.println("\n📦 Tree as Array: " + treeToString(trimmed));
    }
    //-----------------------------------------------

    public TreeNode trimBST(TreeNode node, int low, int high) 
    {
        if(node == null) return null;

        node.left = trimBST(node.left, low, high);
        node.right = trimBST(node.right, low, high);

        if(node.val > high || node.val < low)
        {
            if(node.left != null) return node.left;
            else return node.right;
        }
        else return node;
    }
    
}
// ? Original Tree:
//     4
// 3
//         2
//             1
//     0

// ?? Trimmed Tree ([1, 3]):
// 3
//     2
//         1

// ? Tree as Array: [3, 2, null, 1]