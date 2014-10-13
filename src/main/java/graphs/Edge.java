package graphs;

/**
 * Created by sharath on 9/6/14.
 */
public class Edge {
    private int source;                 // The source vertex of an edge
    private int dest;                   // The destination of vertex for an edge.
    private double weight;              // The weight of an edge.

    /**
     * Constructs the Edge from source to destination. Sets the weight to 1.0.
     * @param source
     * @param dest
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.weight = 1.0;
    }

    /**
     * Constructor for weighted graphs.
     * Constructs the Edge from source to destination. Sets the weight to w.
     * @param source
     * @param dest
     */
    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }

    /**
     * Returns the source vertex
     * @return
     */
    public int getSource() {
        return source;
    }

    /**
     * Returns the destination vertex
     * @return
     */
    public int getDest() {
        return dest;
    }

    /**
     * Returns the weight
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the string representation of the edge
     * @return
     */
    @Override
    public String toString() {
        return "\n{" +
                "v-" + source +
                " to v-" + dest +
                ", weight=" + weight +
                '}';
    }

    /**
     * Compares two edges for equality. Edges are equal if their source and destination vertices are the same.
     * The weights are not considered.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        if (dest != edge.dest) return false;
        if (source != edge.source) return false;

        return true;
    }

    /**
     * Returns the hash code of an edge. The hash code depends only on source and destination.
     * @return
     */
    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + dest;
        return result;
    }
}
