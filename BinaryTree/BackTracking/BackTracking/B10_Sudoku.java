package BackTracking;
import java.util.*;

public class B10_Sudoku 
{

    public void solveSudoku(char[][] board) 
    {
        solve(board);
    }

    public boolean solve(char[][] board) 
    {
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[0].length; j++) 
            {
                if (board[i][j] == '.') 
                {
                    for (char c = '1'; c <= '9'; c++) 
                    {
                        if (isValid(board, i, j, c)) 
                        {
                            board[i][j] = c;
                            if (solve(board)) 
                            {
                                return true;
                            } 
                            else 
                            {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char c) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (board[i][col] == c) return false; // column check
            if (board[row][i] == c) return false; // row check
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; // 3x3 grid check
        }
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter Sudoku board (use '.' for empty cells):");
        System.out.println("Enter 9 lines with 9 characters each (no spaces). Example: 53..7....");

        for (int i = 0; i < 9; i++) 
        {
            String row = sc.nextLine().trim();
            for (int j = 0; j < 9; j++) 
            {
                board[i][j] = row.charAt(j);
            }
        }

        B10_Sudoku solver = new B10_Sudoku();
        solver.solveSudoku(board);

        System.out.println("\nSolved Sudoku:");
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
// Enter Sudoku board (use '.' for empty cells):
// Enter 9 lines with 9 characters each (no spaces). Example: 53..7....
// 53..7....
// 6..195...
// .98....6.
// 8...6...3
// 4..8.3..1
// 7...2...6
// .6....28.
// ...419..5
// ....8..79

// Solved Sudoku:
// 5 3 4 6 7 8 9 1 2
// 6 7 2 1 9 5 3 4 8
// 1 9 8 3 4 2 5 6 7
// 8 5 9 7 6 1 4 2 3
// 4 2 6 8 5 3 7 9 1
// 7 1 3 9 2 4 8 5 6
// 9 6 1 5 3 7 2 8 4
// 2 8 7 4 1 9 6 3 5
// 3 4 5 2 8 6 1 7 9