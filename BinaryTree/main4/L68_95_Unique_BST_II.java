package main4;

import java.util.ArrayList;
import java.util.List;

public class L68_95_Unique_BST_II extends TreeUtils {
    public static void main(String[] args) {
        int n = 3;

        L68_95_Unique_BST_II obj = new L68_95_Unique_BST_II();
        List<TreeNode> result = obj.generateTrees(n);

        System.out.println("🌳 Total Unique BSTs from 1 to " + n + ": " + result.size());
        int count = 1;
        for (TreeNode root : result) {
            System.out.println("\n🧾 Tree " + count++ + ":");
            printTree(root, 0);
        }
    }
    //======================================================
        public List<TreeNode> generateTrees(int n) 
    {
        return recursion(1,n);
    }
    //-----------------------------------------
    List<TreeNode> recursion(int start ,int end)
    {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> left,right;

        if(start > end)
        {
            list.add(null);
            return list;
        }

        if(start == end)
        {
            list.add(new TreeNode(start));
            return list;
        }
        
        //------
        for(int i = start;i<=end;i++)
        {
            left = recursion(start,i-1);
            right = recursion(i+1,end);
            for(TreeNode lft : left)
            {
                for(TreeNode rgt : right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lft;
                    root.right = rgt;
                    list.add(root);
                }
            }
        }
        return list;
    }
    
}
// ? Tree 1:
//         3
//     2
// 1

// ? Tree 2:
//     3
//         2
// 1

// ? Tree 3:
//     3
// 2
//     1

// ? Tree 4:
// 3
//         2
//     1

// ? Tree 5:
// 3
//     2
//         1