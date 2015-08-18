package topcoder_graph;

import java.util.Stack;

/**
 * Matrix representation of graph
 *
 * E.g: Connection matrix
 *
 * Traverse from left to right.
 * A is connected to itself with weight 0.
 * A is connected to B with weight 1.
 * B is not connected to A etc.
 *
 *
 *     A  B  C
 * A   0  1  5
 * B  -1  0  1
 * C  -1 -1  0
 *
 * Don't need to have a separate class for matrix representation of graph, just use a 2-D graph.
 * 
 * It's ideal to use a new visited array for each dfs. If not, then make sure to reset it before running a dfs.
 *
 * Created by sharath on 6/2/15.
 */
public class MGraph {
    private int[][] table;

    MGraph(int nodes) {
        this.table = new int[nodes][nodes];
    }

    public static void dfsRec(MGraph g, int vertex) {
        dfsRec(g, vertex, new boolean[g.table[vertex].length]);
    }

    private static void dfsRec(MGraph g, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + "  ");

        for(int i = 0; i < g.table[vertex].length; i++) {
            if(g.table[vertex][i] != 0 && !visited[i]) {
                dfsRec(g, i, visited);
            }
        }
    }

    public static void dfsStack(MGraph g, int vertex) {
        boolean[] visited = new boolean[g.table[vertex].length];

        Stack<Integer> stack = new Stack<>();

        stack.push(vertex);

        while(!stack.isEmpty()) {
            int curr = stack.pop();
            System.out.print(curr + "  ");
            if(!visited[curr]) {
                visited[curr] = true;
            }
            for(int i = 0; i < g.table[curr].length; i++) {
                if(g.table[curr][i] != 0 && !visited[i])
                    stack.push(i);
            }
        }
    }

    public static void main(String[] args) {
        MGraph g = new MGraph(4);
        g.table[0] = new int[]{0, 1, 0, 0};
        g.table[1] = new int[]{1, 0, 0, 1};
        g.table[2] = new int[]{0, 0, 0, 0};
        g.table[3] = new int[]{0, 1, 0, 0};

        dfsRec(g, 0);
        System.out.println();
        dfsStack(g, 0);
    }
}
