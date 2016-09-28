package hackerrank.graphs_and_other_ds.cci.Q4_01_Route_Between_Nodes;

import hackerrank.graphs_and_other_ds.cci.GNode;
import hackerrank.graphs_and_other_ds.cci.GState;
import hackerrank.graphs_and_other_ds.cci.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharath on 5/29/16.
 */
public class Routes {
    public static void main(String[] args) {
        Graph g = createNewGraph();
        GNode[] n = g.getNodes();
        GNode start = n[3];
        GNode end = n[5];
        System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph(6);
        GNode[] temp = new GNode[6];

        temp[0] = new GNode("a", 3);
        temp[1] = new GNode("b", 0);
        temp[2] = new GNode("c", 0);
        temp[3] = new GNode("d", 1);
        temp[4] = new GNode("e", 1);
        temp[5] = new GNode("f", 0);

        temp[0].addAdj(temp[1]);
        temp[0].addAdj(temp[2]);
        temp[0].addAdj(temp[3]);
        temp[3].addAdj(temp[4]);
        temp[4].addAdj(temp[5]);

        for(int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }

        return g;
    }

    public static boolean search(Graph g, GNode start, GNode end) {
        Queue<GNode> q = new LinkedList<>();
        for(GNode n : g.getNodes()) {
            n.state = GState.Unvisited;
        }
        start.state = GState.Visiting;
        q.add(start);
        GNode curr;
        while(!q.isEmpty()) {
            curr = q.remove();
            if(curr != null) {
                for(GNode v : curr.getAdj()) {
                    if(curr.state == GState.Unvisited) {
                        if(curr == end)
                            return true;
                        else {
                            curr.state = GState.Visiting;
                            q.add(curr);
                        }
                    }
                }
                curr.state = GState.Visited;
            }
        }
        return false;
    }
}
