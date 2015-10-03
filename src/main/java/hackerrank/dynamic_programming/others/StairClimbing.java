package hackerrank.dynamic_programming.others;

/**
 * A child is climbing up a stair­case with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can jump up the stairs.
 *
 * Example:
 * Number of stairs : 3
 * Number of ways = 4 ( {1,1,1}, {1,2}, {2,1}, {3} )
 *
 * Created by sharath on 9/28/15.
 */
public class StairClimbing {
    // recursive approach
    public static long possibleWays(int n) {
        if(n < 1)
            return 0;
        return 1 + possibleWays(n-1) + possibleWays(n-2)+ possibleWays(n-3);
    }

    //dp with iteration
    public static long possibleWaysDP(int n) {
        if(n < 1)
            return 0;
        int length = n < 3 ? 3 : n + 1;

        long[] dyn = new long[length];
        dyn[0] = 0L;
        dyn[1] = 1L;
        dyn[2] = 2L;

        for(int i = 3; i < n + 1; i++) {
            dyn[i] = 1 + dyn[i-1] + dyn[i-2] + dyn[i-3];
        }
        return dyn[n];
    }

    public static void main(String[] args) {
        for(int i = 0; i < 40; i++) {
            long startTime = System.currentTimeMillis();
            System.out.print("Stairs = " + i + "  Ways DP = " + possibleWaysDP(i));
            System.out.print("  Time = " + (System.currentTimeMillis() - startTime));
            startTime = System.currentTimeMillis();
            System.out.print("  Stairs = " + i + " Ways Rec = " + possibleWays(i));
            System.out.println("  Time = " + (System.currentTimeMillis() - startTime));
        }
    }
}
