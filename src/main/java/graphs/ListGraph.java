package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ListGraph is an extension of AbstractGraph abstract class that uses an array of Lists to represent the edges.
 *
 * Created by sharath on 9/6/14.
 */
public class ListGraph extends Graph {
    private List<Edge>[] edges;
    /**
     * Constructs an empty graph with the specified number of vertices and with specified directed flag.
     *
     * @param numV
     * @param directed
     */
    @SuppressWarnings("unchecked")
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        this.edges = new List[numV];
        for(int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    /**
     * Get the edge between two vertices. If an edge does not exist, an edge with weight Double.POSITIVE_INFINITY is
     * returned.
     * @param source
     * @param dest
     * @return
     */
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for(Edge edge: this.edges[source]) {
            if(edge.equals(target))
                return edge;
        }
        return target;
    }

    /**
     * Insert new edge into the graph
     * @param e
     */
    public void insert(Edge e) {
        edges[e.getSource()].add(e);
        if(!isDirected()) {
            edges[e.getDest()].add(new Edge(e.getDest(), e.getSource(), e.getWeight()));
        }
    }

    /**
     * Determine whether an edge exists.
     * @param source
     * @param dest
     * @return
     */
    public boolean isEdge(int source, int dest) {
        return edges[source].contains(new Edge(source, dest));
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString() + "\n");
        sb.append("ListGraph{ \n ");
        sb.append("edges=\n");
        for(int i = 0; i < this.getNumV(); i++) {
            sb.append("\nSource : " + i);
            sb.append("\nEdges : ");
            Iterator<Edge> it = this.edgeIterator(i);
            if(!it.hasNext())
                sb.append("Has no edges");
            while(it.hasNext()) {
                sb.append(it.next());
            }
        }

        sb.append("\n}");
        return sb.toString();
    }

    /**
     * Loads edges of a graph from the data in an input file. The file should contain a series of lines, each line with
     * two or three data values. the first is the source, the second is the destination, and the optional third is the
     * weight.
     * @param scan
     */
    @Override
    public void loadEdgesFromFile(Scanner scan) {
        scan.nextLine();
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] data = line.split(" ");
            int source = Integer.parseInt(data[0]);
            int dest = Integer.parseInt(data[1]);
            double weight = (data.length == 3) ? Double.parseDouble(data[2]) : 1.0;

            insert(new Edge(source, dest, weight));
        }
    }
}
