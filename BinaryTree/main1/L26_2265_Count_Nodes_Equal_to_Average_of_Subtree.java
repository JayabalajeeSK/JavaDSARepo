package main1;

public class L26_2265_Count_Nodes_Equal_to_Average_of_Subtree extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {4,8,5,0,1,null,6};
        TreeNode root = buildBT(arr); // Use buildBT to keep original structure

        System.out.println("\nBinary Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (level order): " + treeToArray(root));

        L26_2265_Count_Nodes_Equal_to_Average_of_Subtree l26 = new L26_2265_Count_Nodes_Equal_to_Average_of_Subtree();
        int result = l26.averageOfSubtree(root);

        System.out.println("\nCount of Nodes Equal to Average of Subtree: " + result);
    }
    //------------------------------------------------------------------------

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
// Binary Tree Structure:
//         6
//     5
// 4
//         1
//     8
//         0

// Tree (level order): [4, 8, 5, 0, 1, null, 6]

// Count of Nodes Equal to Average of Subtree: 5