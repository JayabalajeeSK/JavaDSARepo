package main2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class L50_1104_PathInZigZagTree extends TreeUtils {
    public static void main(String[] args) {
        int label = 14;

        L50_1104_PathInZigZagTree obj = new L50_1104_PathInZigZagTree();
        List<Integer> result = obj.pathInZigZagTree(label);

        System.out.println("🏷️ Input Label: " + label);
        System.out.println("📥 Path in ZigZag Tree: " + result);
    }
    //----------------------------------------------

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
// ?? Input Label: 14
// ? Path in ZigZag Tree: [1, 3, 4, 14]