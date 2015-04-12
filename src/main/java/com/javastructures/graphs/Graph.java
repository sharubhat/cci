package com.javastructures.graphs;

import java.util.Iterator;

/**
 * Created by sharath on 4/8/15.
 */
public interface Graph<V, E> {
    // add
    void add(V label);
    void addEdge(V vtx1, V vtx2);

    // remove
    V remove(V lable);
    E removeEdge(E edge);

    // get
    V get(V label);
    Edge<V, E> getEdge(V label1, V label2);

    // contains
    boolean contains(V label);
    boolean containsEdge(E edge);

    // visit
    boolean visit(V label);
    boolean visitEdge(E edge);

    // visited
    boolean visited(V label);
    boolean visitedEdge(E edge);

    // reset graph
    void reset();

    // size
    int size();

    int degree();
    int edgeCount();

    // iterator
    Iterator<V> iterator();
    Iterator<V> neighbours(V label);
    Iterator<Edge<V,E>> edges();

    void clear();
    boolean isEmpty();
    boolean isDirected();
}
