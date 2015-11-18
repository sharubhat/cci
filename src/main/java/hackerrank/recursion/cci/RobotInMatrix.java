package hackerrank.recursion.cci;

/**
 * Calculate number of possible paths for robot to move from left top to right bottom in X by Y matrix.
 * 
 * We need to count number of ways of making a path with X right steps and Y down steps. Any path will have X+Y steps.
 * 
 * To build a path, we essentially move X times to right out of X+Y. Thus number of paths must be number of ways of
 * selecting X items out of X+Y which is given by a binomial expression n choose r
 * (n)      n!
 * ( ) = --------
 * (r)   r!(n-r)!
 * 
 * So this problems turns out to
 * 
 * (X+Y)   (X+Y)!
 * (   ) = ------
 * ( X )    X!Y!
 * 
 * 
 * This is one way of solving. Other way is through recursion as in program below.
 * 
 * Created by sharath on 8/15/15.
 */
public class RobotInMatrix {
    private static long fact(int n) {
        long fact = 1L;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int numWays(int X, int Y) {
        return doWays(0, 0, X-1, Y-1);
    }

    public static int doWays(int x_now, int y_now, int X, int Y) {
        if (x_now > X || y_now > Y) return 0;
        if (x_now == X && y_now == Y) return 1;

        return doWays(x_now + 1, y_now, X, Y) + doWays(x_now, y_now + 1, X, Y);
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        System.out.println(numWays(x, y));
        System.out.println(fact(x-1 + y-1) / (fact(x-1) * fact(y-1)));
    }
}
