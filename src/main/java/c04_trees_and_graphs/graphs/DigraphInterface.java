package c04_trees_and_graphs.graphs;

/**
 * Created by sharath on 8/31/14.
 *
 * Ref: http://support.csis.pace.edu/CSISWeb/docs/techReports/techReport224.pdf
 */
public interface DigraphInterface<V> {
    // Test whether current graph is empty.
    // Returns true if so, false if not.
    boolean isEmpty();

    // Returns the number of distinct vertices in the current digraph
    int size();

    // Returns whether v is joined to w by an edge
    // Returns true if so, false if not.
    boolean isAdjacent(V v, V w);

    // Inserts edge from v to w.
    // Constructs from v to w, if no such egde already exists and throws exception otherwise.
    // Precondition: v, w are vertices in the current digraph.
    void insertEdge(V v, V w);

    // Inserts a new vertex if that vertex is not already present
    // and raises exception if no vertex is inserted, since it is already a vertex of current digraph.
    void insertVertex(V v);

    // Removes vertex from current digraph if present, along with all incident edges.
    // Raises exception if that vertex is not present in digraph
    void eraseVertex(V v);

    // Removes edge from v to w if currently present in digraph
    // Precondition: v and w are vertices in current digraph
    void eraseEdge(V v, V w);

    // Outputs specifications of current digraph
    void output();
}
