package c09_recursion_and_dp.recursion;

/**
 * Problem definition
 * gcd(m, n) = n if n is a divisor of m
 * gcd(m, n) = gcd(n, m % n) if n isn't a divisor of m
 *
 * Created by sharath on 9/9/14.
 */
public class GCD {
    // pre-condition : m and n are > 0
    public double gcd(int m, int n) {
        if(m % n == 0)
            return n;
        else if(m < n) {
            return gcd(n, m);
        } else {
            return gcd(n, m % n);
        }
    }
}
