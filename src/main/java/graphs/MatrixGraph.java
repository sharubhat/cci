package graphs;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sharath on 9/6/14.
 */
public class MatrixGraph extends Graph {
    /**
     * Constructs an empty graph with the specified number of vertices and with specified directed flag.
     *
     * @param numV
     * @param directed
     */
    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }

    public void loadEdgesFromFile(Scanner scan) {

    }
}
