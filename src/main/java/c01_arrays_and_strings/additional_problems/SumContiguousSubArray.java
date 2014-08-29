package c01_arrays_and_strings.additional_problems;

/**
 * Created by sharath on 8/28/14.
 *
 * Problem description:
 * There are two problems here.
 * 1. Finding largest sum of contiguous sub array, which can be solved in O(n) by using Kadane's algorithm
 * 2. Printing the sub array that results in largest sum.
 *
 * Similarly, the problem can be solved for smallest sub array.
 *
 * P.S: Kadane's algo is an example of dynamic programming
 *
 */
public class SumContiguousSubArray {
    public int KadaneSum(int[] in) {
        if(in.length == 0)
            return 0;
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for(int i : in) {
            maxEndingHere = Math.max(i, maxEndingHere + i);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        // case of all negative numbers
        if(maxSoFar == 0)
            return checkMaxOfAllNegetives(in);
        return maxSoFar;
    }

    private int checkMaxOfAllNegetives(int[] in) {
        int max = Integer.MIN_VALUE;
        for(int i : in) {
            if(max < i)
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        new SumContiguousSubArray().KadaneSum(new int[]{-1, 2, 3, -3, 4});
    }
}
