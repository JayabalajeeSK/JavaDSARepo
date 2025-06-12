package BinaryTree.Set1;

public class L671_Second_Minimum_Node_In_a_BinaryTree 
{
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
