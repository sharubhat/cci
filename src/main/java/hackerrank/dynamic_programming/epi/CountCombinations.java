package hackerrank.dynamic_programming.epi;

import java.util.Arrays;
import java.util.List;

/**
 * In American football, scores can be 2 points, 3 points or 7 points. Find out all combinations that can lead to given score.
 *
 * Hint: Start with a single point say 2 and see how you can get the score.
 *
 * Created by sharath on 11/16/15.
 */
public class CountCombinations {
    public static void main(String[] args) {
        List<Integer> points = Arrays.asList(new Integer[]{2,3,7});
        System.out.println(countCombinations(points, 12));
        System.out.println(countPermutations(points, 12));
        System.out.println(minPointsNeeded(points, 12));
    }

    /**
     * Gives all combinations of scores. E.g : (2*6) or (2*3)+(3*2) etc
     *
     * @param points
     * @param totalScore
     * @return
     */
    public static long countCombinations(List<Integer> points, int totalScore) {
        long[] combinations = new long[totalScore + 1];
        combinations[0] = 1;
        for(int score : points) {
            for(int j = score; j <= totalScore; j++) {
                combinations[j] += combinations[j - score];
            }
        }
        return combinations[totalScore];
    }

    /**
     * Permutation gives all possible ways in which the totalScore can be achieved.
     * Note that 6 6 and 6 6 is single permutation(assuming each 6 is scored by different player).
     *
     * @param points
     * @param totalScore
     * @return
     */
    public static long countPermutations(List<Integer> points, int totalScore) {
        long[] permutations = new long[totalScore + 1];
        permutations[0] = 1;
        for(int i = 0; i <= totalScore; i++) {
            for(int score : points) {
                if(i >= score) {
                    permutations[i] += permutations[i - score];
                }
            }
        }
        return permutations[totalScore];
    }

    /**
     * This gives the fastest way the football team can achieve the score.
     *
     * @param points
     * @param totalScore
     * @return
     */
    public static long minPointsNeeded(List<Integer> points, int totalScore) {
        long[] minPoints = new long[totalScore + 1];
        for(int i = 1; i < minPoints.length; i ++) {
            minPoints[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= totalScore; i++) {
            for(int score : points) {
                if(i >= score) {
                    minPoints[i] = Math.min(minPoints[i - score] + 1, minPoints[i]);
                }
            }
        }
        return minPoints[totalScore];
    }
}
