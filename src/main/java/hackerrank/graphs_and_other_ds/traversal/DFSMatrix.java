package hackerrank.graphs_and_other_ds.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by sharath on 11/2/15.
 */
public class DFSMatrix {
    public static void dfs(List<List<Integer>> graph, int vertex) {
        List<Boolean> visited = new ArrayList<>(graph.size());
        for(int i = 0; i < graph.size(); i++) {
            visited.add(Boolean.FALSE);
        }
        visited.set(0, Boolean.TRUE);
        List<Integer> path = new LinkedList<>();
        dfs(graph, vertex, visited, path);
        System.out.println(path);

    }

    private static void dfs(List<List<Integer>> graph, int vertex, List<Boolean> visited, List<Integer> path) {
        for(int i = 0; i < graph.size(); i++) {
            if(graph.get(vertex).get(i) == 1 && !visited.get(i)) {
                visited.set(i, Boolean.TRUE);
                path.add(vertex);
                dfs(graph, i, visited, path);
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int n;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
        } else {
            n = r.nextInt(30) + 1;
        }
        List<List<Integer>> maze = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            maze.add(new ArrayList(n));
            for (int j = 0; j < n; ++j) {
                maze.get(i).add(r.nextInt(2));
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(maze.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        dfs(maze, 0);

    }
}
