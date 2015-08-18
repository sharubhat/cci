package hackerrank.sorting_test;

import java.util.*;

/**
 * Created by sharath on 8/6/15.
 */
public class MergeKSortedArrays {

    public static void sort(int[][] input) {
        PriorityQueue pq = new PriorityQueue();
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                pq.add(input[i][j]);
            }
        }
        print(pq);
    }

    private static void print(PriorityQueue pq) {
        System.out.print("[");
        while(pq.size() != 0)
            System.out.print(pq.remove() + ", ");
        System.out.println("]");
    }

    public static void main(String args[] ) throws Exception {
        Random random = new Random();

        int k = random.nextInt(10);
        int n = random.nextInt(10);

        int[][] input = new int[k][n];

        System.out.println("[");
        for(int i = 0; i < k; i++) {
            System.out.print("[");
            for(int j = 0; j < n; j++) {
                input[i][j] = random.nextInt(100);
                System.out.print(input[i][j] + ", ");
            }
            System.out.println("]");
        }
        System.out.println("]");

        sort(input);
    }
}
