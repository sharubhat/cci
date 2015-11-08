package hackerrank.graphs_and_other_ds.epi;

import java.util.List;

/**
 * A minimally connected graph is a graph in which no edge can be removed while keeping all the vertices connected.
 *
 * Write a program to check if given undirected graph is minimally connected.
 *
 * Created by sharath on 11/3/15.
 */
public class MinimallyConnectedGraph {
    public static class Vertex {
        public enum Color {WHITE, GREY, BLACK}

        public Color color;
        public List<Vertex> edges;
    }

    public static boolean isMinimallyConnected(List<Vertex> G) {
        if(!G.isEmpty()) {
            return !hasCycle(G.get(0), null);
        }
        return true;
    }

    private static boolean hasCycle(Vertex cur, Vertex pre) {
        if(cur.color == Vertex.Color.GREY)
            return true;
        cur.color = Vertex.Color.GREY;
        for(Vertex next : cur.edges) {
            if(next != pre && next.color != Vertex.Color.BLACK) {
                if(hasCycle(next, cur))
                    return true;
            }
        }
        cur.color = Vertex.Color.BLACK;
        return false;
    }
}
