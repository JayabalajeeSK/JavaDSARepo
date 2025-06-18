package main2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L51_2641_ReplaceValueInTree extends TreeUtils {
    public static void main(String[] args) {
        // Test Case 1: Example from LeetCode
        System.out.println("🔹 Example 1 Input: [5,4,9,1,10,null,7]");
        Integer[] arr1 = {5, 4, 9, 1, 10, null, 7};
        TreeNode root1 = buildBT(arr1);
        printTree(root1, 0);

        L51_2641_ReplaceValueInTree obj = new L51_2641_ReplaceValueInTree();
        TreeNode modified1 = obj.replaceValueInTree(root1);

        System.out.println("\n🔸 Modified Tree:");
        printTree(modified1, 0);
        System.out.println("📦 Tree as Array: " + treeToString(modified1));
    }
    //---------------------------------------

    public TreeNode replaceValueInTree(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> sumList = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int sum = 0, size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode tmp = queue.poll();
                sum = sum + tmp.val;

                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
            sumList.add(sum);
        }
        root.val = 0;
        dfs(1,root,sumList);
        return root;
    }

    public void dfs(int nextDepth, TreeNode root,List<Integer> sumList)
    {
        if(root == null) return;

        int sumCousin = nextDepth < sumList.size() ? sumList.get(nextDepth) : 0;

        sumCousin -= root.left != null ? root.left.val : 0;
        sumCousin -= root.right != null ? root.right.val : 0;

        if(root.left != null) root.left.val = sumCousin;
        if(root.right != null) root.right.val = sumCousin;
        
        dfs(nextDepth+1,root.left,sumList);
        dfs(nextDepth+1,root.right,sumList);
    }
    
}
// ? Example 1 Input: [5,4,9,1,10,null,7]
//         7
//     9
// 5
//         10
//     4
//         1

// ? Modified Tree:
//         11
//     0
// 0
//         7
//     0
//         7
// ? Tree as Array: [0, 0, 0, 7, 7, null, 11]