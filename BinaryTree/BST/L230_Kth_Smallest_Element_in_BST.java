package BinaryTree.BST;

public class L230_Kth_Smallest_Element_in_BST 
{
    int ans=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root==null) return 0;
        
        kthSmallest(root.left , k);

        count++;
        if(count==k) 
        {
            ans=root.val;
            return ans;
        }

        kthSmallest(root.right , k);

        return ans;
    }
    
}
