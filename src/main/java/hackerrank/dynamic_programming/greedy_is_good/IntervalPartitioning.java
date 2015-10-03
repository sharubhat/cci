package hackerrank.dynamic_programming.greedy_is_good;

import java.util.*;

/**
 * Unlike a single resource in interval scheduling, interval partitioning problem deals with multiple resource
 * and the problem is to schedule all the requests using as few resources as possible.
 *
 * Solution:
 *
 * Let R be the set of all requests
 * Let resources be list of resources
 *
 * while !R.empty():
 *   Choose a request i ∈ R that has the earliest start time
 *   if i cannot be assigned to some resource already in resources
 * 	   create a new resource and add it to resources list
 *   remove i from R
 *
 * return number of resources in the list resources.
 *
 * Created by sharath on 9/22/15.
 */
public class IntervalPartitioning {
    private static class Interval {
        int id, start, finish;

        public Interval(int id, int start, int finish) {
            this.id = id;
            this.start = start;
            this.finish = finish;
        }
    }

    private static class Resource {
        int start, finish;

        public Resource(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static Set<Interval> createIntervalSet(int[] start, int[] finish) {
        Set<Interval> R = new HashSet<>();
        for(int i = 0; i < start.length; i++) {
            R.add(new Interval(i, start[i], finish[i]));
        }
        return R;
    }

    private static Interval findIWithEarliestStartTime(Set<Interval> R) {
        Iterator<Interval> it = R.iterator();
        Interval earliestStart = it.next();
        while(it.hasNext()) {
            Interval curr = it.next();
            if(earliestStart.start >= curr.start) {
                earliestStart = curr;
            }
        }
        return earliestStart;
    }

    private static Resource assignIToResource(Interval i, List<Resource> resources) {
        for(Resource r : resources) {
            if(r.finish <= i.start) {
                r.finish = i.finish;
                return r;
            }
        }
        return null;
    }

    public static int minResourcesRequired(int[] start, int[] finish) {
        Set<Interval> R = createIntervalSet(start, finish);
        List<Resource> resources = new ArrayList<>();
        while(!R.isEmpty()) {
            Interval i = findIWithEarliestStartTime(R);
            if(assignIToResource(i, resources) == null) {
                Resource resource = new Resource(i.start, i.finish);
                resources.add(resource);
            }
            R.remove(i);
        }
        return resources.size();
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3};
        int[] t = {3, 4, 5};

        System.out.println(minResourcesRequired(s, t));
    }
}
