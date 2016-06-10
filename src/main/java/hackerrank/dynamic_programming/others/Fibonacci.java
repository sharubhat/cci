package hackerrank.dynamic_programming.others;

/**
 * Time complexity of recursive solution is O(2^n). Each function call in recursion is called a recursion frame.
 * Each frame takes order 1 time. So, time complexity is size of the tree which is 2^n.
 *
 * Space complexity : height of recursion tree which is O(n) - each level in recursion tree takes up one stack frame.
 *
 * A slight improvement comes from adding a cache called fib array and changing the algorithm to iterative.
 * This still has O(n) space complexity.
 *
 * Since we are only need last two fib values, we can get rid of cache and use variables to store
 * the two values which will offer constant space complexity.
 *
 * Created by sharath on 9/28/15.
 */
public class Fibonacci {
    public static long fib(int n) {
        int[] fibStore = new int[n+1];
        fibStore[0] = 0;
        fibStore[1] = 1;
        for(int i = 2; i < n+1; i++) {
            fibStore[i] = fibStore[i-1] + fibStore[i-2];
        }
        return fibStore[n];
    }

    public static long fib2(int n) {
        int result = 0;
        int fiba = 0;
        int fibb = 1;
        for(int i = 2; i < n+1; i++) {
            result = fiba + fibb;
            fiba = fibb;
            fibb = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }
}
