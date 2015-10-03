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
        placeQueensR(0, new int[n], res);
        return res;
    }

    private static void placeQueensR(int row, int[] columns, List<int[]> res) {
        if(row == columns.length) {
            res.add(columns.clone());
        } else {
            for(int col = 0; col < columns.length; col++) {
                if(checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueensR(row + 1, columns, res);
                }
            }
        }
    }

    private static boolean checkValid(int[] columns, int row1, int col1) {
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
