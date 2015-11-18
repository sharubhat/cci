package hackerrank.dynamic_programming.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find a subarray such that sum of all it's elements results in maximum sum of all the subarrays.
 *
 * A simpler variant is to find max sum.
 *
 * Created by sharath on 11/16/15.
 */
public class MaxSumSubarray {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(new Integer[]{904, 40, 523, 12, -335, -385, -124, -481, -31});
        System.out.println("Max sum : " + maxSum(input));
        System.out.println(maxSumSubarray(input));

        input = Arrays.asList(new Integer[]{-7, 10, 9, 2, -24, 25, -5});
        System.out.println("Max sum : " + maxSum(input));
        System.out.println(maxSumSubarray(input));
    }

    public static List<Integer> maxSumSubarray(List<Integer> array) {
        List<Integer> sums = new ArrayList<>();
        int maxSoFar = array.get(0);
        sums.add(array.get(0));

        int begin = 0;
        int end = 0;

        for(int i = 1; i < array.size(); i++) {
            int newBegin = begin;
            int prefixSum = sums.get(i-1);
            int curr = array.get(i);
            // if prefix sum is negative, it means we need to start over again.
            // there is no way we can achieve a bigger sum by including a subarray that yields negative sum.
            if(prefixSum < 0) {
                sums.add(curr);
                newBegin = i;
            } else {
                sums.add(prefixSum + curr);
            }
            if(sums.get(i) > maxSoFar) {
                maxSoFar = sums.get(i);
                begin = newBegin;
                end = i;
            }
        }
        System.out.println(sums);
        return new ArrayList<>(array.subList(begin, end + 1));
    }

    public static int maxSum(List<Integer> array) {
        int sum = 0;
        int maxSum = 0;
        for(Integer i : array) {
            sum = Math.max(i, sum + i);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
