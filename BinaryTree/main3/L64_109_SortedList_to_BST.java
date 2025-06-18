// package main3;

// import BST.L109_SortedListToBST.ListNode;

// public class L64_109_SortedList_to_BST extends TreeUtils {

//     public static void main(String[] args) {
//         // Convert sorted array to linked list: [-10, -3, 0, 5, 9]
//         int[] nums = {-10, -3, 0, 5, 9};
//         ListNode head = buildSortedLinkedList(nums);

//         L64_109_SortedList_to_BST obj = new L64_109_SortedList_to_BST();
//         TreeNode root = obj.sortedListToBST(head);

//         System.out.println("📥 Sorted Linked List converted to BST:");
//         obj.printTree(root, 0); // Make sure TreeUtils has this method
//     }

//     public TreeNode sortedListToBST(ListNode head) {
//         if (head == null) return null;
//         if (head.next == null) return new TreeNode(head.val);

//         ListNode slow = head, fast = head, prev = null;

//         // Find middle of the list
//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         TreeNode root = new TreeNode(slow.val); // Root from middle node

//         if (prev != null) prev.next = null; // Break left part
//         if (head != slow) root.left = sortedListToBST(head); // Left tree
//         root.right = sortedListToBST(slow.next); // Right tree

//         return root;
//     }

//     // // 🔧 Utility to convert array to sorted linked list
//     // public static ListNode buildSortedLinkedList(int[] arr) {
//         if (arr == null || arr.length == 0) return null;

//         // // ListNode head = new ListNode(arr[0]);
//         // ListNode curr = head;

//         // for (int i = 1; i < arr.length; i++) {
//         //     curr.next = new ListNode(arr[i]);
//         //     curr = curr.next;
//         // }

//         // return head;
//     }

// // public class ListNode {
// //     public int val;
// //     public ListNode next;

// //     public ListNode(int val) {
// //         this.val = val;
// //     }
// // }

// // }
 package main3;

public class L64_109_SortedList_to_BST {
public static void main(String[] args) {
        int i = 0;
    int j =0;

}

}
