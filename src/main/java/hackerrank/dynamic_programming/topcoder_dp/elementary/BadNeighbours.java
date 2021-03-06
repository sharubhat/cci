package hackerrank.dynamic_programming.topcoder_dp.elementary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharath on 2/12/15.
 * Topcoder problem
 * Problem Statement
 *
 * The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart.
 * Every resident hates his next-door neighbors on both sides. Nobody is willing to live farther away from the town's well
 * than his neighbors, so the town has been arranged in a big circle around the well. Unfortunately, the town's well is in
 * disrepair and needs to be restored. You have been hired to collect donations for the Save Our Well fund.
 *
 * Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations, which is
 * listed in clockwise order around the well. However, nobody is willing to contribute to a fund to which his neighbor
 * has also contributed. Next-door neighbors are always listed consecutively in donations, except that the first and last
 * entries in donations are also for next-door neighbors.
 * You must calculate and return the maximum amount of donations that can be collected.
 *
 *
 * Definition
 *
 * Class:	BadNeighbors
 * Method:	maxDonations
 * Parameters:	int[]
 * Returns:	int
 * Method signature:	int maxDonations(int[] donations)
 * (be sure your method is public)
 *
 *
 * Constraints
 * -	donations contains between 2 and 40 elements, inclusive.
 * -	Each element in donations is between 1 and 1000, inclusive.
 *
 * Examples
 * 0)
 *
 * { 10, 3, 2, 5, 7, 8 }
 * Returns: 19
 * The maximum donation is 19, achieved by 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations are
 * from neighbors.
 * 1)
 *
 * { 11, 15 }
 * Returns: 15
 * 2)
 *
 * { 7, 7, 7, 7, 7, 7, 7 }
 * Returns: 21
 * 3)
 *
 * { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }
 * Returns: 16
 * 4)
 *
 * { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
 * 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
 * 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }
 * Returns: 2926
 */
public class BadNeighbours {
    public static void main(String[] args) {
        int[] a1 = {10, 3, 2, 5, 7, 8};
        int[] a2 = {11, 15};
        int[] a3 = {7, 7, 7, 7, 7, 7, 7};
        int[] a4 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] a5 = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};

        System.out.println(new BadNeighbours().maxDonations(a1) + " " + new BadNeighbours().maxDonations2(a1));
        System.out.println(new BadNeighbours().maxDonations(a2) + " " + new BadNeighbours().maxDonations2(a2));
        System.out.println(new BadNeighbours().maxDonations(a3) + " " + new BadNeighbours().maxDonations2(a3));
        System.out.println(new BadNeighbours().maxDonations(a4) + " " + new BadNeighbours().maxDonations2(a4));
        System.out.println(new BadNeighbours().maxDonations(a5) + " " + new BadNeighbours().maxDonations2(a5));
    }

    // Using a hashmap helps avoiding the re-calculation.
    // you can use any logic to calculate the key. as long as it's unique for every call, it would work.
    // say you have 'key = start + end', then key would be 6 if start = 0 and end = 6 OR if start is 2 and end is 4.
    // This would definitely yield wrong result. However, start * a high number like 500
    // would result in keys that are definitely far apart.
    private int findMax(int[] donations, int start, int end, Map<Integer, Integer> answers) {
        int key = start * 500 + end;
        if (answers.get(key) != null) return answers.get(key);
        if (start > end)
            return 0;
        answers.put(key, Math.max(findMax(donations, start + 1, end, answers), findMax(donations, start + 2, end, answers) + donations[start]));
        return answers.get(key);
    }

    public int maxDonations(int[] donations) {
        int n = donations.length;
        Map<Integer, Integer> answers = new HashMap<>();
        int sol =  Math.max(findMax(donations, 0, n - 2, answers), findMax(donations, 1, n - 1, answers));
        return sol;
    }


    public int maxDonations2(int[] donations) {
        int[][] cache =new int[2][donations.length];
        Arrays.fill(cache[0], -1);
        Arrays.fill(cache[1], -1);
        return Math.max(max(donations, 2, true, cache) + donations[0], max(donations, 1, false, cache));
    }

    public int max(int[] donations, int where, boolean onegave, int[][] cache){
        // if you reach the end, return
        if(where==donations.length) return 0;
        if(where==donations.length-1 && onegave) return 0;
        else if(where==donations.length-1) return donations[where];
        if(cache[onegave?1:0][where]!=-1) return cache[onegave?1:0][where];
        return cache[onegave?1:0][where]=Math.max(max(donations,where+1,onegave,cache),max(donations,where+2,onegave, cache)+donations[where]);
    }
}
