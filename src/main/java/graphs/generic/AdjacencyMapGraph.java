package graphs.generic;

import c04_trees_and_graphs.trees.datastructures.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharath on 1/24/15.
 */
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    private boolean isDirected;
    private PositionalList<Vertex<V>> vertices;

    @Override
    public int numVertices() {
        return 0;
    }

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return null;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return null;
    }

    @Override
    public int outDegree(Vertex<V> v) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int inDegree(Vertex<V> v) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException {
        return new Vertex[0];
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        return null;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void removeVertex(Vertex<V> v) throws IllegalArgumentException {

    }

    @Override
    public void removeEdge(Edge<E> e) throws IllegalArgumentException {

    }

    //-------------nested inner vertex class--------------------//
    /** A vertex of an adjacency map graph representation. */
    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Position<Vertex<V>> pos;
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;

        public InnerVertex(V elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new HashMap<>();
            if(graphIsDirected)
                incoming = new HashMap<>();
            else
                incoming = outgoing;
        }

        public boolean validate(Graph<V, E> graph) {
            return (AdjacencyMapGraph.this == graph && pos != null);
        }

        public V getElement() {
            return element;
        }

        public Position<Vertex<V>> getPos() {
            return pos;
        }

        public void setPos(Position<Vertex<V>> pos) {
            this.pos = pos;
        }

        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        public Map<Vertex<V>, Edge<E>> getIncoming() {
            return incoming;
        }
    }
    //-------------end of nested inner vertex class-------------//

    //---------------nested inner edge class--------------------//
    /** An edge between two vertices. */
    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Position<Edge<E>> pos;
        private Vertex<V>[] endpoints;

        /** Construct InnerEdge instance from u to v,
         * storing the given element
         */
        public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
            element = elem;
            endpoints = (Vertex<V>[]) new Vertex[]{u, v};
        }

        @Override
        public E getElement() {
            return element;
        }

        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }

        public void setPosition(Position<Edge<E>> p) {
            pos = p;
        }

        public Position<Edge<E>> getPosition() {
            return pos;
        }
    }
    //-------------end of nested inner edge class---------------//

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<V> v : vertices) {
            sb.append("Vertex " + v.getElement() + "\n");
            if (isDirected)
                sb.append(" [outgoing]");
            sb.append(" " + outDegree(v) + " adjacencies:");
            for (Edge<E> e: outgoingEdges(v))
                sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getElement()));
            sb.append("\n");
            if (isDirected) {
                sb.append(" [incoming]");
                sb.append(" " + inDegree(v) + " adjacencies:");
                for (Edge<E> e: incomingEdges(v))
                    sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getElement()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
