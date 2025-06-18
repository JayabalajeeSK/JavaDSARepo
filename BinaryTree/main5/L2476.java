package main5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class L2476 extends TreeUtils 
{
    public static void main(String[] args) 
    {
        Integer[] arr = {6,2,13,1,4,9,15,null,null,null,null,null,null,14}; // BST
        TreeNode root = buildBT(arr);

        System.out.println("Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));

        List<Integer> queries = Arrays.asList(2, 5, 16);

        L2476 obj = new L2476();
        List<List<Integer>> result = obj.closestNodes(root, queries);

        System.out.println("\nQueries and Closest Nodes:");
        for (int i = 0; i < queries.size(); i++) 
        {
            System.out.println("Query: " + queries.get(i) + " => Closest: " + result.get(i));
        }
    }

//---------------------------------------
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
// Tree Structure:
//         15
//             14
//     13
//         9
// 6
//         4
//     2
//         1

// Tree (Level Order): [6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14]

// Queries and Closest Nodes:
// Query: 2 => Closest: [2, 2]
// Query: 5 => Closest: [4, 6]
// Query: 16 => Closest: [15, -1]
