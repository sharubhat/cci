package hackerrank.recursion.homework;

import java.util.Arrays;

/**
 * You are given a 2-Dimensional array with M rows and N columns. You are initially positioned at (0,0) which is the top-left cell in the array. You are allowed to move either right or downwards. The array is filled with 1's and 0's. A 1 indicates that you can move through that cell, a 0 indicates that you cannot move through the
 * cell. Given a function numberOfPaths which takes in the above 2-D array, return the number of paths from the top-left cell to the bottom-right cell (i.e. (0,0) to (M-1,N-1)).
 * Your task is to complete the body of the function and return a single integer denoting the number of paths mentioned above.
 *
 * Created by sharath on 6/7/16.
 */
public class RobotInGrid {
    public int[][] solution;

    public RobotInGrid(int m, int n) {
        this.solution = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(this.solution[i], 0);
        }
    }

    static int numberOfPaths(int [][]a,int M,int N) {
        return numPathsR(a, 0,0,M - 1, N - 1);
    }
    static int numPathsR(int[][]a, int m_now, int n_now, int M, int N) {
        if (m_now > M || n_now > N)
            return 0;
        if (a[m_now][n_now] == 0)
            return 0;
        if (m_now == M && n_now == N) {
            return 1;
        }
        return numPathsR(a, m_now + 1, n_now, M, N) + numPathsR(a, m_now, n_now + 1, M, N);
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 1, 1,1 }, { 1, 1, 1, 1, 0}, { 1, 0,0, 1, 1 },
                { 1, 1, 0, 1,0 },{ 0, 0,0, 1, 1 } };
        System.out.println();
        RobotInGrid r = new RobotInGrid(maze.length, maze[0].length);
        System.out.println(r.numberOfPaths(maze, maze.length, maze[0].length));
    }

    public static void print(int [][] solution){
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }
}
