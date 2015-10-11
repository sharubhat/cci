package hackerrank.graphs_and_other_ds.epi;

import java.util.*;

/**
 * EPI problem 19.2
 *
 * You are given a N X N matrix that represents black and white photograph with vertices painted black or white.
 * Given a random cell with paint X, invert the color of all the vertices that are painted X and are reachable by given cell.
 *
 * Created by sharath on 10/10/15.
 */
public class PaintMatrix {
    private static class Coordinate {
        public Integer x;
        public Integer y;

        public Coordinate(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void printMatrix(boolean[][] A) {
        for (boolean[] element : A) {
            for (int j = 0; j < A.length; ++j) {
                System.out.printf("%5s ", element[j] == true ? '+' : '-');
            }
            System.out.println();
        }
    }

    // Running dfs using program stack - recursion
    public static void flipColorDFS(boolean[][] A, int x, int y) {
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean color = A[x][y];

        A[x][y] = !color;

        for(int[] dir : direction) {
            int nx = x + dir[0], ny = y + dir[1];
            if(nx >= 0 && nx < A.length && ny >= 0 && ny < A[nx].length && A[nx][ny] == color)
                flipColorDFS(A, nx, ny);
        }
    }

    public static void flipColorBFS(boolean[][] A, int x, int y) {
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean color = A[x][y];
        A[x][y] = !color;

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(x, y));
        while(!q.isEmpty()) {
            Coordinate curr = q.remove();
            for(int[] d : direction) {
                Coordinate next = new Coordinate(curr.x + d[0], curr.y + d[1]);
                if(next.x >= 0 && next.x < A.length &&
                        next.y >= 0 && next.y < A[next.x].length &&
                        A[next.x][next.y] == color) {
                    A[next.x][next.y] = !color;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Random gen = new Random();
        if (args.length == 1) {
            n = Integer.valueOf(args[0]);
        } else {
            n = gen.nextInt(10) + 1;
        }
        boolean[][] A = new boolean[n][n];
        boolean[][] B = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i][j] = gen.nextBoolean();
                B[i][j] = gen.nextBoolean();
            }
        }
        int i = gen.nextInt(n), j = gen.nextInt(n);
        System.out.println("color = " + i + " " + j + " " + A[i][j]);
        printMatrix(A);
        flipColorDFS(A, i, j);
        System.out.println();
        printMatrix(A);
        System.out.println();
        flipColorBFS(B, i, j);
        System.out.println();
        printMatrix(A);
    }
}
