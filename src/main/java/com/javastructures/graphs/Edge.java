package com.javastructures.graphs;

/**
 * Created by sharath on 4/8/15.
 */
public class Edge<V, E> {
    private V v1;
    private V v2;
    private E label;
    private boolean directed;
    private boolean visited;

    public Edge(V v1, V v2, E label, boolean directed) {
        this.v1 = v1;
        this.v2 = v2;
        this.label = label;
        this.directed = directed;
    }

    public V here() {
        return v1;
    }

    public V there() {
        return v2;
    }

    public void setLabel(E label) {
        this.label = label;
    }

    public E label() {
        return this.label;
    }

    public void visit() {
        this.visited = true;
    }

    public boolean visited() {
        return this.visited;
    }

    public boolean isDirected() {
        return this.directed;
    }

    public void reset() {
        this.visited = false;
    }

    @Override
    public boolean equals(Object obj) {
        Edge<E, V> that = null;
        if(obj != null && obj instanceof Edge)
            that = (Edge) obj;
        return (this.v1 == that.v1 && this.v2 == that.v2) || (this.v2 == that.v1 && this.v1 == that.v2);
    }
}
