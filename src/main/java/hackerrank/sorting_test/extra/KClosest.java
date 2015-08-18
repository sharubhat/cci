package hackerrank.sorting_test.extra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array containing N(x,y) points, find the K closest points to the origin in the 2D plane.
 * You can assume K is much smaller than N and N is very large.
 *
 * Created by sharath on 8/11/15.
 */
public class KClosest {
    public static class Point {
        public double x;
        public double y;

        public Point(final double x, final double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return new String("(" + x + ", " + y + ")");
        }
    }

    public static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            Double rad1 = Math.sqrt((o1.x * o1.x) + (o1.y * o1.y));
            Double rad2 = Math.sqrt((o2.x * o2.x) + (o2.y * o2.y));

            if(rad1 < rad2)
                return 1;
            else if(rad1 > rad2)
                return -1;
            else
                return 0;
        }
    }

    public static Point[] closestk(final Point points[], final int k) {
        PointComparator pqc = new PointComparator();
        PriorityQueue<Point> pq = new PriorityQueue(k, pqc);

        for(int i = 0; i < points.length; i++) {
            if(pq.size() < k) {
                pq.add(points[i]);
            } else {
                if(pqc.compare(points[i], pq.peek()) > 0) {
                    pq.remove();
                    pq.add(points[i]);
                }
            }
        }

        Point[] result = new Point[k];
        int index = 0;
        while(pq.size() > 0) {
            result[index++] = pq.remove();
        }

        return result;
    }

    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Point[] p = {new Point(1,1), new Point(3,1), new Point(1,3), new Point(3,3),
                new Point(2,1), new Point(6,6), new Point(7, 8), new Point(10,1)};

        System.out.println(Arrays.toString(closestk(p, 3)));
    }
}
