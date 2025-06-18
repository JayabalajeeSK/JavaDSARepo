// Java Program to find kth smallest element in BST

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {this.val = val;}

    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//--------------------------------------------
class Kth_Largest_Smallest_Element {

    int ans = 0;
    int count = 0;

    // Inorder traversal to find kth smallest element
    public int kthSmallest(TreeNode root, int k) 
    {
        if (root == null) return -1;

        kthSmallest(root.left, k);

        count++;
        if (count == k) 
        {
            ans = root.val;
            return ans;
        }

        kthSmallest(root.right, k);

        return ans;
    }
    //--
    public int kthLargest(TreeNode root, int k) 
    {
        if (root == null) return -1;

        kthLargest(root.right, k);

        count++;
        if (count == k) 
        {
            ans = root.val;
            return ans;
        }

        kthLargest(root.left, k);

        return ans;
    }

    public static void main(String[] args) 
    {
        /*
                    20
                  /    \
                8       22
              /   \
             4     12
                  /  \
                10    14
        */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        int k = 3;

        Kth_Largest_Smallest_Element large = new Kth_Largest_Smallest_Element();
        int resultLar = large.kthSmallest(root, k);

        Kth_Largest_Smallest_Element small = new Kth_Largest_Smallest_Element();
        int resultSmall = small.kthLargest(root, k);

        System.out.println(k + "rd largest element is: " + resultLar);

        System.out.println(k + "rd smallest element is: " + resultSmall);
    }
}
// 3rd largest element is: 10
// 3rd smallest element is: 14