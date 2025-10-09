package Pro1;

import java.util.*;

class NaryNode 
{
    int val;
    List<NaryNode> children;

    NaryNode(int val) 
    {
        this.val = val;      
        this.children = new ArrayList<>();
    }
}
public class NaryTreeTraversal 
{
    static Scanner sc = new Scanner(System.in);


    public static NaryNode buildNaryTree(Integer[] arr, int maxChildren)
    {
        if (arr.length == 0 || arr[0] == null) return null;

        NaryNode root = new NaryNode(arr[0]);
        Queue<NaryNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; 
        while (!queue.isEmpty() && i < arr.length) 
        {
            NaryNode current = queue.poll();
            for (int c = 0; c < maxChildren && i < arr.length; c++, i++) // for 
            {
                if (arr[i] != null) 
                {
                    NaryNode child = new NaryNode(arr[i]);
                    current.children.add(child);
                    queue.add(child);
                }
            }
        }
        return root;
    }

    // PreOrder Traversal
    public static void preorder(NaryNode root) 
    {
        if (root == null) return;
        System.out.print(root.val + " ");
        for (NaryNode child : root.children) 
        {
            preorder(child);
        }
    }

    // PostOrder Traversal
    public static void postorder(NaryNode root) 
    {
        if (root == null) return;
        for (NaryNode child : root.children) 
        {
            postorder(child);
        }
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) 
    {
        System.out.print("Enter max children per node: ");
        int maxChildren = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter array input (like 10 5 15 3 7 18 -1):");
        String raw = sc.nextLine().trim();

        String clean = raw.replace("[", "")
                          .replace("]", "")
                          .replace("\"", "")
                          .replace(",", " ")
                          .trim()
                          .replaceAll("\\s+", " "); // multiple spaces → single space

        String[] parts = clean.split(" ");
        Integer[] arr = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) 
        {
            if (parts[i].equalsIgnoreCase("null") || parts[i].equals("-1")) 
            {
                arr[i] = null;
            } 
            else 
            {
                arr[i] = Integer.parseInt(parts[i]);
            }
        }

        NaryNode root = buildNaryTree(arr, maxChildren);

        System.out.print("N-ary Tree PreOrder Traversal: ");
        preorder(root);

        System.out.println();

        System.out.print("N-ary Tree PostOrder Traversal: ");
        postorder(root);
    }
}
// Enter max children per node: 3
// Enter array input (like 10 5 15 3 7 18 -1):
// 10 5 15 3 7 -1 18
// N-ary Tree PreOrder Traversal: 10 5 7 18 15 3
// N-ary Tree PostOrder Traversal: 7 18 5 15 3 10