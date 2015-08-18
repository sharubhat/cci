package c09_recursion_and_dp.dynamic_programming;

/**
 * Created by sharath on 7/20/15.
 */
public class Fibonacci {

    public long fibonacci(int n) {
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fib(int n) {
        long[] fibs = new long[n + 1];
        fibs[1] = 1L;
        fibs[2] = 1L;
        for(int i = 3; i < fibs.length; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(120));
        System.out.println(f.fibonacci(120));
    }
}
