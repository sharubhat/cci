package hackerrank.backtracking;

/**
 * Created by sharath on 9/4/15.
 */
public class Sudoku {
    private static boolean solveSudoku(int[][] grid) {
        int[] blankCell = findBlankLocation(grid);
        int row = blankCell[0], col = blankCell[1];

        if(row == -1) { // means we have filled the grid
            return true;
        }

        // fill the grid[row][col]
        for(int i = 1; i <= 9; i++) {
            if(isSafe(grid, row, col, i)) {
                grid[row][col] = i;
                if (solveSudoku(grid)) {
                    return true;
                }
                // if 'i' in grid[row][col] has not solved the sudoku, then reset it.
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int n) {
        return !(usedInRow(grid, row, n) ||
                    usedInCol(grid, col, n) ||
                    usedInBox(grid, row - (row %3), col - (col % 3), n));
    }

    private static boolean usedInBox(int[][] grid, int boxStartRow, int boxStartCol, int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + boxStartRow][j + boxStartCol] == n) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean usedInCol(int[][] grid, int col, int n) {
        for(int i = 0; i <9; i++) {
            if(grid[i][col] == n)
                return true;
        }
        return false;
    }

    private static boolean usedInRow(int[][] grid, int row, int n) {
        for(int i = 0; i <9; i++) {
            if(grid[row][i] == n)
                return true;
        }
        return false;
    }

    private static int[] findBlankLocation(int[][] grid) {
        int[] cell = new int[2];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(grid[i][j] == 0) {
                    cell[0] = i;
                    cell[1] = j;
                    return cell;
                }
            }
        }
        cell[0] = -1;
        cell[1] = -1;
        return cell;
    }

    private static void print(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                System.out.println(); // for more readability
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    System.out.print(" "); // for more readability
                }
                System.out.print(grid[row][col] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        if (solveSudoku(grid)) {
            print(grid);
        } else {
            System.out.println("NO SOLUTION");
        }
    }
}
