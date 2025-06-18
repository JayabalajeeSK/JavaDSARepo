package main2;

import java.util.Stack;

public class L52_173_BSTIterator extends TreeUtils 
{
        public L52_173_BSTIterator(TreeNode root) 
        {
        pushAll(root);
    }
     public static void main(String[] args) {
        Integer[] arr = {7, 3, 15, null, null, 9, 20};  // BST
        TreeNode root = buildBST(arr);

        System.out.println("🧾 BST Tree:");
        printTree(root, 0);

        System.out.println("\n🚀 BST Iterator Output:");
        L52_173_BSTIterator iterator = new L52_173_BSTIterator(root);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n📦 Tree as Array: " + treeToString(root));
    }
    //---------------------------------------
     private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public  void BSTIterator(TreeNode root)  ///same class name BSTIterator(TreeNode root)  - change to [constructor]
    {
        pushAll(root);
    }

    ///** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return !stack.isEmpty();
    }

   // /** @return the next smallest number */
    public int next() 
    {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    private void pushAll(TreeNode node) 
    {
        for (; node != null; stack.push(node), node = node.left);
    }
    
}
// ? BST Tree:
//         20
//     15
//         9
// 7
//     3

// ? BST Iterator Output:
// 3 7 9 15 20
// ? Tree as Array: [7, 3, 15, null, null, 9, 20]