package hackerrank.graphs_and_other_ds.traversal;

import java.util.List;
import java.util.Stack;

/**
 * Depth first search uses back tracking(or stack).
 *
 * Created by sharath on 11/11/15.
 */
public class DFS {
    public static void main(String[] args) {
        System.out.println("Recursive dfs of undirected graph");
        dfsRec(new UndirectedGraph(), 0);
        System.out.println("\nIterative dfs of undirected graph");
        dfs(new UndirectedGraph(), 0);
        System.out.println("\nRecursive dfs of directed graph");
        dfsRec(new DirectedGraph(), 0);
        System.out.println("\nIterative dfs of directed graph");
        dfs(new DirectedGraph(), 0);
    }

    /**
     * Back tracking DFS using adjacency list and visited boolean
     *
     * @param G
     * @param s
     */
    public static void dfsRec(Graph G, int s) {
        System.out.print(s + " ");
        G.visited.set(s, true);
        List<Integer> adj = G.adjacency.get(s);
        for (int i : adj) {
            if (!G.visited.get(i)) {
                dfsRec(G, i);
            }
        }
    }

    /**
     * DFS using stack, adjacency list and visited boolean
     *
     * Mark the node as visited before pushing it into stack
     *
     * @param G
     * @param s
     */
    public static void dfs(Graph G, int s) {
        //DFS uses Stack data structure
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        G.visited.set(s, true);
        System.out.print(s + " ");
        while(!stack.isEmpty())
        {
            // it's easy if you can think of a tree. You want to add everything on left subtree from root to stack
            // and start popping only when you reach the leaf. This implies, you only peek at the beginning and not pop.
            // You pop when there is no more child vertex left.
            int curr = stack.peek();
            int unvisited = getUnvisitedChildVertex(G, curr);

            if(unvisited != -1) {
                stack.push(unvisited);
                G.visited.set(unvisited, true);
                System.out.print(unvisited + " ");
            }
            else {
                // no more unvisited children present in current node
                stack.pop();
            }
        }
    }

    private static int getUnvisitedChildVertex(Graph G, int curr) {
        for(int i : G.adjacency.get(curr)) {
            if(!G.visited.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
