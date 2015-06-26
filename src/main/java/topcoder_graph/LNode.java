package topcoder_graph;

import java.util.List;
import java.util.Stack;

/**
 * List representation of graph
 *
 * Created by sharath on 6/2/15.
 */
public class LNode {
    private List<LNode> neighbors;
    private int data;
    private boolean visited;

    private List<LNode> cost(LNode x, LNode y) {
        return x.neighbors.contains(y) ? x.neighbors : null;
    }

    private void dfs(LNode start) {
        Stack<LNode> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            LNode curr = stack.pop();
            if(!curr.visited) {
                // check for termination condition
            }
            curr.visited = true;
            for(LNode node : curr.neighbors) {
                stack.push(node);
            }
        }
    }

    private void dfsRec(LNode curr) {
        curr.visited = true;
        for(LNode node : curr.neighbors) {
            dfsRec(node);
        }
    }
}
