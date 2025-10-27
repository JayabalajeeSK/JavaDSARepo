package BackTracking;

import java.util.*;

public class B6_Knight_Tour 
{
    public boolean isValid(int[][] grid, int i, int j, int expectedValue, int n) // Leetcode  2596
    {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != expectedValue) 
        {
            return false;
        }

        if (expectedValue == n * n - 1) 
        {
            return true;
        }

        // All 8 possible knight moves
        boolean m1 = isValid(grid, i - 2, j + 1, expectedValue + 1, n); 

        boolean m2 = isValid(grid, i - 1, j + 2, expectedValue + 1, n);

        boolean m3 = isValid(grid, i + 1, j + 2, expectedValue + 1, n);

        boolean m4 = isValid(grid, i + 2, j + 1, expectedValue + 1, n);

        boolean m5 = isValid(grid, i + 2, j - 1, expectedValue + 1, n);

        boolean m6 = isValid(grid, i + 1, j - 2, expectedValue + 1, n);

        boolean m7 = isValid(grid, i - 1, j - 2, expectedValue + 1, n);

        boolean m8 = isValid(grid, i - 2, j - 1, expectedValue + 1, n);

        return m1 || m2 || m3 || m4 || m5 || m6 || m7 || m8;
    }

    public boolean checkValidGrid(int[][] grid) 
    {
        return isValid(grid, 0, 0, 0, grid.length);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: grid = ");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];


        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        B6_Knight_Tour obj = new B6_Knight_Tour();
        boolean result = obj.checkValidGrid(grid);

        System.out.println("Output: " + result);
    }
}
// Input: grid = 
// 5
// 0 11 16 5 20
// 17 4 19 10 15
// 12 1 8 21 6
// 3 18 23 14 9
// 24 13 2 7 22
// Output: true

// Input: grid = 
// 1
// 0
// Output: true

// L2596