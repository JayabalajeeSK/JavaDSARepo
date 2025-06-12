package BinaryTree.Set2;

public class L2265_Count_Nodes_Equal_to_Average_of_Subtree {
    
    int res = 0;

    public int averageOfSubtree(TreeNode root) 
    {
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root)
    {
        if(root==null) return new int[]{0,0};

        int[] left = dfs(root.left);

        int[] right = dfs(root.right);

        int sum = left[0] + root.val + right[0];

        int count = left[1] + 1 + right[1];

        int avg = sum/count;
        
        if(avg == root.val) res++;
        
        return new int[]{sum,count};
    }
    
}
