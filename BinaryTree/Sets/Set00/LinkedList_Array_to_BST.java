package Sets.Set00;

// TreeNode as before
class TreeNode 
{
    int val;
    TreeNode left, right;

    TreeNode(int data) 
    {
        this.val = data;
        this.left = null;
        this.right = null;
    }
}
// Linked List Node
class ListNode 
{
    int val;
    ListNode next;
    ListNode(int data) 
    {
        this.val = data;
    }
}

public class LinkedList_Array_to_BST 
{

    // =================== ARRAY TO BST =====================
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    private TreeNode constructTreeFromArray(int[] nums, int left, int right) 
    {
        if (left > right) return null;
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTreeFromArray(nums, left, mid - 1);
        root.right = constructTreeFromArray(nums, mid + 1, right);
        return root;
    }

    // =================== LINKED LIST TO BST =====================
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head==null) return null;

        if(head.next==null) return new TreeNode(head.val);

        ListNode slow=head,fast=head,slow_Prev=null;

        while(fast!=null && fast.next!=null) //slow = fast and fast = slow
        {
            slow_Prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);//Making A Root Node

        slow_Prev.next = null;//Braeking The Link For L1

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }

    // =================== PREORDER UTILITY =====================
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // =================== MAIN =====================
    public static void main(String[] args) {
        LinkedList_Array_to_BST obj = new LinkedList_Array_to_BST();

        // ----------- ARRAY Example ------------
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstFromArray = obj.sortedArrayToBST(sortedArray);
        System.out.println("Preorder from Sorted Array:");
        obj.preorder(bstFromArray);

        // ----------- LINKED LIST Example ------------
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        TreeNode bstFromList = obj.sortedListToBST(head);
        System.out.println("\nPreorder from Sorted Linked List:");
        obj.preorder(bstFromList);
    }
}
// Preorder from Sorted Array:
// 4 2 1 3 6 5 7 
// Preorder from Sorted Linked List:
// 4 2 1 3 6 5 7 