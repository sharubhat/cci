package hackerrank.graphs_and_other_ds.traversal;

/**
 * Number of connected components can easily be found by running dfs on all unvisited nodes.
 *
 * Created by sharath on 11/11/15.
 */
public class ConnectedComponents {
    public static void main(String[] args) {
        UndirectedGraph G = new UndirectedGraph("disconnected");
        int connected = 0;
        for(int i = 0; i < G.vertices; i++) {
            if(!G.visited.get(i)) {
                System.out.println();
                DFS.dfs(G, i);
                connected++;
            }
        }

        System.out.printf("%nThere are %d connected components%n", connected);
    }
}
