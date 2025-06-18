package main5;

public class L671 extends TreeUtils
{
    public static void main(String[] args) 
    {
        Integer[] arr = {2, 2, 5, null, null, 5, 7}; // ➤ Expected output: 5

        TreeNode root = buildBT(arr);

        System.out.println("Binary Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));

        L671 obj = new L671();
        int result = obj.findSecondMinimumValue(root);

        System.out.println("\nSecond Minimum Value: " + result);
    }
    //---------------------------------------
    int min = Integer.MAX_VALUE;
    int sec_min = Integer.MAX_VALUE;
    boolean check = false;
    public int findSecondMinimumValue(TreeNode root) 
    {
        if(root == null) return -1;    

        //we'll first assign the minimum value int the global variable min and then this will not be changed once assigned since 
        // we are given in the ques that root is the smallest value 
        
        if(root.val<min)  min = root.val;
        
        //if there is a value which is greater than or min but less than sec minimum value we'll assign it here to the variable 
        //and will make the check true which means we have found the sec minimum value for current level and then will traverse till end 
        
        if(root.val>min && root.val<=sec_min)
        {
            check = true; 
            sec_min = root.val;
        }
        
        
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        
        return check == false ? -1 : sec_min; // it means second minimum value doesn't exist in the given tree and we return -1 as ans.
    }
    
}
// Binary Tree Structure:
//         7
//     5
//         5
// 2
//     2

// Tree (Level Order): [2, 2, 5, null, null, 5, 7]

// Second Minimum Value: 5