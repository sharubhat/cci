package hackerrank.recursion.homework;

import java.util.*;

/**
 * Created by sharath on 8/17/15.
 */
public class NQueens {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        for(int i = 1; i <= 10; i++) {
            System.out.printf("Board size %d x %d%n", i, i);
            List<char[][]> res = placeQueens(i);
            if(res.size() == 0) {
                System.out.println("=======================");
                System.out.println("Can't place queens");
            } else {
                System.out.println(res.size() + " possible solutions");
            }
            for(char[][] r : res) {
                System.out.println("=======================");
                for(int k = 0; k < r.length; k++) {
                    for(int j = 0; j < r[0].length; j++) {
                        if(r[k][j] != 'X')
                            System.out.print(". ");
                        else
                            System.out.print(r[k][j] + " ");
                    }
                    System.out.println();
                }

            }
            System.out.println();
        }
    }

    public static List<char[][]> placeQueens(int n) {
        List<char[][]> res = new ArrayList<>();
        placeQueensR(0, new int[n], res);
        return res;
    }

    private static void placeQueensR(int row, int[] columns, List<char[][]> res) {
        if(row == columns.length) {
            char[][] result = new char[row][row];
            for(int i = 0;i < row; i++) {
                result[i][columns[i]] = 'X';
            }
            res.add(result.clone());
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
