package hackerrank.sorting_test.test;

import java.util.Arrays;
import java.util.Collections;
// import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Multiple approaches can be taken to solve this simple problem.
 * 1. Modify Bubble sorting to run the outer loop only k times - O(kn) time complexity.
 * 2. Sort the elements - O(nlogn) time complexity.
 * 3. Use max heap and then extract top k elements. O(nlogn) time to build and O(klogn) time to extract.
 * 4. An optimization to step 3 is to use a min heap and add first k elements.
 *      After that, compare each element with top element and if it's greater, remove the top and add current element.
 *      Time complexity can still be as bad as O(nlogn+klogn).
 * Created by sharath on 8/11/15.
 */
public class LargestN {
    static int[] topK(int[] iStream, int iK) {
        /*
         Natural ordering comparator results in a priority queue where head element is the least of all.
         To achieve the reverse ordering, implement an comparator that reverses the natural ordering.

         Comparator comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return -(i1.compareTo(i2));
            }
         };

         PriorityQueue<Integer> pq = new PriorityQueue<>(iK, comp);

         Edit : Collections.reverseOrder() returns a comparator that reverses the natural ordering
                avoiding implementation of a comparator.

         Note: reverseOrder() is also overloaded to take a comparator - reverseOrder(Comparator<T> cmp),
               so it works even if you are comparing custom objects.
          */

        PriorityQueue<Integer> pq = new PriorityQueue<>(iK, Collections.reverseOrder());

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
