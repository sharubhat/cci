package hackerrank.sorting_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of unsorted numbers, find the pair of numbers that has the smallest absolute difference between
 * it's elements. If there are multiple pairs that have the same absolute distance as the minium, find them all.
 *
 * Output the pair of numbers with smallest difference separated by a space. If there are multiple pairs, output
 * them all in ascending order, all on the same line, with a single space between each pair.
 *
 * Solution : This is a problem where sorting simplifies the problem to a great extent.
 * Overall time complexity is O(nlogn) for sorting + O(n) for finding closest numbers.
 * Overall space complexity is O(n) - could be O(2n) if all numbers are placed equi-distant from each other.
 *
 * Created by sharath on 1/2/16.
 */
public class ClosestNumbers {
    public static void main(String[] args) {
        int[] a1 = {-20, -3916237, -357920, -3620601, 7374819, -7334819, -7330761, 30, 6246457,
                        -6461594, 266854};
        System.out.println(closestNumbers(a1));
    }

    private static List<Integer> closestNumbers(int[] a) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        List<Integer> minDiffs = new ArrayList<>();
        for(int i = 1; i < a.length; i++) {
            if((a[i] - a[i-1]) < min) {
                min = a[i] - a[i-1];
                minDiffs = new ArrayList<>();
                minDiffs.add(a[i-1]);
                minDiffs.add(a[i]);
            } else if ((a[i] - a[i-1]) == min) {
                minDiffs.add(a[i-1]);
                minDiffs.add(a[i]);
            }
        }
        return minDiffs;
    }
}
