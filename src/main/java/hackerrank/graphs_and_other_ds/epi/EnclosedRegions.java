package hackerrank.graphs_and_other_ds.epi;

import java.util.*;

/**
 * EPI problem 19.3
 *
 * Given a grid painted black and whites, find enclosed region that's painted white and is not reachable from
 * a white cell in the boundary(and paint them black).
 *
 * Eg:(To make it easy to visualize, W has been replaced by a '.')
 *
 * B B B B
 * . B . B
 * B . . B
 * B B B B
 *
 * Sol:
 *
 * B B B B
 * . B B B
 * B B B B
 * B B B B
 *
 * Created by sharath on 10/11/15.
 */
public class EnclosedRegions {
    private static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void fillSurroundingRegions(List<List<Character>> grid) {
        if(grid.isEmpty())
            return;
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
        for(int i = 1; i < grid.size() - 1; i++) {
            for(int j = 1; j < grid.get(i).size() - 1; j++) {
                if(grid.get(i).get(j) == 'W' && !visited[i][j]) {
                    markRegionIfSurrounded(i, j, grid, visited);
                }
            }
        }
    }

    private static void markRegionIfSurrounded(int i, int j, List<List<Character>> grid, boolean[][] visited) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        List<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(i, j));
        visited[i][j] = true;
        boolean isSurrounded = true;
        int idx = 0;

        while(idx < q.size()) {
            Coordinate cur = q.get(idx++);
            if(cur.x == 0 || cur.x == grid.size() - 1 || cur.y == 0 || cur.y == grid.get(cur.x).size() - 1) {
                isSurrounded = false;
            } else {
                for(int[] d : dir) {
                    Coordinate next = new Coordinate(cur.x + d[0], cur.y + d[1]);
                    if(grid.get(next.x).get(next.y) == 'W' && !visited[next.x][next.y]) {
                        visited[next.x][next.y] = true;
                        q.add(next);
                    }
                }
            }
        }

        if(isSurrounded && !q.isEmpty()) {
            System.out.println("Painting");
            for(Coordinate c : q) {
                grid.get(c.x).set(c.y, 'B');
            }
        } else {
            System.out.println("No surrounding area to paint");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n, m;
        if(args.length == 2) {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        } else {
            n = random.nextInt(10) + 1;
            m = random.nextInt(10) + 1;
        }
        List<List<Character>> grid = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            List<Character> row = new ArrayList<>(m);
            for(int j = 0; j < m; j++) {
                row.add(random.nextBoolean() ? 'B' : 'W');
            }
            grid.add(row);
        }
        for(List<Character> row : grid) {
            System.out.println(row);
        }
        fillSurroundingRegions(grid);
        System.out.println();
        for(List<Character> row : grid) {
            System.out.println(row);
        }
    }
}
