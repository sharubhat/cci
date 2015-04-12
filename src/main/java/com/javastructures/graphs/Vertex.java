package com.javastructures.graphs;

/**
 * Created by sharath on 4/8/15.
 */
public class Vertex<E> {
    private E label;
    private boolean visited;

    public Vertex(E label) {
        this.label = label;
    }

    public E lable(){
        return label;
    }

    public void visit(){
        this.visited = true;
    }

    public boolean visited(){
        return this.visited;
    }

    public void reset(){

    }

    @Override
    public boolean equals(Object obj) {
        Vertex<E> that = null;
        if(obj != null && obj instanceof Vertex)
            that = (Vertex) obj;
        return this.label == that.label;
    }
}
