package hackerrank.dynamic_programming.epi;

import java.util.Arrays;

/**
 * Count the number of ways to traverse a 2D array.
 *
 * Do the same when there are obstacles.
 *
 * Created by sharath on 11/17/15.
 */
public class Traversing2DArray {
    public static void main(String[] args) {
        System.out.println(ways(5));
        System.out.println(allPossibleWaysIterative(5));
        System.out.println(betterIterativeWay(5));
    }

    /**
     * Look at hackerrank.recursion.cci.RobotInMatrix for other recursive solution.
     *
     * @param n
     * @return
     */
    public static int ways(int n) {
        return waysRec(n, n);
    }

    private static int waysRec(int x, int y) {
        if(x < 1 || y < 1)
            return 0;
        else if(x == 1 || y == 1)
            return 1;
        return waysRec(x - 1, y) + waysRec(x, y - 1);
    }

    public static int allPossibleWaysIterative(int n) {
        int[][] cache = new int[n][n];
        for(int i = 0; i < n; i++) {
            cache[0][i] = 1;
            cache[i][0] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                cache[i][j] = cache[i-1][j] + cache[i][j-1];
            }
        }
        return cache[n-1][n-1];
    }

    /**
     * Solution above can be further improved for a better space complexity.
     * At a given row, we are only making use of the values in row before it and a value to it's left at each cell.
     *
     * Time complexity is O(n^2) and space complexity is O(n)
     */
    public static int betterIterativeWay(int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                cache[j] = cache[j - 1] + cache[j];
            }
        }
        return cache[n-1];
    }
}
