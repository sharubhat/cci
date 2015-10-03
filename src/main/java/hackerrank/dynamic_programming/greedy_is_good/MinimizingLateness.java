package hackerrank.dynamic_programming.greedy_is_good;

/**
 * Problem:
 *
 * Consider a situation in which we have a single resource and a set of n
 * requests to use the resource for an interval of time. Assume that the resource is
 * available starting at time s. In contrast to the previous problem(interval partitioning), however, each
 * request is now more flexible. Instead of a start time and finish time, the request
 * i has a deadline di, and it requires a contiguous time interval of length ti, but
 * it is willing to be scheduled at any time before the deadline. Each accepted
 * request must be assigned an interval of time of length ti, and different requests
 * must be assigned non-overlapping intervals.
 *
 * Approaches:
 * 1. Schedule jobs in the order of increasing length t, so as to get short jobs out of the way quickly.
 *    This ignores deadlines, so fails.
 * 2. Based on 1, we can improve by considering the slack time d-t. The ones with minimum slack time
 *    must be started immediately. This also fails. Read Algorithm Design by Jon Keinberg for details.
 * 3. Sort the jobs in increasing order of deadlines which means jobs with earliest deadlines must be completed first.
 *    This always produces optimal solution as it never looks at the length of the jobs.
 *
 * Created by sharath on 9/24/15.
 */
public class MinimizingLateness {
    private static class Request {
        int d; // deadline
        int t; // time of length for the request

        public Request(int d, int t) {
            this.d = d;
            this.t = t;
        }
    }

    private static class Resource {
        int s;

        public Resource(int s) {
            this.s = s;
        }
    }

    public static void main(String[] args) {
        int s = 2;
        int[] t = {1, 2, 3};
        int[] d = {2, 4, 6};

//        System.out.println(minResourcesRequired(s, t));
    }
}
