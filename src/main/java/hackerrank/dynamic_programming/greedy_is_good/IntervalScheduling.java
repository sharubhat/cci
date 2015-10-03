package hackerrank.dynamic_programming.greedy_is_good;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * We have a set of requests {1, 2, . . . , n}; the ith request corresponds to an interval of time starting at s(i)
 * and finishing at f(i). We’ll say that a subset of the requests is compatible if no two of them overlap in time,
 * and our goal is to accept as large a compatible subset as possible.
 * Compatible sets of maximum size will be called optimal.
 *
 * Problem: Given a set of requests, find the optimal schedule intervals.
 *
 * There are 4 greedy approaches.
 * 1. Select the interval that starts the first. This way, our resource starts being used as early as possible.
 * 2. Since first approach does not yield optimal solution, we may say, lets use the intervals that use shortest time.
 * 3. Again, we may not get the optimal solution. So we could design a greedy algorithm that is based on this idea:
 * for each request, we count the number of other requests that are not compatible, and accept the request that has
 * the fewest number of non-compatible requests.
 * 4. We should choose the intervals that free the resources as early as possible. It can be proved that this approach
 * gives the optimal solution. Read Algorithm design by Jon Kleinberg.
 *
 * Solution :
 *
 * Initially let R be the set of all requests, and let A be empty
 * While R is not yet empty
 *      Choose a request i ∈ R that has the smallest finishing time
 *      Add request i to A
 *      Delete all requests from R that are not compatible with request i
 * EndWhile
 * Return the set A as the set of accepted requests
 *
 *
 * Constraint:
 * 1 <= N <= 100000
 * 1 <= si < ti <= 10^9
 *
 * Sample input:
 * N = 5
 * s = {1, 2, 4, 6, 8}
 * t = {3, 5, 7, 9, 10}
 *
 * Sample output:
 * 3
 *
 * Created by sharath on 9/21/15.
 */
public class IntervalScheduling {
    private static class Interval {
        int id, start, finish;

        public Interval(int id, int start, int finish) {
            this.id = id;
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

    private static Interval findIWithEarliestFinish(Set<Interval> R) {
        Iterator<Interval> it = R.iterator();
        Interval earliestFinish = it.next();
        while(it.hasNext()) {
            Interval curr = it.next();
            if(earliestFinish.finish >= curr.finish) {
                earliestFinish = curr;
            }
        }
        return earliestFinish;
    }

    public static int optimalScheduling(int[] start, int[] finish) {
        Set<Interval> R = createIntervalSet(start, finish);
        Set<Interval> A =  new HashSet<>();
        while(!R.isEmpty()) {
            Interval i = findIWithEarliestFinish(R);
            A.add(i);
            deleteNonCompatibleRequestsFromR(R, i);
        }
        return A.size();
    }

    private static void deleteNonCompatibleRequestsFromR(Set<Interval> r, Interval i) {
        for (Iterator<Interval> it = r.iterator(); it.hasNext();) {
            Interval curr = it.next();
            if(curr.start <= i.finish)
                it.remove();
        }
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 4, 6, 8};
        int[] t = {3, 5, 7, 9, 10};

        System.out.println(optimalScheduling(s, t));
    }
}
