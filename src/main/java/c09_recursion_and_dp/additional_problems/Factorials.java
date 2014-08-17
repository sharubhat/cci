package c09_recursion_and_dp.additional_problems;

/**
 * Created by sharath on 8/16/14.
 *
 * Problem description:
 * Factorial series is 1, 1, 2, 6, 24, 120 ...
 *
 * i.e. By definition, factorial(0) = 1
 * factorial(1) = 1 * factorial(0) = 1
 * factorial(2) = 2 * factorial(1) = 2
 * factorial(3) = 3 * factorial(2) = 6 etc
 */
public class Factorials {
    public int fact(int n){
        if(n <= 0)
            throw new IllegalArgumentException("Negative number");
        if(n == 0 || n == 1)
            return 1;
        return n * fact(n - 1);
    }

    // tail recursive factorial
    public int factTR(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("Negative number");
        return factTR(1, n, 1);
    }

    private int factTR(int start, int end, int acc) {
        if(end < start)
            return acc;
        else
            return factTR(start + 1, end, start * acc);
    }
}
