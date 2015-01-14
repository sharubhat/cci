package graphs;

import java.util.Iterator;

/**
 * Created by sharath on 9/8/14.
 */
public class DepthFirstSearch {
    private int discoverIndex;      // The index that indicates the discovery order.
    private int[] discoveryOrder;   // The array that contains the vertices in discovery order.
    private int finishIndex;        // The index that indicates the finish order.
    private int[] finishOrder;      // The array that contains the vertices in finish order.
    private Graph g;                // A reference to graph being searched.
    private int[] parent;           // The array of predecessors in the depth-first search.
    private boolean[] visited;      // An array of boolean values to indicate whether or not a vertex has been visited.

    /**
     * Constructs the depth-first search of the specified graph starting at vertex 0 and visiting the start vertices in
     * ascending order.
     * @param g
     */
    public DepthFirstSearch(Graph g) {
        this.g = g;
        int n = g.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i])
                depthFirstSearch(i);
        }
    }

    /**
     * Construct the depth-first search of a graph selecting start vertices in the specified order.
     * The first vertex visited is order[0].
     * @param g
     * @param order
     */
    public DepthFirstSearch(Graph g, int[] order) {
        this.g = g;
        int n = g.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for(int i = 0; i < order.length; i++) {
            if(!visited[order[i]])
                depthFirstSearch(order[i]);
        }
    }

    /**
     * Recursively search the graph starting at vertex s.
     * @param current
     */
    public void depthFirstSearch(int current) {
        // Mark the current vertex visited
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;

        Iterator<Edge> it = g.edgeIterator(current);
        while(it.hasNext()) {
            int neighbour = it.next().getDest();
            // Process a neighbour that has not been visited
            if(!visited[neighbour]) {
                // Insert (current, neighbour) into the depth-search first tree
                parent[neighbour] = current;

                // Recursively apply the algorithm starting at neighbour
                depthFirstSearch(neighbour);
            }
        }
        // Mark current finished
        finishOrder[finishIndex++] = current;
    }

    public int[] getDiscoveryOrder() {
        return discoveryOrder;
    }

    public int[] getFinishOrder() {
        return finishOrder;
    }

    public int[] getParent() {
        return parent;
    }
}
