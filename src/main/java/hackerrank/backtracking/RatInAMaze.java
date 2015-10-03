package hackerrank.backtracking;

import java.util.Arrays;

/**
 * Given a maze, NxN matrix. A rat has to find a path from source to destination.
 * maze[0][0] (left top corner)is the source and maze[N-1][N-1](right bottom corner) is destination.
 * There are few cells which are blocked, means rat cannot enter into those cells.
 * Rat can move in any direction (left, right, up and down).
 *
 * Input: A 2D-matrix with 0’s and 1’s fill in it. 0 means that cell is blocked and 1 means rat can move to that cell.
 *
 * Created by sharath on 9/29/15.
 */
public class RatInAMaze {
    public int[][] solution;

    public RatInAMaze(int m, int n) {
        this.solution = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(this.solution[i], 0);
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] maze = { { 1, 0, 1, 1,1 }, { 1, 1, 1, 0,1 }, { 1, 0,0, 1, 1 },
                { 1, 1, 0, 1,0 },{ 0, 0,0, 1, 1 } };
        print(maze);
        System.out.println();
        RatInAMaze r = new RatInAMaze(maze.length, maze[0].length);
        r.solveMaze(maze, N);
    }

    private void solveMaze(int[][] maze, int n) {
        if(findPath(maze, 0, 0, n, n, 'd'))
            print(this.solution);
        else
            System.out.println("No path found");
    }

    private boolean findPath(int[][] maze, int x, int y, int m, int n, char d) {
        if(x == m-1 && y == n-1) {
            solution[x][y] = 1;
            return true;
        }
        if(isSafe(maze, x, y, m, n)) {
            solution[x][y] = 1;
            // rat can go in all 4 directions but should avoid going backwards.
            // each of these if's let rat move in three possible directions.
            if(d != 'l' && findPath(maze, x, y + 1, m, n, 'r')) // go right
                return true;
            if(d != 'r' && findPath(maze, x, y-1, m, n, 'l'))
                return true;
            if(d != 'u' && findPath(maze, x+1, y, m, n, 'd'))
                return true;
            if(d != 'd' && findPath(maze, x-1, y, m, n, 'u'))
                return true;
            // if none of the paths lead to destination, go back
            solution[x][y] = 0;
            return false;
        }
        return false;
    }

    private boolean isSafe(int[][] maze, int x, int y, int m, int n) {
        if(x >= 0 && y >=0 && x < m && y < n && maze[x][y] != 0)
            return true;
        return false;
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
