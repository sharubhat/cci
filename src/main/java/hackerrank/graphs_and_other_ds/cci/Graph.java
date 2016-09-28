package hackerrank.graphs_and_other_ds.cci;

/**
 * Created by sharath on 5/29/16.
 */
public class Graph {
    private GNode vertices[];
    public int count;

    public Graph(int verticesCount) {
        vertices = new GNode[verticesCount];
        count = 0;
    }

    public void addNode(GNode x) {
        if(count < vertices.length) {
            vertices[count++] = x;
        } else {
            System.out.println("Graph full");
        }
    }

    public GNode[] getNodes() {
        return vertices;
    }
}
