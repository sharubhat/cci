package hackerrank.backtracking;

import java.util.*;

/**
 * Solve the N-queen problem using recursion. (There may be other ways of solving this problem,
 * but for the purpose of this exercise, please use recursion only).
 *
 * Problem statement:
 * Place N queens on an NxN chessboard, such that no two queens are in line of attack of each other.
 * In chess (and in real life too), a queen can move as far as she pleases, horizontally, vertically, or diagonally.
 * Input: N
 * Output: All possible arrangements of N queens on the board. Each arrangement can be represented by a matrix.
 * Print the entire matrix, one per valid arrangement
 *
 * Example : For board of size 4,
 *
 * Board size 4 x 4 there are 2 possible solutions
 *   =======================
 *   . X . .
 *   . . . X
 *   X . . .
 *   . . X .
 *   =======================
 *   . . X .
 *   X . . .
 *   . . . X
 *   . X . .
 *   =======================
 *
 *   Complexity analysis:
 *
 *   A naive approach is
 *
 *   while there are untried configurations
 *   {
 *      generate the next configuration of the n Queens;
 *      if no two Queens can ‘take’ each other
 *      {
 *          print this configuration;
 *      }
 *  }
 *
 *  This approach generates n^n configurations resulting in O(n^n) complexity.
 *
 *  Taking into consideration that no two queens can be placed in same column, a high level revised algo will be
 *  while there are untried configurations
 *  {
 *      generate the next configuration of the n Queens. . .
 *      allowing no duplicates values in the configuration;
 *      if no two Queens can ‘take’ each other
 *      {
 *          print this configuration;
 *      }
 *  }
 *
 * Recursion tree frames
 *
 *                                                      (root)
 *                                /              /                  \                       \
 *                     1                    2                           3                         4
 *                 /   |   \            /   |   \                    /  |  \                   /  |  \
 *              2      3     4       1     3     4               1    2    4              1    2    3
 *             / \    / \    / \    / \    / \   / \
 *            3   4  2  4  2  3   3  4  1  4 1  3
 *            |   |  |   |  |   |   |  |  |   | |   |
 *            4   3 4   2  3  2   4  3  4  1 3   1        ....and so on
 *
 * This takes up n * [n * (n-1) * (n-2).....(n-(n-1))] frames which amounts to n*n! configurations and so O(n*n!) time complexity.
 *
 * Another improvement is, instead of calculating each configuration, we can abandon the paths as soon as
 * we find out that the path wont result in a solution.
 *
 * Recursion tree frames
 *
 *                                                      (root)
 *                                /              /                  \                       \
 *                     1                    2                           3                         4
 *                 /   |   \            /   |   \                    /  |  \                   /  |  \
 *              2      3     4       1     3     4               1    2    4              1    2    3
 *                    / \    / \                 / \              / \
 *                   2  4   2  3               1  3            2   4
 *                           |                   |                    |
 *                           3                   3                   2
 *                                               |                    |
 *                                              YES                 YES      ....and so on
 *
 * It's hard to calculate the exact time complexity of this algorithm at this point, however it can be further improved
 * by avoiding the duplicate effort that results from symmetries in the problem.
 *
 * Created by sharath on 8/17/15.
 */
public class NQueens {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        for(int boardSize = 1; boardSize <= 10; boardSize++) {
            System.out.printf("Board size %d x %d%n", boardSize, boardSize);
            List<int[]> results = placeQueens(boardSize);
            if(results.size() == 0) {
                System.out.println("=======================");
                System.out.println("Can't place queens");
            } else {
                System.out.println(results.size() + " possible solutions");
            }
            for(int[] res : results) {
                char[][] board = new char[boardSize][boardSize];
                for(int k = 0;k < boardSize; k++) {
                    board[k][res[k]] = 'X';
                }
                System.out.println("=======================");
                for(int k = 0; k < board.length; k++) {
                    for(int j = 0; j < board[0].length; j++) {
                        if(board[k][j] != 'X')
                            System.out.print(". ");
                        else
                            System.out.print(board[k][j] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    public static List<int[]> placeQueens(int n) {
        List<int[]> res = new ArrayList<>();
        // since the exact positions of n queens on the chessboard can be fully specified by the column numbers
        // (an n-tuple) of the n queens, they can be represented by a linear array of size n.
        // res holds all such n-tuple of placements.
        placeQueensR(0, new int[n], res);
        return res;
    }

    private static void placeQueensR(int row, int[] columns, List<int[]> res) {
        // columns array holds configuration corresponding to current path.
        // if we have reached the last row, it means we have found a solution.
        if(row == columns.length) {
            res.add(columns.clone());
        } else {
            for(int col = 0; col < columns.length; col++) {
                if(canPlaceQueen(columns, row, col)) {
                    columns[row] = col;
                    placeQueensR(row + 1, columns, res);
                }
            }
        }
    }

    private static boolean canPlaceQueen(int[] columns, int row1, int col1) {
        for(int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];

            // check if row2, col2 invalidates row1, col1 as queen spot
            // check if rows have a queen in the same column
            if(col1 == col2) {
                return false;
            }

            // check diagonals: if distance between the columns equals the dist between rows, then they are in diagonal
            int colDist = Math.abs(col2 - col1);
            // row 1 > row2, so no need to calculate abs
            int rowDist = row1 - row2;

            if(colDist == rowDist)
                return false;
        }
        return true;
    }
}
