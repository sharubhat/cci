package topcoder_graph;

/**
 * Matrix representation of graph
 *
 * E.g: Connection matrix
 *
 * Traverse from left to right.
 * A is connected to itself with weight 0.
 * A is connected to B with weight 1.
 * B is not connected to A etc.
 *
 *
 *     A  B  C
 * A   0  1  5
 * B  -1  0  1
 * C  -1 -1  0
 *
 * Don't need to have a separate class for matrix representation of graph, just use a 2-D graph.
 *
 * Created by sharath on 6/2/15.
 */
public class MGraph {
    private int[][] data;
}
