package hackerrank.dynamic_programming.others;

import java.util.*;

/**
 * Given an input array find all sub arrays with given sum K
 *
 * Created by sharath on 11/7/15.
 */
public class SubArraySumK {

    private static boolean hasSumK(int[] IntArr, int iTarget) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);
        int preSum = 0;

        for(int i=0; i< IntArr.length; i++) {
            preSum += IntArr[i];
            if(map.containsKey(preSum - iTarget)) {
                return true;
            }

            List<Integer> newStart = new ArrayList<>();
            if(map.containsKey(preSum)) {
                newStart = map.get(preSum);
            }
            newStart.add(i);
            map.put(preSum, newStart);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] INPUT = {5, 6, 1, -2, -4, 3, 1, 5};
        printSubarrays(INPUT, 5);
    }

    /**
     * Explanation:
     * Brute force approach is to find every subarray starting at every index, find the sum and compare it with K.
     * This has quadratic running time.
     *
     * Consider building an auxiliary array that contains prefix sum (sum of all elements from 0th index to current).
     * For given example, we would get {5, 11, 12, 10, 6, 9, 10, 15}
     * If there is a subarray ending at 'i' that sums to K, then A[i] - sum should be in between A[0] and A[i].
     * Given that there can be multiple subarrays and we are trying to find all of them, finding A[j] with j < i
     * will run in linear time. When this runs for every A[i], it becomes quadratic.
     * In given example, at index 7, 15-5=10. There are two A[j]'s that have sum 10, which means two subarrays.
     *
     * We could do better by building a cache that holds prefix sum as key and all indices which have that sum as value.
     * This would result in constant time to fetch all A[j]s such that A[j] to A[i] is a subarray with sum K.
     * For given example, it would be
     * 0=[-1],
     * 5=[0],
     * 11=[1],
     * 12=[2],
     * 10=[3, 6],
     * 6=[4],
     * 9=[5],
     * 15=[7]
     * Note that the sub array would start one index next to A[i]-K.
     *
     * @param input
     * @param k
     */
    private static void printSubarrays(int[] input, int k) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        List<Integer> newStart = new ArrayList<>();
        newStart.add(-1);
        int prefixSum = 0;
        map.put(prefixSum, newStart);

        // Loop across all elements of the array
        for(int i=0; i< input.length; i++) {
            prefixSum += input[i];
            // If point where sum = (preSum - k) is present, it means that between that
            // point and this, the sum has to equal k
            if(map.containsKey(prefixSum - k)) {   // Subarray found
                List<Integer> startIndices = map.get(prefixSum - k);
                for(int start : startIndices) {
                    System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
                }
            }

            newStart = new ArrayList<>();
            if(map.containsKey(prefixSum)) {
                newStart = map.get(prefixSum);
            }
            newStart.add(i);
            map.put(prefixSum, newStart);
        }
        System.out.println(map);
    }
}
