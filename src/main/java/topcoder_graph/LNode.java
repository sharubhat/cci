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

    // cost function tells if the second node is directly reachable from the first.
    // if there is a direct path from x to y, cost returns all the neighbours of x.
    private List<LNode> cost(LNode x, LNode y) {
        return x.neighbors.contains(y) ? x.neighbors : null;
    }

    private LNode dfs(LNode start, int value) {
        Stack<LNode> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            LNode curr = stack.pop();
            if(!curr.visited) {
                // check for termination condition
                if(value == curr.data)
                    return curr;
            }
            curr.visited = true;
            for(LNode node : curr.neighbors) {
                stack.push(node);
            }
        }
        return null;
    }

    private LNode dfsRec(LNode curr, int value) {
        curr.visited = true;
        if(value == curr.data)
            return curr;
        for(LNode node : curr.neighbors) {
            return dfsRec(node, value);
        }
        return null;
    }
}
