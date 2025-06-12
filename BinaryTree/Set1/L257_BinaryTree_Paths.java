package BinaryTree.Set1;

import java.util.ArrayList;
import java.util.List;

public class L257_BinaryTree_Paths 
{
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
//------------------------------------
class TreeNode 
 {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) {this.val = val;}
     TreeNode(int val, TreeNode left, TreeNode right) 
     {this.val = val; this.left = left; this.right = right;}
 }