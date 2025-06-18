package main3;

public class L58_235_LCA_of_BST extends TreeUtils {
    public static void main(String[] args) {
        // 🌳 Example BST
        Integer[] arr = {6,2,8,0,4,7,9,null,null,3,5};

        TreeNode root = buildBST(arr);
        TreeNode p = root.left; //2
        TreeNode q = root.left.right; //4

        System.out.println("🧾 Binary Search Tree:");
        printTree(root, 0);

        L58_235_LCA_of_BST obj = new L58_235_LCA_of_BST();
        TreeNode lca = obj.lowestCommonAncestor(root, p, q);

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
        System.out.println("📍 Lowest Common Ancestor of " + p.val + " and " + q.val + ": " + lca.val);
    }
//----------------------
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if( root == null) return null;
    
        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left,p,q);

        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right,p,q);
        
        return root;
    }
    
}
// ? Binary Search Tree:
//         9
//     8
//         7
// 6
//             5
//         4
//             3
//     2
//         0

// ? Tree as Array: [6, 2, 8, 0, 4, 7, 9, null, null, 3, 5]
// ? Lowest Common Ancestor of 2 and 4: 2