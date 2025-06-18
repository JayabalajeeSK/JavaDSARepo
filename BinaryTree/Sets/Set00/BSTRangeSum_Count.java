class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//---------------------------------------------------    
public class BSTRangeSum_Count 
{

    int sum = 0;
    int count = 0;

    public void printAndSum(TreeNode root, int low, int high) 
    {
        if (root == null) return;

        if (root.val > low) printAndSum(root.left, low, high);

        if (root.val >= low && root.val <= high) 
        {
            System.out.print(root.val + " ");
            sum = sum + root.val;
            count++;
        }

        if (root.val < high) printAndSum(root.right, low, high);
    }

    public static void main(String[] args) {
        /*
                  22
                 /  \
               12    30
              /  \
             8    20
        */
        TreeNode root = new TreeNode(22);
        root.left = new TreeNode(12);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(20);

        int low = 10, high = 22;

        BSTRangeSum_Count rangeSum = new BSTRangeSum_Count();
        System.out.print("Nodes in range: ");

        rangeSum.printAndSum(root, low, high);
        System.out.println("\nSum of nodes in range: " + rangeSum.sum);
        System.out.println("Count of nodes in range: " + rangeSum.count);
    }
}
// Nodes in range: 12 20 22 
// Sum of nodes in range: 54
// Nodes in range: 12 20 22 
// Sum of nodes in range: 54
// Count of nodes in range: 3