package main1;

import java.util.ArrayList;
import java.util.List;

public class L36_894_All_Possible_Full_Binary_Trees extends TreeUtils
{
    public static void main(String[] args) 
    {
        int n = 7;

        L36_894_All_Possible_Full_Binary_Trees l26 = new L36_894_All_Possible_Full_Binary_Trees();
        List<TreeNode> result = l26.allPossibleFBT(n);

        System.out.println("\nAll Possible Full Binary Trees with " + n + " nodes:");
        int count = 1;
        for (TreeNode root : result) 
        {
            System.out.println("\nTree " + count++ + ":");
            printTree(root, 0);
        }

        System.out.println("\nTotal Trees Formed: " + result.size());
    }
    //--------------------------------------------------

    public List<TreeNode> allPossibleFBT(int n) 
    {
        List<TreeNode> result = new ArrayList<>();

        if (n == 1) 
        {
            result.add(new TreeNode(0));
            return result;
        }

        if (n % 2 == 0) return result; 
    

        for (int i = 1; i < n; i= i + 2) 
        {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);

            for (TreeNode left : leftSubtrees) 
            {
                for (TreeNode right : rightSubtrees) 
                {
                    TreeNode root = new TreeNode(0, left, right);
                    result.add(root);
                }
            }
        }

        return result;
    }
}
// All Possible Full Binary Trees with 7 nodes:

// Tree 1:
//             0
//         0
//             0
//     0
//         0
// 0
//     0

// Tree 2:
//         0
//     0
//             0
//         0
//             0
// 0
//     0

// Tree 3:
//         0
//     0
//         0
// 0
//         0
//     0
//         0

// Tree 4:
//     0
// 0
//             0
//         0
//             0
//     0
//         0

// Tree 5:
//     0
// 0
//         0
//     0
//             0
//         0
//             0

// Total Trees Formed: 5