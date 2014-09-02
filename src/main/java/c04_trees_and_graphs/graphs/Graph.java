package c04_trees_and_graphs.graphs;

/**
 * Created by sharath on 9/1/14.
 */
public class Graph extends Digraph {
    public Graph(int maxSize) {
        super(maxSize);
    }

    // Returns whether v is joined to w by an undirected edge.
    @Override
    public boolean isAdjacent(Integer v, Integer w) {
        return adjList[v].contains(w) && adjList[w].contains(v);
    }

    // Inserts undirected edge joining v and w.
    // Precondition: v, w are edges in the current graph
    @SuppressWarnings("unchecked")
    @Override
    public void insertEdge(Integer v, Integer w) {
        // v, w are edges in the current graph, and v and w are not currently joined by an undirected edge.
        // Add an edge joining v and w by adding an edge from v to w and an edge from w to v.
        if(vertices[v] && vertices[w] &&
                !adjList[v].contains(w) &&
                !adjList[w].contains(v)) {
            adjList[v].add(w);
            adjList[w].add(v);
        } else {
            throw new GraphException("Illegal attempt to join vertices");
        }
    }

    // Removes edge joining v and w, if currently present in undirected graph.
    @Override
    public void eraseEdge(Integer v, Integer w) {
        // There are edges from v to w and w to v, and v, w are vertices.
        if(isAdjacent(v, w) && vertices[v] && vertices[w]) {
            adjList[v].remove(w);
            adjList[w].remove(v);
        } else {
            throw new GraphException("Illegal edge removal");
        }
    }

    @Override
    public void output() {
        System.out.println("Vertices are: ");
        for(int i = 0; i < maxSize; i++) {
            if(vertices[i])
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Edges are: ");
        for(int i = 0; i < maxSize; i++) {
            if(vertices[i])
                System.out.println(i + " " + adjList[i]);
        }
        if(isEmpty()) {
            System.out.println("Current graph is empty");
        } else {
            System.out.println("Current graph is not empty");
            System.out.println("Current graph has " + size() + " vertices.");
        }
    }
}
