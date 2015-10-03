package hackerrank.dynamic_programming.topcoder_dp.intermediate;

/**
 * Created by sharath on 2/13/15.
 *
 * See http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709 for problem description.
 *
 * Problem Statement:
 *
 * Problem contains images. Open above link to view.
 *
 * In the city, roads are arranged in a grid pattern. Each point on the grid represents a corner where two blocks meet.
 * The points are connected by line segments which represent the various street blocks.
 * Using the cartesian coordinate system, we can assign a pair of integers to each corner as shown below.
 *
 * You are standing at the corner with coordinates 0,0. Your destination is at corner width, height.
 * You will return the number of distinct paths that lead to your destination. Each path must use exactly width+height blocks.
 * In addition, the city has declared certain street blocks un-traversable. These blocks may not be a part of any path.
 * You will be given a String[] bad describing which blocks are bad. If (quotes for clarity) "a b c d" is an element of bad,
 * it means the block from corner a,b to corner c,d is un-traversable.
 *
 * For example, let's say
 * width  = 6
 * length = 6
 * bad = {"0 0 0 1","6 6 5 6"}
 * The picture below shows the grid, with un-traversable blocks darkened in black. A sample path has been highlighted in red.
 *
 *
 * Definition
 *
 * Class:	AvoidRoads
 * Method:	numWays
 * Parameters:	int, int, String[]
 * Returns:	long
 * Method signature:	long numWays(int width, int height, String[] bad)
 * (be sure your method is public)
 *
 *
 * Constraints
 * -	width will be between 1 and 100 inclusive.
 * -	height will be between 1 and 100 inclusive.
 * -	bad will contain between 0 and 50 elements inclusive.
 * -	Each element of bad will contain between 7 and 14 characters inclusive.
 * -	Each element of the bad will be in the format "a b c d" where,
 *      a,b,c,d are integers with no extra leading zeros,
 *      a and c are between 0 and width inclusive,
 *      b and d are between 0 and height inclusive,
 *      and a,b is one block away from c,d.
 * -	The return value will be between 0 and 2^63-1 inclusive.
 *
 * Examples
 * 0)
 *
 * 6
 * 6
 * {"0 0 0 1","6 6 5 6"}
 * Returns: 252
 * Example from above.
 * 1)
 *
 * 1
 * 1
 * {}
 * Returns: 2
 * Four blocks arranged in a square. Only 2 paths allowed.
 * 2)
 *
 * 35
 * 31
 * {}
 * Returns: 6406484391866534976
 * Big number.
 * 3)
 *
 * 2
 * 2
 * {"0 0 1 0", "1 2 2 2", "1 1 2 1"}
 * Returns: 0
 *
 *
 * The implementation here involves O(mn) extra space. This can be reduced by using a 1D array to store the number of ways
 * to reach the intersection above and a variable to store the number of ways to reach previous left intersection.
 */
public class AvoidRoads {
    public static long numWays(int width, int height, String[] bad) {
        long[][] waysMatrix = new long[height+1][width+1];
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                if(i == 0 && j == 0) {
                    waysMatrix[0][0] = 1L;
                    continue;
                }
                long waysFromTop = 0L;
                long waysFromLeft = 0L;
                if(i!=0) {
                    if(traversable(i-1, j, i, j, bad))
                        waysFromTop = waysMatrix[i - 1][j];
                    else
                        waysFromTop = 0L;
                }
                if(j!=0) {
                    if(traversable(i, j-1, i, j, bad))
                        waysFromLeft = waysMatrix[i][j-1];
                    else
                        waysFromLeft = 0L;
                }
                waysMatrix[i][j] = waysFromTop + waysFromLeft;
            }
        }
        return  waysMatrix[height][width];
    }

    private static boolean traversable(int h1, int w1, int h2, int w2, String[] bad) {
        for(String b : bad) {
            String[] coordinates = b.split(" ");
            int W1 = Integer.parseInt(coordinates[0]);
            int H1 = Integer.parseInt(coordinates[1]);
            int W2 = Integer.parseInt(coordinates[2]);
            int H2 = Integer.parseInt(coordinates[3]);

            if(w1 == W1 && h1 == H1 && w2 == W2 && h2 == H2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numWays(6, 6, new String[]{"0 0 0 1","5 6 6 6"}));
        System.out.println(numWays(1, 1, new String[]{}));
        System.out.println(numWays(35, 31, new String[]{}));
        System.out.println(numWays(2, 2, new String[]{"0 0 1 0", "1 2 2 2", "1 1 2 1"}));
    }
}
