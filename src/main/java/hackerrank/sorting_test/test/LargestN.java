package hackerrank.sorting_test.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sharath on 8/11/15.
 */
public class LargestN {
    static int[] topK(int[] iStream, int iK) {
        Comparator comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return -(i1.compareTo(i2));
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(iK, comp);

        for (Integer i : iStream) {
            pq.add(i);
        }

        int[] result = new int[iK];
        for (int i = 0; i < iK; i++) {
            if (!pq.isEmpty()) {
                result[i] = pq.remove();
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] in = {1
                , 23,
                12,
                9,
                30,
                2,
                50,
        };
        System.out.println(Arrays.toString(topK(in, 2)));
    }
}
