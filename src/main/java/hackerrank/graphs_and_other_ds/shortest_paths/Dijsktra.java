package hackerrank.graphs_and_other_ds.shortest_paths;

import hackerrank.graphs_and_other_ds.traversal.Graph;
import hackerrank.graphs_and_other_ds.traversal.WeightedDGraph;

import java.util.*;

/**
 * Dijsktra's shortest path algorithm to find single source shortest paths
 * for a DAG(directed acyclic graphs) with positive weights/distances.
 *
 * Steps:
 * 1. Maintain a priority queue of vertices(priority based on weights/distances from source). Initialize source
 *    distance to zero and rest to positive infinity.
 * 2. Maintain a distance list to store shortest distance from source for each vertex.
 * 3. While PQ is not empty, remove the minimum. Update shortest path distance of all adjacent vertices based on removed vertex.
 *
 * This is a greedy algorithm. For simplicity, java implementation of Priority queue is used here. It can be optimized
 * by using Fibonacci heap.
 *
 * Time complexity calculation:
 * 1. V vertices get inserted into binary heap - O(V logV)
 * 2. V extract min operation - O(V)
 * 3. E update key operations (delete + insert) - O(E logE)
 * So over all complexity is O(VlogV + ElogE)
 *
 * This can be improved by using Fibonacci heap.
 *
 * Created by sharath on 11/15/15.
 */
public class Dijsktra {
    public static void main(String[] args) {
        WeightedDGraph G = new WeightedDGraph("dijsktra3");
        shortestPath(G, 0);
    }

    private static class Distance {
        int vertex;
        int distance;

        public Distance(int v, int d) {
            this.vertex = v;
            this.distance = d;
        }

        @Override
        public String toString() {
            return "(" + vertex + " " + distance + ")";
        }
    }

    private static class DistanceComparator implements Comparator<Distance> {
        @Override
        public int compare(Distance o1, Distance o2) {
            if(o1.distance == o2.distance)
                return 0;
            return o1.distance > o2.distance ? 1 : -1;
        }
    }

    public static void shortestPath(WeightedDGraph G, int s) {
        PriorityQueue<Distance> PQ = new PriorityQueue<>(new DistanceComparator());
        List<Integer> dist = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        PQ.add(new Distance(s, 0));

        for(int i = 0; i < G.vertices; i++) {
            dist.add(Integer.MAX_VALUE);
            prev.add(-1);
            if(i != s)
                PQ.add(new Distance(i, Integer.MAX_VALUE));
        }

        dist.set(s, 0);
        prev.set(s, s);

        while(!PQ.isEmpty()) {
            Distance ud = PQ.poll();
            int u = ud.vertex;
            int d = ud.distance;
            for(int v : G.adjacency.get(u)) {
                int distV = getEdgeDistance(G, u, v);
                if(dist.get(v) > (d + distV)) {
                    dist.set(v, (d + distV));
                    updateQueue(PQ, v, (d + distV));
                    prev.set(v, u);
                }
            }
        }

        for(int i = 0; i < dist.size(); i++) {
            System.out.println("Cost of reaching " + i + " is " + dist.get(i));
        }
        for(int i = 0; i < prev.size(); i++) {
            System.out.printf("Previous vertex of %d is %d%n", i, prev.get(i));
        }
    }

    private static void updateQueue(PriorityQueue<Distance> pq, int v, int d) {
        Iterator<Distance> it = pq.iterator();
        while(it.hasNext()) {
            Distance vd = it.next();
            if(vd.vertex == v) {
                it.remove();
            }
        }
        pq.add(new Distance(v, d));
    }

    private static int getEdgeDistance(Graph G, int newestVertex, int i) {
        for(Graph.Edge e : G.edges) {
            if(e.v1 == newestVertex && e.v2 == i)
                return e.w;
        }
        return Integer.MAX_VALUE;
    }
}
