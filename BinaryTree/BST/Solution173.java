package BinaryTree.BST;

import java.util.Stack;

public class Solution173 
{
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public Solution173(TreeNode root)  //same class name BSTIterator(TreeNode root)  - change to [constructor]
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
