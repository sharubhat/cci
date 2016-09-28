package hackerrank.graphs_and_other_ds.epi;

import java.util.*;

/**
 * EPI problem 19.10
 *
 * Problem is extension of team photo day in sorting. There are more than 2 teams and photographer
 * needs help in deciding the largest number of teams that can be photographed in a single frame.
 *
 * Hint: Think of teams as nodes in a DAG, edge from A to B meaning A can be placed in front of B.
 * Find the topological sort order for the teams and find out the length of longest connected component.
 *
 * Created by sharath on 6/5/16.
 */
public class TeamPhotoDay {
    // team is nothing but node in DAG
    public static class Team {
        public List<Team> adj = new ArrayList<>();
        public int maxDistance = 1;
        public boolean visited = false;
    }

    // longest connected component in the topological ordering
    public static int findLargestNumberTeams (List<Team> G) {
        Deque<Team> orderedVertices = buildTopologicalOrdering(G);
        return findLongestPath(orderedVertices);
    }

    private static Deque<Team> buildTopologicalOrdering(List<Team> G) {
        Deque<Team> orderedVertices = new LinkedList<>();
        // run DFS on every node and add them to a Deque
        for(Team g : G) {
            if(!g.visited) {
                DFS(g, orderedVertices);
            }
        }
        return orderedVertices;
    }

    private static void DFS(Team cur, Deque<Team> orderedVertices) {
        cur.visited = true;
        for(Team g: cur.adj) {
            if(!g.visited) {
                DFS(g, orderedVertices);
            }
        }
        orderedVertices.addFirst(cur);
    }

    private static int findLongestPath(Deque<Team> orderedVertices) {
        int maxDist = 0;
        while(!orderedVertices.isEmpty()) {
            Team u = orderedVertices.peekFirst();
            maxDist = Math.max(maxDist, u.maxDistance);
            for(Team v : u.adj) {
                v.maxDistance = Math.max(maxDist, u.maxDistance + 1);
            }
            orderedVertices.removeFirst();
        }
        return maxDist;
    }
}


