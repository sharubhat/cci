package c09_recursion_and_dp.recursion;

/**
 * Created by sharath on 8/16/14.
 *
 * Problem description:
 * Find the nth term in the series 1, 3, 6, 10, 15, 21 ...
 * These are called triangular numbers because they can be
 * visualized as triangular arrangement of objects.
 *                                  1
 *                          1       11
 *                  1       11      111
 *          1       11      111     1111
 *   1      11      111     1111    11111
 *  --------------------------------------
 *  #1=1    #2=3    #3=3    #4=10   #5=15
 *  --------------------------------------
 *
 * The nth term in the series is obtained by adding n to the previous term.
 * Thus, the second term is found by adding 2 to the first term (which is 1), giving 3.
 * The third term is 3 added to the second term (which is 3) giving 6, and so on.
 *
 */
public class TriangularNumbers {
    public int nthTNumber(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("Only positive numbers are accepted.");
        if(n == 1)
            return 1;
        return n + nthTNumber(n - 1);
    }

    // tail recursion technique.
    // This is just for understanding. Java does not optimize tail recursion like Scala
    public int nthTNum(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("Only positive numbers are accepted.");
        return nthTNum(0, n, 0);
    }

    private int nthTNum(int start, int end, int acc) {
        if(start > end)
            return acc;
        else
            return nthTNum(start + 1, end, start + acc);
    }
}
