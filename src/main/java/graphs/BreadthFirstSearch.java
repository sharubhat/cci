package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to implement the breadth-first search algorithm.
 *
 * Created by sharath on 9/7/14.
 */
public class BreadthFirstSearch {

    /**
     * Perform a breadth-first search of a graph.
     * post: The array parent will contain the predecessor of each vertex in the breadth-first search tree.
     *
     * @param g The graph to be searched
     * @param start The start vertex
     * @return The array of parents
     */
    @SuppressWarnings("unchecked")
    public static int[] breadthFirstSearch(Graph g, int start) {
        Queue<Integer> q = new LinkedList();
        // Declare array parent and initialize it's element to -1
        int[] parent = new int[g.getNumV()];
        for(int i = 0; i < g.getNumV(); i++) {
            parent[i] = -1;
        }

        // Declare array identified.
        boolean[] identified = new boolean[g.getNumV()];
        // mark the start vertex as identified and insert it into the queue
        identified[start] = true;
        q.offer(start);

        // tq -> traversal queue for remembering the path
        Queue<Integer> tq = new LinkedList<>();
        tq.offer(start);

        // Perform breadth first search until done
        while(!q.isEmpty()) {
            int current = q.remove();
            Iterator<Edge> it = g.edgeIterator(current);

            // examine each vertex, neighbour, adjacent to current
            while(it.hasNext()) {
                Edge edge = it.next();
                int neighbour = edge.getDest();
                // If neighbour has not been identified
                if(!identified[neighbour]) {
                    // mark it as identified
                    identified[neighbour] = true;
                    // place it into the queue
                    q.offer(neighbour);
                    tq.offer(neighbour);
                    // insert the edge (current, neighbour) into the tree
                    parent[neighbour] = current;
                }
            }
        }

        Iterator<Integer> tqItr = tq.iterator();
        System.out.print("Nodes visited in the order \n{");
        while(tqItr.hasNext()) {
            System.out.print(tqItr.next() + ", ");
        }
        System.out.println("}");
        return parent;
    }
}
