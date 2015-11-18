package hackerrank.graphs_and_other_ds.traversal;

import java.util.*;

/**
 * Minimum spanning tree on undirected graph gives the minimum number of edges required to visit all nodes.
 *
 * Created by sharath on 11/14/15.
 */
public class MinimumSpanningTree {
    public static void main(String[] args) {
        UndirectedGraph G = new UndirectedGraph("mst");
        mstUDG(G);

        WeightedUDGraph W = new WeightedUDGraph("mstweighted");
        mstWDG(W);
    }

    public static void mstUDG(Graph G) {
        int s = 3;  // starting vertex
        Stack<Integer> S = new Stack<>();
        S.push(s);
        G.visited.set(s, true);
        while(!S.isEmpty()) {
            int curr = S.peek();
            int unvisited = getNextUnvisitedChild(G, curr);

            if(unvisited != -1) {
                S.push(unvisited);
                G.visited.set(unvisited, true);
                System.out.print("(" + curr + " -> " + unvisited + ") ");
            } else {
                S.pop();
            }
        }
    }

    private static int getNextUnvisitedChild(Graph G, int v) {
        for(int curr : G.adjacency.get(v)) {
            if(!G.visited.get(curr))
                return curr;
        }
        return -1;
    }

    /**
     * Start with a vertex, and put it in the tree. Then repeatedly do the following:
     *
     * 1. Find all the edges from the newest vertex to other vertices that aren’t in the tree.
     * Put these edges in the priority queue.
     *
     * 2. Pick the edge with the lowest weight, and add this edge and its destination vertex to the tree.
     * Repeat these steps until all the vertices are in the tree. At that point, you’re done.
     *
     * @param G
     */
    public static void mstWDG(Graph G) {
        System.out.println("Minimum spanning tree edges");
        // we only need the a set that contains vertices that are not in mst yet.
        Set<Integer> nonMst = new HashSet<>();
        for(int i = 0; i < G.vertices; i++) {
            nonMst.add(i);
        }
        PriorityQueue<Graph.Edge> PQ = new PriorityQueue<>(new Graph.EdgeComparator());
        int s = 5;  // start vertex
        nonMst.remove(s);
        int newestVertex = s;

        while(!nonMst.isEmpty()) {
            findAllEdgesNotInPQ(G, newestVertex, PQ, nonMst);
            Graph.Edge e = PQ.poll();
            System.out.println(e);
            nonMst.remove(e.v2);
            newestVertex = e.v2;
        }
    }

    private static void findAllEdgesNotInPQ(Graph G, int newestVertex,
                                            PriorityQueue<Graph.Edge> PQ, Set<Integer> nonMst) {
        List<Integer> adj = G.adjacency.get(newestVertex);
        for(int i : adj) {
            if(nonMst.contains(i)) {
                Graph.Edge e = getEdge(G, newestVertex, i);
                if(!PQ.contains(e))
                    PQ.add(e);
            }
        }
    }

    private static Graph.Edge getEdge(Graph G, int newestVertex, int i) {
        for(Graph.Edge e : G.edges) {
            if(e.v1 == newestVertex && e.v2 == i)
                return e;
        }
        return null;
    }
}
