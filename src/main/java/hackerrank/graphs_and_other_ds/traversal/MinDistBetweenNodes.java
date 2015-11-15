package hackerrank.graphs_and_other_ds.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * For graphs with edges of same weight, bfs can be used to find the minimum distance from one node to another.
 *
 * Created by sharath on 11/12/15.
 */
public class MinDistBetweenNodes {
    public static int minDist(Graph G, int s, int e) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        List<Integer> level = new ArrayList<>();
        level.add(0);
        while(!Q.isEmpty()) {
            int curr = Q.poll();
            for(int i : G.adjacency.get(curr)) {
                if(!G.visited.get(i)) {
                    G.visited.set(i, true);
                    Q.add(i);
                    level.add(level.get(curr) + 1);
                }
            }
        }
        return level.get(e);
    }

    public static void main(String[] args) {
        UndirectedGraph G = new UndirectedGraph("level");
        System.out.println("Min distance is " + minDist(G, 0, 8));
    }
}
