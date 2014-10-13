package graphs;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sharath on 9/7/14.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // Testing directed, weighted graph
        Scanner scan = new Scanner(new File("graph.txt"));
        Graph g = Graph.createGraph(scan, true, "List");
        System.out.println(g.toString());

        // testing undirected, unweighted graph
        scan = new Scanner(new File("unweightedgraph.txt"));
        Graph g2 = Graph.createGraph(scan, false, "List");
        System.out.println(g2.toString());
        System.out.println("Parents array : \n" + Arrays.toString(BreadthFirstSearch.breadthFirstSearch(g2, 0)));

        scan = new Scanner(new File("dfs.txt"));
        g = Graph.createGraph(scan, false, "List");
        int n = g.getNumV();

        DepthFirstSearch dfs = new DepthFirstSearch(g);
        int[] dOrder = dfs.getDiscoveryOrder();
        int[] fOrder = dfs.getFinishOrder();
        System.out.println("Discovery and finish order");
        System.out.println(Arrays.toString(dOrder));
        System.out.println(Arrays.toString(fOrder));
    }
}
