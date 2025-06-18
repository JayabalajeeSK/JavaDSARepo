package main2;

public class L48_979_DistributeCoinsInBinaryTree extends TreeUtils {

    public static void main(String[] args) {
        // Example: Tree input = [3, 0, 0]
        Integer[] input = {3, 0, 0};

        TreeNode root = buildBT(input);
        System.out.println("🧾 Original Tree:");
        printTree(root, 0);
        System.out.println("📦 Tree Array: " + treeToString(root));

        L48_979_DistributeCoinsInBinaryTree obj = new L48_979_DistributeCoinsInBinaryTree();
        int moves = obj.distributeCoins(root);

        System.out.println("\n🚚 Minimum Moves Required: " + moves);
        System.out.println("📦 Final Tree Array: " + treeToString(root));
    }
    //------------------------------------------
    int ans=0;
    public int distributeCoins(TreeNode root) 
    {
        root.val=ans(root);
        return ans;
    }
    public int ans(TreeNode root)
    {
        if(root==null) return 0;
        root.val = (root.val-1) + ans(root.left) + ans(root.right);
        ans = ans + Math.abs(root.val);
        return root.val;
    }
    
}
// ? Original Tree:
//     0
// 3
//     0
// ? Tree Array: [3, 0, 0]

// ? Minimum Moves Required: 2
// ? Final Tree Array: [0, -1, -1]
