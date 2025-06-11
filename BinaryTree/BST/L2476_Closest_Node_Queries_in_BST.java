package BinaryTree.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class L2476_Closest_Node_Queries_in_BST 
{
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        collectBSTvalues(root);
        for (int num : queries) 
        {
		//if num is present add num else add lower value than num
            Integer low = map.containsKey(num) ? Integer.valueOf(num) : map.lowerKey(num);

		//if num is present add num else add higher value than num
            Integer high = map.containsKey(num) ? Integer.valueOf(num) : map.higherKey(num);
            
		//if low or high value also not present add -1 else add low or high
            ans.add(Arrays.asList(low == null ? -1 : low, high == null ? -1 : high));
        }
        return ans;
    }

    void collectBSTvalues(TreeNode root) 
    {
        if (root == null) return;

        map.put(root.val, 0);
        collectBSTvalues(root.left);
        collectBSTvalues(root.right);
    }
//The `higherKey()`method class is used to return the least key strictly greater than the given key, or null if there is no such key.
//AND
//The `lowerKey()` method is used to return the greatest key strictly less than to given key, 
    
}
