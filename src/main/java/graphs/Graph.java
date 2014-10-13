package graphs;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Abstract base class for graphs. A graph is a set of vertices and a set of edges.
 * Vertices are represented by integers from 0 to n - 1.
 * Edges are oriented pairs of vertices.
 *
 * Created by sharath on 9/6/14.
 */
public abstract class Graph {
    private boolean directed;           // True if the graph is directed
    private int numV;                   // The number of vertices

    /**
     * Constructs an empty graph with the specified number of vertices and with specified directed flag.
     * @param numV
     * @param directed
     */
    public Graph(int numV, boolean directed) {
        this.directed = directed;
        this.numV = numV;
    }

    /**
     * Gets the number of vertices
     * @return
     */
    public int getNumV() {
        return this.numV;
    }

    /**
     * Returns true if the graph is directed.
     * @return
     */
    public boolean isDirected() {
        return this.directed;
    }

    public abstract Iterator<Edge> edgeIterator(int source);

    @Override
    public String toString() {
        return "Graph{" +
                "directed=" + directed +
                ", numV=" + numV +
                '}';
    }

    /**
     * Loads edges of a graph from the data in an input file. The file should contain a series of lines, each line with
     * two or three data values. the first is the source, the second is the destination, and the optional third is the
     * weight.
     * @param scan
     */
    public abstract void loadEdgesFromFile(Scanner scan);

    /**
     * Factory method to create graph and load the data from an input file. The first line of the input file should
     * contain the number of vertices. The remaining lines should contain the edge data
     * as described under the loadEdgesFromFile
     * @param scan
     * @param isDirected
     * @param type
     * @return Graph
     */
    public static Graph createGraph(Scanner scan, boolean isDirected, String type) {
        int numV = scan.nextInt();
        Graph returnValue = null;
        if(type.equalsIgnoreCase("Matrix"))
            returnValue = new MatrixGraph(numV, isDirected);
        else if(type.equalsIgnoreCase("List"))
            returnValue = new ListGraph(numV, isDirected);
        else
            throw new IllegalArgumentException();
        returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }
}
