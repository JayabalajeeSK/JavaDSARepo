package main1;

public class L29_1379_Find_a_Corresponding_Node_of_a_BT_in_a_Clone_of_That_Tree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {7, 4, 3, null, null, 6, 19};

        TreeNode original = buildBT(arr); // Build original tree
        TreeNode cloned = buildBT(arr);   // Clone tree with same structure

        System.out.println("\nOriginal Tree Structure:");
        printTree(original, 0);

        System.out.println("\nCloned Tree Structure:");
        printTree(cloned, 0);

        System.out.println("\nOriginal Tree (Level Order): " + treeToArray(original));
        System.out.println("Cloned Tree (Level Order): " + treeToArray(cloned));

        // 💡 Hardcoded target node (value = 3, located at original.right)
        TreeNode target = original.right;

        L29_1379_Find_a_Corresponding_Node_of_a_BT_in_a_Clone_of_That_Tree l29 = new L29_1379_Find_a_Corresponding_Node_of_a_BT_in_a_Clone_of_That_Tree();
        TreeNode result = l29.getTargetCopy(original, cloned, target);

        System.out.println("\n🎯 Target Value in Original Tree: " + target.val);
        System.out.println("🎯 Found Corresponding Node in Cloned Tree: " + result.val);
        System.out.println("🧪 Are they the same object? " + (target == result)); // false expected
    }
    //-------------------------------------------------
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
		if (original == null || original == target) return cloned;

		TreeNode result = getTargetCopy(original.left, cloned.left, target);

		if (result != null) return result;
        
		return getTargetCopy(original.right, cloned.right, target);
	}

    
}
// Original Tree Structure:
//         19
//     3
//         6
// 7
//     4

// Cloned Tree Structure:
//         19
//     3
//         6
// 7
//     4

// Original Tree (Level Order): [7, 4, 3, null, null, 6, 19]
// Cloned Tree (Level Order): [7, 4, 3, null, null, 6, 19]

// ? Target Value in Original Tree: 3
// ? Found Corresponding Node in Cloned Tree: 3
// ? Are they the same object? false