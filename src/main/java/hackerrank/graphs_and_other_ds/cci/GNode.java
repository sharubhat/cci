package hackerrank.graphs_and_other_ds.cci;

/**
 * Created by sharath on 5/29/16.
 */
public class GNode {
    private GNode[] adj;
    public int adjCount;
    private String vertex;
    public GState state;

    public GNode(String vertex, int adjLength) {
        this.vertex = vertex;
        this.adjCount = 0;
        this.adj = new GNode[adjLength];
    }

    public void addAdj(GNode n) {
        if(adjCount < adj.length) {
            adj[adjCount] = n;
            adjCount++;
        } else {
            System.out.println("No more adjacent can be added");
        }
    }

    public GNode[] getAdj() {
        return adj;
    }

    public String getVertex() {
        return vertex;
    }
}
