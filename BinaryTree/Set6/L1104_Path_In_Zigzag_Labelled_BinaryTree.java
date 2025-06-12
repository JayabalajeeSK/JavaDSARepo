package BinaryTree.Set6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1104_Path_In_Zigzag_Labelled_BinaryTree 
{
    public List<Integer> pathInZigZagTree(int label) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        while(true)
        {
            ans.add(label);

            int level = (int)(Math.log(label)/Math.log(2));

            int opp = ((int)Math.pow(2,level+1) -1) - (label - (int)Math.pow(2,level));

            label = opp/2;

            if (label == 0) break;
        }
        Collections.reverse(ans);
        return ans;
    }
    
}
