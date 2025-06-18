package main3;

public class L63_563_BT_Tilt extends TreeUtils {
    public static void main(String[] args) {
        // Sample Input: Tree = [1, 2, 3]
        Integer[] arr = {1, 2, 3};
        TreeNode root = buildBT(arr);

        System.out.println("🧾 Binary Tree:");
        printTree(root, 0);

        L63_563_BT_Tilt obj = new L63_563_BT_Tilt();
        int totalTilt = obj.findTilt(root);

        System.out.println("\n📐 Total Tilt of Tree: " + totalTilt);
    }
    //--------------------------------------------
    int tilt = 0;
    public int solve(TreeNode root)
    {
        if(root==null) return 0;
    
        int leftSide = solve(root.left);

        int rightSide = solve(root.right);
        tilt = tilt + Math.abs(leftSide - rightSide);
        return leftSide +rightSide + root.val;
        
    }
    public int findTilt(TreeNode root) 
    {
        solve(root);
        return tilt;
    }
    
}
// ? Binary Tree:
//     3
// 1
//     2

// ? Total Tilt of Tree: 1