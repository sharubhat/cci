package c04_trees_and_graphs.graphs.test;

import c04_trees_and_graphs.graphs.Digraph;
import c04_trees_and_graphs.graphs.Graph;

/**
 * Created by sharath on 9/2/14.
 */
public class MyGraph {

    public static void main(String[] args) {

        // Construct empty graph object with fixed max size
        Graph gD =new Graph(10);
        // Insert vertices
        gD.insertVertex(0);
        gD.insertVertex(1);
        gD.insertVertex(2);
        gD.insertVertex(3);
        gD.insertVertex(4);
        gD.insertVertex(5);
        gD.insertVertex(6);
        gD.insertVertex(7);
        gD.insertVertex(8);
        gD.insertVertex(9);
        // Insert edges
        gD.insertEdge(0, 1);
        gD.insertEdge(1, 2);
//        gD.insertEdge(1, 3);
        gD.insertEdge(1, 4);
        gD.insertEdge(2, 5);
        gD.insertEdge(2, 6);
        gD.insertEdge(2, 7);
        gD.insertEdge(4, 8);
        gD.insertEdge(4, 9);

        gD.output();

        System.out.println("Result of depth first search:");
        System.out.println(gD.dfs(0));


        // Construct empty graph object with fixed max size
        Graph gB =new Graph(10);
        // Insert vertices
        gB.insertVertex(0);
        gB.insertVertex(1);
        gB.insertVertex(2);
        gB.insertVertex(3);
        gB.insertVertex(4);
        gB.insertVertex(5);
        gB.insertVertex(6);
        gB.insertVertex(7);
        gB.insertVertex(8);
        gB.insertVertex(9);
        // Insert edges
        gB.insertEdge(0, 1);
        gB.insertEdge(1, 2);
//        gB.insertEdge(1, 3);
        gB.insertEdge(1, 4);
        gB.insertEdge(2, 5);
        gB.insertEdge(2, 6);
        gB.insertEdge(2, 7);
        gB.insertEdge(4, 8);
        gB.insertEdge(4, 9);

        System.out.println("Result of breadth first search:");
        System.out.println(gB.bfs(0));


        // Construct digraph

        // Construct empty digraph object with fixed max size
        Digraph dg =new Digraph(10);
        // Insert vertices
        dg.insertVertex(0);
        dg.insertVertex(1);
        dg.insertVertex(2);
        dg.insertVertex(3);
        dg.insertVertex(4);
        // Insert edges
        dg.insertEdge(0, 1);
        dg.insertEdge(0, 4);
        dg.insertEdge(1, 3);
        dg.insertEdge(3, 0);
        dg.insertEdge(3, 1);
        dg.insertEdge(4, 0);
        dg.insertEdge(4, 3);

        // Output specifications of digraph dg
        dg.output();

        // remove a vertex
        //dg.eraseVertex(3);
        //dg.output();

        System.out.println("Result of depth first search:");
        System.out.println(dg.dfs(3));

        System.out.println("Result of breadth first search:");
        System.out.println(dg.bfs(3));
    }
}
