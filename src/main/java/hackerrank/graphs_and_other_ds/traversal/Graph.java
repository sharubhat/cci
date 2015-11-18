package hackerrank.graphs_and_other_ds.traversal;

import java.util.Comparator;
import java.util.List;

/**
 * Created by sharath on 11/11/15.
 */
public class Graph {
    public int vertices;
    public int numEdges;
    public List<Edge> edges;
    public List<List<Integer>> matrix;
    public List<Boolean> visited;
    public List<List<Integer>> adjacency;

    public static class Edge {
        public int v1;
        public int v2;
        public int w;
        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(" + v1 + ", " + v2 + ") - (" + w + ")";
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge e1, Edge e2) {
            if(e1.equals(e2) && e1.w == e2.w)
                return 0;
            return e1.w > e2.w ? 1 : -1;
        }
    }
}
