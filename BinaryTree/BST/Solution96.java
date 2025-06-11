package BinaryTree.BST;

public class Solution96 
{
    public int numTrees(int n) 
    {
        int arr[] = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3;i<20;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                arr[i] = arr[i] + arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
    }
    
}
