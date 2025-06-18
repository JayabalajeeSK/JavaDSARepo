package main3;

import java.util.ArrayList;
import java.util.List;

public class L60_257_BT_Paths extends TreeUtils 
{
    public static void main(String[] args) {
        // Sample tree: [1, 2, 3, null, 5]
        Integer[] arr = {1, 2, 3, null, 5};
        TreeNode root = buildBT(arr);

        System.out.println("🧾 Binary Tree (Visual):");
        printTree(root, 0);

        L60_257_BT_Paths obj = new L60_257_BT_Paths();
        List<String> paths = obj.binaryTreePaths(root);

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
        System.out.println("🛤️  All Root-to-Leaf Paths: " + paths);
    }
  //-------------------------------------------------------

  private void dfs(TreeNode node, String str, List<String> result) 
  {
    str = str + node.val;

    if (node.left == null && node.right == null) 
    {
      result.add(str);
      return;
    }
    str = str +  "->";
    
    if (node.left != null) dfs(node.left, str, result);

    if (node.right != null) dfs(node.right, str, result);
  }

  public List<String> binaryTreePaths(TreeNode root) 
  {
    var result = new ArrayList<String>();
    dfs(root, "", result) ;
    return result;
  }
    
}
// ? Binary Tree (Visual):
//     3
// 1
//         5
//     2

// ? Tree as Array: [1, 2, 3, null, 5]
// ??  All Root-to-Leaf Paths: [1->2->5, 1->3]