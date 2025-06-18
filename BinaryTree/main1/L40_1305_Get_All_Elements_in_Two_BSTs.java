package main1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L40_1305_Get_All_Elements_in_Two_BSTs extends TreeUtils {
    public static void main(String[] args) {
        Integer[] arr1 = {2,1,4};
        Integer[] arr2 = {1,0,3};

        TreeNode root1 = buildBT(arr1);
        TreeNode root2 = buildBT(arr2);

        L40_1305_Get_All_Elements_in_Two_BSTs l40 = new L40_1305_Get_All_Elements_in_Two_BSTs();
        List<Integer> merged = l40.getAllElements(root1, root2);

        System.out.println("\nTree1 (level order): " + treeToArray(root1));
        System.out.println("Tree2 (level order): " + treeToArray(root2));
        System.out.println("Merged Elements: " + merged);
    }
    //-------------------------------------

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        List<Integer> list =new ArrayList<>();

        inOrder(root1,list);
        inOrder(root2,list);

        Collections.sort(list);
        return list;
    }

    public void inOrder(TreeNode root,List<Integer> list)
    {
        if(root==null)return;

        list.add(root.val);
        
        inOrder(root.left,list);
        inOrder(root.right,list);
    }
}
// Tree1 (level order): [2, 1, 4]
// Tree2 (level order): [1, 0, 3]
// Merged Elements: [0, 1, 1, 2, 3, 4]
// Time	O(N)
// Space (list + stack)	O(N)