package hackerrank.graphs_and_other_ds.epi;

import java.util.*;

/**
 * EPI problem 19.11
 *
 * Created by sharath on 6/5/16.
 */
public class ShortestPathWithFewestEdges {
    public static void dijkstraShortestPath(GVertex s, GVertex t) {
        // Initialize distance of starting vertex s
        s.distanceWithFewestEdges.distance = 0;
        SortedSet<GVertex> nodeSet = new TreeSet<>();
        nodeSet.add(s);

        while(!nodeSet.isEmpty()) {
            // Extract the min dist vertex from heap
            GVertex u = nodeSet.first();
            if (u.equals(t)) {
                break;
            }
            nodeSet.remove(nodeSet.first());

            // relax neighbouring vertices of u
            for(GVertex v : u.edges) {
                int vDist = u.distanceWithFewestEdges.distance + v.dist;
                int vNumEdges = u.distanceWithFewestEdges.minNumEdges + 1;
                if(v.distanceWithFewestEdges.distance > vDist ||
                            (v.distanceWithFewestEdges.distance == vDist &&
                                v.distanceWithFewestEdges.minNumEdges > vNumEdges)
                        ) {
                    // it's difficult to update the tree set, easier to just remove it, and add it back(if exists)
                    nodeSet.remove(v);
                    v.pred = u;
                    v.distanceWithFewestEdges = new DistanceWithFewestEdges(vDist, vNumEdges);
                    nodeSet.add(v);
                }
            }
        }
        outputShortestPath(t);
    }

    private static void outputShortestPath(GVertex v) {
        if(v != null) {
            outputShortestPath(v.pred);
            System.out.println(v.id + " ");
        }
    }

    static class GVertex implements Comparable<GVertex> {
        // every graph node should be initialized with infinite distance and zero edges
        DistanceWithFewestEdges distanceWithFewestEdges = new DistanceWithFewestEdges(Integer.MAX_VALUE, 0);
        //
        Integer dist;
        public List<GVertex> edges = new ArrayList<>();
        public int id;
        public GVertex pred = null;

        /*
            First compare shortest distance. If there are more than one path to reach the current vertex,
            look at minimum number of edges needed to reach it.
         */
        @Override
        public int compareTo(GVertex that) {
            int res = this.distanceWithFewestEdges.distance.compareTo(
                       that.distanceWithFewestEdges.distance);
            if(res == 0)
                res = this.distanceWithFewestEdges.minNumEdges.compareTo(
                        that.distanceWithFewestEdges.minNumEdges);

            return res;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || !(obj instanceof GVertex))
                return false;
            GVertex that = (GVertex) obj;
            return this.distanceWithFewestEdges.distance.equals(
                    that.distanceWithFewestEdges.distance)
                    && this.distanceWithFewestEdges.minNumEdges.equals(
                            that.distanceWithFewestEdges.minNumEdges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.distanceWithFewestEdges.distance,
                                this.distanceWithFewestEdges.minNumEdges);
        }
    }

    static class DistanceWithFewestEdges {
        Integer distance;
        Integer minNumEdges;

        public DistanceWithFewestEdges(Integer distance, Integer minNumEdges) {
            this.distance = distance;
            this.minNumEdges = minNumEdges;
        }
    }
}
