package BinaryTree.BST;

import java.util.PriorityQueue;

public class L703_KthLargestElement_in_Stream_BST 
{
      private PriorityQueue<Integer> heap = new PriorityQueue<>();
  private int k;

  public L703_KthLargestElement_in_Stream_BST(int k, int[] nums) //KthLargest(int k, int[] nums) 
  {
    this.k = k;
    for (var n : nums) add(n);
  }
  
  public int add(int val) 
  {
    heap.offer(val);

    if (heap.size() > k) heap.poll();
    
    return heap.peek();
  }
    
}
