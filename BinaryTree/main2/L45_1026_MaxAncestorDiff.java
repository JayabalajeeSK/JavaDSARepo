package main2;

public class L45_1026_MaxAncestorDiff extends TreeUtils {
    public static void main(String[] args) {
        // 👇 Sample input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
        Integer[] arr = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};

        // 🧱 Build Binary Tree
        TreeNode root = buildBT(arr);

        // 🌲 Print Tree
        System.out.println("Binary Tree:");
        printTree(root, 0);
        System.out.println("Tree Array: " + treeToString(root));

        // 🔍 Run solution
        L45_1026_MaxAncestorDiff obj = new L45_1026_MaxAncestorDiff();
        int result = obj.maxAncestorDiff(root);
        System.out.println("✅ Maximum Ancestor Difference: " + result);
    }
    //--------------------------------------------------------------
    
    public int maxAncestorDiff(TreeNode root) 
    {
        return maxDiff(root,root.val,root.val);      
    }

    public int maxDiff(TreeNode root , int min , int max) 
    {
        return root!=null? Math.max(maxDiff(root.left, Math.min(min,root.val), Math.max(max,root.val)),
                                    maxDiff(root.right,Math.min(min,root.val),Math.max(max,root.val))) 
                                    : max-min;    
    }
}
// Binary Tree:
//         14
//             13
//     10
// 8
//             7
//         6
//             4
//     3
//         1
// Tree Array: [8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13]
// ? Maximum Ancestor Difference: 7
