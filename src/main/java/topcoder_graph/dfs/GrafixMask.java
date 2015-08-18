package topcoder_graph.dfs;

import java.util.*;

/**
 * Problem description
 * <p/>
 * http://community.topcoder.com/stat?c=problem_statement&pm=2998&rd=5857
 * <p/>
 * Problem Statement
 * <p/>
 * Note: This problem statement includes images that may not appear if you are using a plugin. For best results, use the Arena editor.
 * <p/>
 * In one mode of the grafix software package, the user blocks off portions of a masking layer using opaque rectangles. The bitmap used as the masking layer is 400 pixels tall and 600 pixels wide. Once the rectangles have been blocked off, the user can perform painting actions through the remaining areas of the masking layer, known as holes. To be precise, each hole is a maximal collection of contiguous pixels that are not covered by any of the opaque rectangles. Two pixels are contiguous if they share an edge, and contiguity is transitive.
 * <p/>
 * You are given a String[] named rectangles, the elements of which specify the rectangles that have been blocked off in the masking layer. Each String in rectangles consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the window coordinates of the top left pixel in the given rectangle, and the last two integers are the window coordinates of its bottom right pixel. The window coordinates of a pixel are a pair of integers specifying the row number and column number of the pixel, in that order. Rows are numbered from top to bottom, starting with 0 and ending with 399. Columns are numbered from left to right, starting with 0 and ending with 599. Every pixel within and along the border of the rectangle defined by these opposing corners is blocked off.
 * <p/>
 * Return a int[] containing the area, in pixels, of every hole in the resulting masking area, sorted from smallest area to greatest.
 * <p/>
 * <p/>
 * Definition
 * <p/>
 * Class:	grafixMask
 * Method:	sortedAreas
 * Parameters:	String[]
 * Returns:	int[]
 * Method signature:	int[] sortedAreas(String[] rectangles)
 * (be sure your method is public)
 * <p/>
 * <p/>
 * Notes
 * -	Window coordinates are not the same as Cartesian coordinates. Follow the definition given in the second paragraph of the problem statement.
 * <p/>
 * Constraints
 * -	rectangles contains between 1 and 50 elements, inclusive
 * -	each element of rectangles has the form "ROW COL ROW COL", where: "ROW" is a placeholder for a non-zero-padded integer between 0 and 399, inclusive; "COL" is a placeholder for a non-zero-padded integer between 0 and 599, inclusive; the first row number is no greater than the second row number; the first column number is no greater than the second column number
 * <p/>
 * Examples
 * 0)
 * <p/>
 * {"0 292 399 307"}
 * Returns: { 116800,  116800 }
 * The masking layer is depicted below in a 1:4 scale diagram.
 * <p/>
 * 1)
 * <p/>
 * {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"}
 * Returns: { 22816,  192608 }
 * <p/>
 * 2)
 * <p/>
 * {"0 192 399 207", "0 392 399 407", "120 0 135 599", "260 0 275 599"}
 * Returns: { 22080,  22816,  22816,  23040,  23040,  23808,  23808,  23808,  23808 }
 * <p/>
 * 3)
 * <p/>
 * {"50 300 199 300", "201 300 350 300", "200 50 200 299", "200 301 200 550"}
 * Returns: { 1,  239199 }
 * 4)
 * <p/>
 * {"0 20 399 20", "0 44 399 44", "0 68 399 68", "0 92 399 92",
 * "0 116 399 116", "0 140 399 140", "0 164 399 164", "0 188 399 188",
 * "0 212 399 212", "0 236 399 236", "0 260 399 260", "0 284 399 284",
 * "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380",
 * "0 404 399 404", "0 428 399 428", "0 452 399 452", "0 476 399 476",
 * "0 500 399 500", "0 524 399 524", "0 548 399 548", "0 572 399 572",
 * "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599",
 * "53 0 53 599", "69 0 69 599", "85 0 85 599", "101 0 101 599",
 * "117 0 117 599", "133 0 133 599", "149 0 149 599", "165 0 165 599",
 * "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599",
 * "245 0 245 599", "261 0 261 599", "277 0 277 599", "293 0 293 599",
 * "309 0 309 599", "325 0 325 599", "341 0 341 599", "357 0 357 599",
 * "373 0 373 599", "389 0 389 599"}
 * Returns:
 * { 15,  30,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  100,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  200,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345 }
 * <p/>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.
 * <p/>
 * <p/>
 * <p/>
 * Created by sharath on 6/2/15.
 */
public class GrafixMask {
    public int[] sortedAreas(String[] rectangles) {
        // prepare an open masking layer
        boolean[][] fill = new boolean[400][600];

        // fill the masking layer with rectangles that have been blocked off
        for (int i = 0; i < rectangles.length; i++) {
            StringTokenizer st = new StringTokenizer(rectangles[i]);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    fill[j][k] = true;
                }
            }
        }

        // The graph/connectivity grid is now ready, start calculating the area

        List<Integer> a1 = new ArrayList<>();

        for (int i = 0; i < fill.length; i++) {
            for (int j = 0; j < fill[i].length; j++) {
                if(!fill[i][j]) {
                    a1.add(doFill(fill, i, j));
                }
            }
        }

        int[] result = new int[a1.size()];

        for(int i = 0; i < a1.size(); i++) {
            result[i] = a1.get(i);
        }

        Arrays.sort(result);

        return result;
    }

    // Recursive function ends up in stack overflow, use explicit stack
    private int doFillRec(boolean[][] fill, int x, int y) {
        // Check to ensure that we are within the bounds of the grid, if not, return 0
        if (x < 0 || x >= 400) return 0;
        // Similar check for y
        if (y < 0 || y >= 600) return 0;

        // Check that we haven't already visited this position, as we don't want to count it twice
        if (fill[x][y]) return 0;

        fill[x][y] = true;

        // Now we know that we have at least one empty square, then we will recursively attempt to
        // visit every node adjacent to this node, and add those results together to return.
        return 1 + doFillRec(fill, x - 1, y) + doFillRec(fill, x + 1, y)
                + doFillRec(fill, x, y + 1) + doFillRec(fill, x, y - 1);
    }

    private int doFill(boolean[][] fill, int x, int y) {
        int result = 0;
        Stack<Point> s = new Stack<>();
        s.push(new Point(x, y));

        while(!s.isEmpty()) {
            Point top = s.pop();
            // Check to ensure that we are within the bounds of the grid, if not, return 0
            if (top.x < 0 || top.x >= 400) continue;
            // Similar check for y
            if (top.y < 0 || top.y >= 600) continue;
            // Check that we haven't already visited this position, as we don't want to count it twice
            if (fill[top.x][top.y]) continue;

            fill[top.x][top.y] = true;
            result++;

            // Now we know that we have at least one empty square, then we will attempt to
            // visit every node adjacent to this node.
            s.push(new Point(top.x + 1, top.y));
            s.push(new Point(top.x - 1, top.y));
            s.push(new Point(top.x, top.y + 1));
            s.push(new Point(top.x, top.y - 1));
        }
        return result;
    }

    public static void main(String[] args) {

        // better test cases here
        // http://community.topcoder.com/stat?c=problem_solution&cr=7452866&rd=5857&pm=2998
        GrafixMask g = new GrafixMask();
        int[] res = g.sortedAreas(new String[] {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"});
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

class Point {
    int x, y;

    Point(int xx, int yy) {
        x = xx;
        y = yy;
    }
}
