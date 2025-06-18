package main3;

public class L62_100_Same_Tree extends TreeUtils {
    public static void main(String[] args) {
        // Define two binary trees
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        Integer[] arr3 = {1, 2, 4}; // Different from arr1 in right child

        TreeNode root1 = buildBT(arr1);
        TreeNode root2 = buildBT(arr2);
        TreeNode root3 = buildBT(arr3);

        L62_100_Same_Tree obj = new L62_100_Same_Tree();

        System.out.println("🌳 Tree 1:");
        printTree(root1, 0);
        System.out.println("\n🌳 Tree 2:");
        printTree(root2, 0);

        System.out.println("\n✅ Tree 1 and Tree 2 are same? " + obj.isSameTree(root1, root2)); // true

        System.out.println("\n🌳 Tree 3:");
        printTree(root3, 0);
        System.out.println("\n❌ Tree 1 and Tree 3 are same? " + obj.isSameTree(root1, root3)); // false
    }
    //-----------------------------------------------------------------------------------

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p==null && q== null) return true;
        if(p==null || q== null) return false;

        if(p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;

    }

    
}
// ? Tree 1:
//     3
// 1
//     2

// ? Tree 2:
//     3
// 1
//     2

// ? Tree 1 and Tree 2 are same? true

// ? Tree 3:
//     4
// 1
//     2

// ? Tree 1 and Tree 3 are same? false