package hackerrank.recursion.cci;

/**
 * Given infinite number of quarters(25c), dimes(10c), nickels(5c) and pennies(1c),
 * write code to calculate the number of ways of representing n cents.
 *
 * Created by sharath on 8/17/15.
 */
public class NCents {
    private static int makeChangeR(int n,int denom) {
        int next_denom = 0;
        switch(denom) {
            case 25 :
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for(int i = 0; i*denom <= n; i++) {
            ways += makeChangeR(n - i*denom, next_denom);
        }
        return ways;
    }

    public static int makeChange(int n) {
        return makeChangeR(n, 25);
    }

    public static void main(String[] args) {
        System.out.println(makeChange(100));
    }
}
