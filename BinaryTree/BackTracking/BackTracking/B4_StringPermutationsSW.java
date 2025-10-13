package BackTracking;

import java.util.*;


public class B4_StringPermutationsSW 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;

        int arr1[] = new int[26]; // frequency for s1
        int arr2[] = new int[26]; // frequency for sliding window in s2

        // Initialize frequency counts for the first window
        for (int i = 0; i < l1; i++) 
        {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        // Sliding window across s2
        for (int i = l1; i < l2; i++) 
        {
            if (Arrays.equals(arr1, arr2)) 
            {
                return true;
            }
            arr2[s2.charAt(i) - 'a']++;        // Add next character to window
            arr2[s2.charAt(i - l1) - 'a']--;   // Remove leftmost character
        }

        // Final check for last window
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string (s1): ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string (s2): ");
        String s2 = sc.nextLine();

        B4_StringPermutationsSW obj = new B4_StringPermutationsSW();
        boolean result = obj.checkInclusion(s1, s2);

        if (result) System.out.println("True");
        else System.out.println("False");

        sc.close();

    }
}
// Enter first string (s1): xy
// Enter second string (s2): yx
// True

// Enter first string (s1): cb
// Enter second string (s2): abc
// True

//567