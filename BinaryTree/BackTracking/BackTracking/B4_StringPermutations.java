package BackTracking;

import java.util.*;

public class B4_StringPermutations 
{

    public static void generatePermutations(char[] chars, int index, List<String> result) 
    {
        if (index == chars.length) 
        {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) 
        {
            swap(chars, index, i);
            generatePermutations(chars, index + 1, result);
            swap(chars, index, i); 
        }
    }

    public static void swap(char[] chars, int i, int j) 
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static List<String> getAllPermutations(String s) 
    {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        generatePermutations(chars, 0, result);
        Collections.sort(result); 
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();
        sc.close();

        List<String> permutations = getAllPermutations(s);

        System.out.println("All permutations in lexicographical order:");
        for (String perm : permutations) 
        {
            System.out.println(perm);
        }
    }
}
// Enter the string: XY
// All permutations in lexicographical order:
// XY
// YX

// Enter the string: abc
// All permutations in lexicographical order:
// abc
// acb
// bac
// bca
// cab
// cba

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
        
//         int l1 = s1.length(), l2 = s2.length();
//         if(l1 > l2)
//             return false;
        
//         int arr1[] = new int[26]; // for String s1 frequency count
//         int arr2[] = new int[26]; // for String s2 frequency count
//         for(int i = 0 ; i < l1; i++){
//             arr1[s1.charAt(i) - 'a']++;
//             arr2[s2.charAt(i) - 'a']++;
//         }
//         for(int i = l1; i < l2; i++){
//             if(Arrays.equals(arr1,arr2)){
//                 return true;
//             }
//             arr2[s2.charAt(i) - 'a']++;       //adding one character in window
//             arr2[s2.charAt(i - l1) - 'a']--;  //deleting one character in window
//         }
//         if(Arrays.equals(arr1,arr2)){
//                 return true;
//         }
//         return false;
//     }
// }

//567