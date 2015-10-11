package hackerrank.graphs_and_other_ds.epi;

import java.util.*;

/**
 * EPI problem 19.1
 * 
 * Given a 2D array of blacks (1) and whites (0) entries representing a maze with designated entry and exit, find a
 * path from entrance to the exit if one exists.
 * 
 * Step 1: Figure out an approach to represent the problem itself.
 * a. Create a matrix that represents such a maze. Assign random ints to m and n of matrix.
 * b. Fill 0's and 1's randomly.
 * c. Crate a list of O's (of whites).
 * d. Select two random entries from whites to mark them and start and end.
 * 
 * Step 2: Solve the maze from step 1 to see if there exists a path from start to end.
 * Hint : DFS is easier and gives a path if there exists multiple paths. BFS gives shortest path but involves more work.
 * 
 * Created by sharath on 10/10/15.
 */
public class SearchAMaze {
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static LinkedList<Coordinate> searchMaze(List<List<Integer>> maze,
                                                    Coordinate s, Coordinate e) {
        LinkedList<Coordinate> path = new LinkedList<>();
        maze.get(s.x).set(s.y, 1);
        path.addFirst(s);
        if (!searchMazeRec(maze, s, e, path)) {
            path.removeLast();
        }
        return path;
    }

    // Performs DFS to find a feasible path.
    private static boolean searchMazeRec(List<List<Integer>> maze,
                                            Coordinate cur, Coordinate e,
                                            LinkedList<Coordinate> path) {
        if (cur.equals(e)) {
            return true;
        }

        int[][] shift = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] s : shift) {
            Coordinate next = new Coordinate(cur.x + s[0], cur.y + s[1]);
            if (isFeasible(next, maze)) {
                maze.get(next.x).set(next.y, 1);
                path.addLast(next);
                if (searchMazeRec(maze, next, e, path)) {
                    return true;
                }
                path.removeLast();
            }
        }
        return false;
    }

    // Checks cur is within maze and is a white pixel.
    private static boolean isFeasible(Coordinate cur, List<List<Integer>> maze) {
        return cur.x >= 0 && cur.x < maze.size() && cur.y >= 0 &&
                cur.y < maze.get(cur.x).size() && maze.get(cur.x).get(cur.y) == 0;
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int times = 0; times < 2; ++times) {
            int n, m;
            if (args.length == 2) {
                n = Integer.parseInt(args[0]);
                m = Integer.parseInt(args[1]);
            } else {
                n = r.nextInt(30) + 1;
                m = r.nextInt(30) + 1;
            }
            List<List<Integer>> maze = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                maze.add(new ArrayList(m));
                for (int j = 0; j < m; ++j) {
                    maze.get(i).add(r.nextInt(2));
                }
            }
            List<Coordinate> white = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (maze.get(i).get(j) == 0) {
                        white.add(new Coordinate(i, j));
                    }
                    System.out.print(maze.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println();
            if (white.size() != 0) {
                int start = r.nextInt(white.size());
                int end = r.nextInt(white.size());
                System.out.println(white.get(start));
                System.out.println(white.get(end));
                LinkedList<Coordinate> path =
                        searchMaze(maze, white.get(start), white.get(end));
                if (!path.isEmpty()) {
                    System.out.println(white.get(start).equals(path.peekFirst()) &&
                            white.get(end).equals(path.peekLast()));
                } else {
                    System.out.println("No path found");
                }
                Coordinate prev = null;
                for (Coordinate curr : path) {
                    if (prev != null) {
                        assert (Math.abs(prev.x - curr.x) + Math.abs(prev.y - curr.y) == 1);
                    }
                    prev = curr;
                    System.out.println("(" + curr.x + "," + curr.y + ")");
                }
            }
            System.out.println();
        }
    }
}
