package BinaryTree.Set2;

public class L1028_Recover_a_Tree_From_Preorder_Traversal 
{
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
