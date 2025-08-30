package Node23_Tree;

import java.util.*;

class Node23 
{
    int[] keys = new int[2];          // a 2-3 node holds up to 2 keys
    Node23[] children = new Node23[3]; // up to 3 children
    int keyCount = 0;
    boolean isLeaf = true;

    @Override
    public String toString() 
    {
        if (keyCount == 1) return "[" + keys[0] + "]";
        else return "[" + keys[0] + "|" + keys[1] + "]";
    }
}

public class TwoThreeSimple 
{
    static Node23 root = null; //

        // Helper class for split result
    private static class SplitResult //
    {
        int middle;
        Node23 left, right;
        SplitResult(int mid, Node23 l, Node23 r) 
        {
            middle = mid; left = l; right = r;
        }
    }

    ////////////////////////////////////

    // Insert wrapper
    public static Node23 insert23(Node23 node, int key) //
    {
        if (node == null) 
        {
            node = new Node23();
            node.keys[0] = key;
            node.keyCount = 1;
            return node;
        }

        SplitResult res = insertInternal(node, key);
        
        if (res != null) 
        { 
            Node23 newRoot = new Node23();
            newRoot.isLeaf = false;
            newRoot.keys[0] = res.middle;
            newRoot.keyCount = 1;
            newRoot.children[0] = res.left;
            newRoot.children[1] = res.right;
            return newRoot;
        }
        return node;
    }

    /////////////////////////////////////////////

    // Insert internal
    private static SplitResult insertInternal(Node23 node, int key) 
    {
        if (node.isLeaf) 
        {
            if (node.keyCount < 2) 
            {
                insertIntoNode(node, key);
                return null;
            } 
            else 
            {
                return splitLeaf(node, key);
            }
        } 
        else 
        {
            int i;
            if (key < node.keys[0]) i = 0;
            else if (node.keyCount == 1 || key < node.keys[1]) i = 1;
            else i = 2;

            SplitResult res = insertInternal(node.children[i], key);
            if (res != null) return handleSplit(node, res, i);
            return null;
        }
    }

    /////////////////////////////////////////////////
    
       // Insert into non-full leaf
    private static void insertIntoNode(Node23 node, int key) //
    {
        if (node.keyCount == 1) 
        {
            if (key < node.keys[0]) 
            {
                node.keys[1] = node.keys[0];
                node.keys[0] = key;
            } 
            else 
            {
                node.keys[1] = key;
            }
            node.keyCount = 2;
        }
    }

    /////////////////////////
    
    // Split full leaf
    private static SplitResult splitLeaf(Node23 node, int key) //
    {
        int[] temp = {node.keys[0], node.keys[1], key};
        Arrays.sort(temp);

        Node23 left = new Node23();
        left.keys[0] = temp[0];
        left.keyCount = 1;

        Node23 right = new Node23();
        right.keys[0] = temp[2];
        right.keyCount = 1;

        return new SplitResult(temp[1], left, right);
    }

    ////////////////////////////////////////////

    // Handle split in internal node
    private static SplitResult handleSplit(Node23 node, SplitResult res, int childIndex) 
    {
        int[] tempKeys = new int[node.keyCount + 1];
        Node23[] tempChildren = new Node23[node.keyCount + 2];

        for (int i = 0; i < node.keyCount; i++) tempKeys[i] = node.keys[i];
        for (int i = 0; i <= node.keyCount; i++) tempChildren[i] = node.children[i];

        for (int i = node.keyCount; i > childIndex; i--) tempChildren[i + 1] = tempChildren[i];
        tempChildren[childIndex] = res.left;
        tempChildren[childIndex + 1] = res.right;

        for (int i = node.keyCount; i > childIndex; i--) tempKeys[i] = tempKeys[i - 1];
        tempKeys[childIndex] = res.middle;

        if (node.keyCount == 1) 
        {
            node.keys[0] = tempKeys[0];
            node.keys[1] = tempKeys[1];
            node.children[0] = tempChildren[0];
            node.children[1] = tempChildren[1];
            node.children[2] = tempChildren[2];
            node.keyCount = 2;
            node.isLeaf = false;
            return null;
        } 
        else 
        {
            Node23 left = new Node23();
            Node23 right = new Node23();
            left.isLeaf = right.isLeaf = false;

            left.keys[0] = tempKeys[0];
            left.keyCount = 1;
            left.children[0] = tempChildren[0];
            left.children[1] = tempChildren[1];

            right.keys[0] = tempKeys[2];
            right.keyCount = 1;
            right.children[0] = tempChildren[2];
            right.children[1] = tempChildren[3];

            return new SplitResult(tempKeys[1], left, right);
        }
    }

    //////////////////////////////////////
    
    // Inorder traversal
    public static void inorder(Node23 node) 
    {
        if (node == null) return;
        if (node.isLeaf) 
        {
            for (int i = 0; i < node.keyCount; i++) System.out.print(node.keys[i] + " ");
        } 
        else 
        {
            for (int i = 0; i < node.keyCount; i++) 
            {
                inorder(node.children[i]);
                System.out.print(node.keys[i] + " ");
            }
            inorder(node.children[node.keyCount]);
        }
    }



    // --- MAIN ---
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array input (like [\"10\",\"20\",\"30\",\"40\"]):");
        String raw = sc.nextLine();

        String clean = raw.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(",", " ")
                .trim()
                .replaceAll("\\s+", " ");

        String[] parts = clean.split(" ");

        Integer[] arr = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) 
        {
            if (parts[i].equalsIgnoreCase("null")) arr[i] = null;
            else arr[i] = Integer.parseInt(parts[i]);
        }

        for (Integer x : arr) 
        {
            if (x != null) root = insert23(root, x);
        }

        System.out.print("Inorder traversal: ");
        inorder(root);
        sc.close();
    }
}

// Enter array input (like ["10","20","30","40"]):
// 10 20 40 30 80 60
// Inorder traversal: 10 20 30 40 60 80 