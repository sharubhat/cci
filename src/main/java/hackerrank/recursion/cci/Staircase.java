package hackerrank.recursion.cci;

/**
 * CCI book, problem 9.2
 *
 * T(N) = O(3^N) as the recursive calls take 3 branches at each level and height of the tree is N
 * Created by sharath on 8/15/15.
 */
public class Staircase {
    public static void main(String[] args) {
        System.out.println(countSteps(6));
    }

    // reaching last step is either of the following
    // 1. one step of one hop plus number of steps to reach n-1 steps.
    // 2. one step of two hops plus number of steps to reach n-2 steps.
    // 3. one step of three hops plus number of steps to reach n-3 steps.
    // So total number of steps is sum of all three possibilities.
    public static int countSteps(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return countSteps(n - 1) + countSteps(n - 2) + countSteps(n -3);
    }
}
