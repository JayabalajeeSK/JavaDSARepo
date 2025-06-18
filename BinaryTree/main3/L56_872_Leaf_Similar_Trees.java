package main3;

import java.util.ArrayList;

public class L56_872_Leaf_Similar_Trees extends TreeUtils {
    public static void main(String[] args) {
        // 🌳 Example input
        Integer[] arr1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] arr2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};

        TreeNode root1 = buildBT(arr1);
        TreeNode root2 = buildBT(arr2);

        System.out.println("🧾 Tree 1:");
        printTree(root1, 0);

        System.out.println("\n🧾 Tree 2:");
        printTree(root2, 0);

        L56_872_Leaf_Similar_Trees obj = new L56_872_Leaf_Similar_Trees();

        boolean result = obj.leafSimilar(root1, root2);

        System.out.println("\n🍃 Leaf Nodes of Tree 1: " + obj.check(root1, new ArrayList<>()));
        System.out.println("🍃 Leaf Nodes of Tree 2: " + obj.check(root2, new ArrayList<>()));

        System.out.println("\n✅ Are both trees leaf-similar? " + result);
    }
    //-------------------------------------------------------

    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        ArrayList<Integer> treeLeaf1 = new ArrayList<>();
        treeLeaf1 = check(root1, treeLeaf1);

        ArrayList<Integer> treeLeaf2 = new ArrayList<>();
        treeLeaf2 = check(root2, treeLeaf2);

        return treeLeaf1.equals(treeLeaf2);
    }

    ArrayList<Integer> check(TreeNode root, ArrayList<Integer> treeLeaf)
    {
        if(root == null) return treeLeaf;
    
        if(root.left == null && root.right == null) treeLeaf.add(root.val);
        
        treeLeaf = check(root.left, treeLeaf);
        treeLeaf = check(root.right, treeLeaf);
        return treeLeaf;
    }
    
}
// ? Tree 1:
//         8
//     1
//         9
// 3
//             4
//         2
//             7
//     5
//         6

// ? Tree 2:
//             8
//         2
//             9
//     1
//         4
// 3
//         7
//     5
//         6

// ? Leaf Nodes of Tree 1: [6, 7, 4, 9, 8]
// ? Leaf Nodes of Tree 2: [6, 7, 4, 9, 8]

// ? Are both trees leaf-similar? true