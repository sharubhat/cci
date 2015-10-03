package hackerrank.dynamic_programming.others;

/**
 * Created by sharath on 9/28/15.
 */
public class Fibonacci {
    public long fib(int n) {
        int[] fibStore = new int[n+1];
        fibStore[0] = 0;
        fibStore[1] = 1;
        for(int i = 2; i < n+1; i++) {
            fibStore[i] = fibStore[i-1] + fibStore[i-2];
        }
        return fibStore[n];
    }

    // saving on space
//    public long fibonacci(int n) {
//
//    }
}
