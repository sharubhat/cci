package hackerrank.dynamic_programming.cci;

import java.util.Arrays;

/**
 * CCI book, problem 9.2, solved using memoization
 *
 * T(N) = O(3^N) as the recursive calls take 3 branches at each level and height of the tree is N
 *
 * Created by sharath on 6/7/16.
 */
public class Staircase {
    public static void main(String[] args) {
        System.out.println(countSteps(6));
    }

    public static int countSteps(int n) {
        int[] memo = new int[n + 1];
        // count of 1 for 0 stairs doesn't make sense but it makes calculation easier.
        // so initialize a memo with 0th element as 1 and rest of them as -1.
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return countSteps(n, memo);
    }

    private static int countSteps(int n, int[] memo) {
        if(n < 0)
            return 0;
        if(memo[n] > -1)
            return memo[n];
        memo[n] = countSteps(n-1, memo) + countSteps(n-2, memo) + countSteps(n-3, memo);
        return memo[n];
    }
}
