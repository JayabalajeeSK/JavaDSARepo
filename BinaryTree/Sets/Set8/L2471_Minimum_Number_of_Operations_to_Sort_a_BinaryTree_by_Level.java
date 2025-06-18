package BinaryTree.Set8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class L2471_Minimum_Number_of_Operations_to_Sort_a_BinaryTree_by_Level {
    public int minimumOperations(TreeNode root) 
    {
        int res = 0;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) 
        {
            int n = q.size();
            List<Integer> list = new ArrayList<Integer>();
            while (n-- > 0) 
            {
                TreeNode curr = q.remove();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                list.add(curr.val);
            }
            res = res + minSwaps(list);
        }
        return res;
    }
    int minSwaps(List<Integer> list) 
    {
        int swaps = 0, n = list.size();
        List<Integer> sorted = new ArrayList<Integer>();
        sorted.addAll(list);
        Collections.sort(sorted);
        for (int i = 0; i < n; i++) 
        {
            if (list.get(i) != sorted.get(i)) 
            {
                ++swaps;
                Collections.swap(list, i, list.indexOf(sorted.get(i)));
            }
        }
        return swaps;
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