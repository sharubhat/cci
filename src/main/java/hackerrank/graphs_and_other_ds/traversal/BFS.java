package hackerrank.graphs_and_other_ds.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharath on 10/12/15.
 */
public class BFS {
    public static void main(String[] args) {
        System.out.println("bfs of undirected graph");
        bfs(new UndirectedGraph(), 0);
        System.out.println("\nbfs of directed graph");
        bfs(new DirectedGraph(), 0);
    }

    /**
     * bfs using queue, adjacency list and visited boolean
     *
     * @param G
     * @param s
     */
    public static void bfs(Graph G, int s) {
        // bfs uses Queue data structure
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        G.visited.set(s, true);
        System.out.print(s + " ");
        while(!Q.isEmpty())
        {
            System.out.println();
            int curr = Q.poll();
            for(int i : G.adjacency.get(curr)) {
                if(!G.visited.get(i)) {
                    Q.add(i);
                    G.visited.set(i, true);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
