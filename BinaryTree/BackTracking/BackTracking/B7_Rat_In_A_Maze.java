package BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class B7_Rat_In_A_Maze 
{
    static ArrayList<String> res;
    static int[][] visited;

    public static void findPaths(int[][] m, int row, int col, String s, int n) 
    {
        if (row == n - 1 && col == n - 1) 
        {
            res.add(s);
            return;
        } 
        else 
        {
            visited[row][col] = 1;
        }

        if (row + 1 < n && visited[row + 1][col] == 0 && m[row + 1][col] == 1) 
        {
            findPaths(m, row + 1, col, s + "D", n); // DOWN
        }

        if (col - 1 >= 0 && visited[row][col - 1] == 0 && m[row][col - 1] == 1) 
        {
            findPaths(m, row, col - 1, s + "L", n); // LEFT
        }

        if (col + 1 < n && visited[row][col + 1] == 0 && m[row][col + 1] == 1) 
        {
            findPaths(m, row, col + 1, s + "R", n); // RIGHT
        }

        if (row - 1 >= 0 && visited[row - 1][col] == 0 && m[row - 1][col] == 1) 
        {
            findPaths(m, row - 1, col, s + "U", n); // UP
        }
        visited[row][col] = 0;
    }

    public static ArrayList<String> findPath(int[][] m, int n) 
    {
        visited = new int[n][n];
        res = new ArrayList<>();
        if (m[0][0] == 0) 
        {
            return res;
        }
        String s = "";
        findPaths(m, 0, 0, s, n);
        return res;
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the maze (n): ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];
        System.out.println("Enter the maze grid (0 = blocked, 1 = open):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        sc.close();

        ArrayList<String> paths = findPath(maze, n);

        System.out.println("Paths from start to destination:");
        System.out.println(paths);
    }
}
// Enter the size of the maze (n): 4
// Enter the maze grid (0 = blocked, 1 = open):
// 1 0 0 0
// 1 1 0 1
// 1 1 0 0
// 0 1 1 1
// Paths from start to destination:
// [DDRDRR, DRDDRR]

// Enter the size of the maze (n): 2
// Enter the maze grid (0 = blocked, 1 = open):
// 1 1
// 1 1
// Paths from start to destination:
// [DR, RD]

// Enter the size of the maze (n): 2
// Enter the maze grid (0 = blocked, 1 = open):
// 1 1
// 1 1
// Paths from start to destination:
// [D, LDR]