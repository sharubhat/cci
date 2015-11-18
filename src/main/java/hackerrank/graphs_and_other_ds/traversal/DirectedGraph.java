package hackerrank.graphs_and_other_ds.traversal;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sharath on 11/11/15.
 */
public class DirectedGraph extends Graph {
    public DirectedGraph() {
        this(FileSystems.getDefault().getPath("/Users/sharath/Documents/git/cci/src/main/java/hackerrank/graphs_and_other_ds/traversal", "dgraph"));
    }

    public DirectedGraph(String filename) {
        this(FileSystems.getDefault().getPath("/Users/sharath/Documents/git/cci/src/main/java/hackerrank/graphs_and_other_ds/traversal", filename));
    }

    public DirectedGraph(Path path) {
        try {
            File file = new File(path.toUri());
            Scanner sc = new Scanner(file);
            this.vertices = sc.nextInt();
            this.numEdges = sc.nextInt();
            // create base matrix
            this.matrix = new ArrayList<>(vertices);
            // create adjacency list
            this.adjacency = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; ++i) {
                matrix.add(new ArrayList(vertices));
                adjacency.add(new ArrayList<>());
                for (int j = 0; j < vertices; ++j) {
                    matrix.get(i).add(0);
                }
            }

            // read edges and add them to matrix

            while(sc.hasNext()) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                this.matrix.get(v1).set(v2, 1);
                this.adjacency.get(v1).add(v2);
            }

            for (int i = 0; i < vertices; ++i) {
                for (int j = 0; j < vertices; ++j) {
                    System.out.print(this.matrix.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println();

            for(int i = 0; i < vertices; i++) {
                System.out.println(i + " -> " + adjacency.get(i));
            }

            // create visited list
            this.visited = new ArrayList<>(vertices);
            for(int i = 0; i < vertices; i++) {
                this.visited.add(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DirectedGraph ug = new DirectedGraph();
    }
}
