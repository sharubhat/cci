package hackerrank.arrays_strings_and_everything.classroom;

/**
 * Created by sharath on 8/28/14.
 * Problem description:
 * There are two problems here.
 * 1. Finding largest sum of contiguous sub array, which can be solved in O(n) by using Kadane's algorithm
 * 2. Printing the sub array that results in largest sum.
 * We are only solving the first problem here.
 * Similarly, the problem can be solved for smallest sub array.
 * Brute force way of solving is to find every subarray and get the individual sum and compare. This would be O(n^3) solution.
 * This can be improved to O(n^2) by reducing few of the computations to calculate subarray sum giving O(n^2) solution.
 * The solution can be further improved by divide and conquer which improves the time complexity to O(nlogn).
 * The best solution available is called Kaden's algorithm which solves the problem in linear time - O(n).
 * P.S: Kadane's algo is an example of dynamic programming
 */
public class SumContiguousSubArray {
    public int KadaneSum(int[] in) {
        if (in.length == 0)
            return 0;
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int i : in) {
            // maxEndingHere + i can be less than i iff maxEndingHere is = 0
            // Note that maxEndingHere can't be less than 0
            // So the max at this point can be i or maxEndingHere + i
            maxEndingHere = Math.max(i, maxEndingHere + i);

            // maxSoFar can be either a subarray that was discovered previously
            // or the current subarray who's maxEndingHere is more than previous max
            // and it's time to update the sum value
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        // case of all negative numbers
        if (maxSoFar == 0)
            return checkMaxOfAllNegetives(in);
        return maxSoFar;
    }

    private int checkMaxOfAllNegetives(int[] in) {
        int max = Integer.MIN_VALUE;
        for (int i : in) {
            if (max < i)
                max = i;
        }
        return max;
    }

    // Solution can be further improved by divide and conquer.
    private static int findMaxSumDC(int[] in) {
        return findMaxSumDCRec(in, 0, in.length - 1);
    }

    private static int findMaxSumDCRec(int[] in, int i, int j) {
        if(i < j) {

            int m = i + (j - i) / 2;
            int leftMSS = findMaxSumDCRec(in, i, m);
            int rightMSS = findMaxSumDCRec(in, m + 1, j);
            int leftSum = Integer.MIN_VALUE;
            int rightSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int k = m + 1; k <= j; k++) {
                sum += in[k];
                rightSum = Math.max(sum, rightSum);
            }
            sum = 0;
            for (int k = m; k >= i; k--) {
                sum += in[k];
                leftSum = Math.max(sum, leftSum);
            }
            int answer = Math.max(leftMSS, rightMSS);
            return Math.max(answer, leftSum + rightSum);
        }
        return 0;
    }

    // A slightly optimized solution which runs in O(n^2).
    // We can improve brute force by reducing few of the calculations.
    // i.e., instead of calculating sum of subarry each time from startIndex, we can use the previously calculated sum
    // and add element at current index.
    private static int findMaxSumBFImproved(int[] in) {
        int answer = Integer.MIN_VALUE;
        for (int startIndex = 0; startIndex < in.length; startIndex++) {
            int sum = 0;
            for (int subArraySize = 1; subArraySize <= in.length; subArraySize++) {
                if (startIndex + subArraySize > in.length)
                    break;
                sum += in[startIndex + subArraySize - 1]; // last element of new subarray
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }


    // Brute force solution - O(n^3) time complexity
    private static int findMaxSumBF(int[] in) {
        int answer = Integer.MIN_VALUE;
        for (int subArraySize = 1; subArraySize <= in.length; subArraySize++) {
            for (int startIndex = 0; startIndex < in.length; startIndex++) {
                if (startIndex + subArraySize > in.length)
                    break;
                int sum = 0;
                for (int i = startIndex; i < startIndex + subArraySize; i++) {
                    sum += in[i];
                }
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumBF(new int[]{-1, 2, 3, -3, 4}));
        System.out.println(findMaxSumBFImproved(new int[]{-1, 2, 3, -3, 4}));
        System.out.println(findMaxSumDC(new int[]{-1, 2, 3, -3, 4}));
        System.out.println(new SumContiguousSubArray().KadaneSum(new int[]{-1, 2, 3, -3, 4}));
    }
}
