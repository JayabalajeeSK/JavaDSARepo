package main4;

public class L65_96_Unique_BST 
{
    public static void main(String[] args) {
        L65_96_Unique_BST obj = new L65_96_Unique_BST();
        int n = 5;
        System.out.println("🌳 Number of Unique BSTs for n = " + n + ": " + obj.numTrees(n));
    }
    //-------------------------------------------
    
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
                arr[i] = arr[i] + arr[j] * arr[i-j-1];
            }
        }
        return arr[n];
    }
    
}
// ? Number of Unique BSTs for n = 5: 42