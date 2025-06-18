package main3;

public class L57_222_Count_Complete_Tree_Nodes extends TreeUtils {
    public static void main(String[] args) {
        // 🌳 Example input (Complete Binary Tree)
        Integer[] arr = {1, 2, 3, 4, 5, 6};

        TreeNode root = buildBT(arr);

        System.out.println("🧾 Binary Tree (Visual):");
        printTree(root, 0);

        L57_222_Count_Complete_Tree_Nodes obj = new L57_222_Count_Complete_Tree_Nodes();
        int count = obj.countNodes(root);

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
        System.out.println("🔢 Total Nodes: " + count);
    }
    //----------------------------------------
    public int countNodes(TreeNode root) 
    {
        return counter(root);
    }
    public int counter(TreeNode node)
    {
        if(node==null) return 0;
        
        int leftSide = counter(node.left);
        int rightSide = counter(node.right);
        return leftSide + rightSide + 1;
    }
    
}
// ? Binary Tree (Visual):
//     3
//         6
// 1
//         5
//     2
//         4

// ? Tree as Array: [1, 2, 3, 4, 5, 6]
// ? Total Nodes: 6