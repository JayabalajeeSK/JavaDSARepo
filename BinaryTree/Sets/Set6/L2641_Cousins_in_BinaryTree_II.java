package BinaryTree.Set6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L2641_Cousins_in_BinaryTree_II 
{
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
