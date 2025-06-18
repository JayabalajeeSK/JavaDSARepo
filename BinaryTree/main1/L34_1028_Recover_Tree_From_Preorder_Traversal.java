package main1;

public class L34_1028_Recover_Tree_From_Preorder_Traversal extends TreeUtils
{
    public static void main(String[] args) 
    {
        String traversal = "1-2--3--4-5--6--7"; // Preorder with depth info

        L34_1028_Recover_Tree_From_Preorder_Traversal l34 = new L34_1028_Recover_Tree_From_Preorder_Traversal();
        TreeNode root = l34.recoverFromPreorder(traversal);

        System.out.println("\nRecovered Binary Tree Structure:");
        printTree(root, 0);

        System.out.println("\nTree (Level Order): " + treeToArray(root));
    }
    //-----------------------------------------------
    public TreeNode recoverFromPreorder(String traversal) 
    {
        return f(traversal,1);
    }
    public TreeNode f(String s,int dept)
    {
        if(s=="") return null;

        String dash="(?<!-)-{"+ dept  +"}(?!-)";

        System.out.println(dash);


        String[] str=s.split(dash);

        TreeNode node=new TreeNode(Integer.parseInt(str[0])); 

        if(str.length > 1) node.left = f(str[1],dept+1);

        if(str.length>2) node.right =f(str[2],dept+1);
        
        return node;
    }
    
}
// (?<!-)-{1}(?!-)
// (?<!-)-{2}(?!-)
// (?<!-)-{3}(?!-)
// (?<!-)-{3}(?!-)
// (?<!-)-{2}(?!-)
// (?<!-)-{3}(?!-)
// (?<!-)-{3}(?!-)

// Recovered Binary Tree Structure:
//         7
//     5
//         6
// 1
//         4
//     2
//         3

// Tree (Level Order): [1, 2, 5, 3, 4, 6, 7]