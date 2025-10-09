package BackTracking;

import java.util.*;

public class PrimeSumFinderOptimized 
{

    public static boolean isPrime(int num) 
    {
        if (num < 2) return false;
        int limit = (int) Math.sqrt(num); 
        for (int i = 2; i <= limit; i++) 
        {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> generatePrimes(int P, int S) 
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = P + 1; i <= S; i++) 
        {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }


    public static void findPrimeCombinations(List<Integer> primes, int N, int S, int start, List<Integer> current) 
    {
        if (current.size() == N) 
        {
            if (S == 0) System.out.println(current);
            return;
        }

        for (int i = start; i < primes.size(); i++) 
        {
            int prime = primes.get(i);

            if (prime > S) break;

            current.add(prime);

            findPrimeCombinations(primes, N, S - prime, i + 1, current);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (number of primes): ");
        int N = sc.nextInt();

        System.out.print("Enter P (prime to start after): ");
        int P = sc.nextInt();

        System.out.print("Enter S (sum of primes): ");
        int S = sc.nextInt();

        sc.close();

        List<Integer> primes = generatePrimes(P, S);

        Collections.sort(primes); 

        System.out.println("\nPrime combinations:");

        findPrimeCombinations(primes, N, S, 0, new ArrayList<>());
    }
}
// Enter N (number of primes): 3
// Enter P (prime to start after): 2 
// Enter S (sum of primes): 15

// Prime combinations:
// [3, 5, 7]

// Enter N (number of primes): 2
// Enter P (prime to start after): 7
// Enter S (sum of primes): 28

// Prime combinations:
// [11, 17]

// Enter N (number of primes): 4
// Enter P (prime to start after): 3
// Enter S (sum of primes): 54

// Prime combinations:
// [5, 7, 11, 31]
// [5, 7, 13, 29]
// [5, 7, 19, 23]
// [5, 13, 17, 19]
// [7, 11, 13, 23]
// [7, 11, 17, 19]

// class Solution {
//     public List<List<Integer>> findPrimePairs(int n) {
//         boolean[] flag=new boolean[n+1];
//         flag[0]=true;
//         flag[1]=true;
//         for(int i=2;i*i<=n;i++)
//         {
//             if(flag[i]==false)
//             {
//                 for(int j=i*i;j<=n;j+=i)
//                 {
//                     flag[j]=true;
//                 }
//             }
//         }
//         List<List<Integer>> ans=new ArrayList<>();
//         for(int i=2;i<=n/2;i++)
//         {
//             if(flag[i]==false && flag[n-i]==false)
//             {
//                 ans.add(Arrays.asList(i,n-i));
//             }
//         }
//         return ans;
        
//     }
// }