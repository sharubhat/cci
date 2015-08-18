package topcoder_dp.elementary;

/**
 * Created by sharath on 2/12/15.
 * Refer to topcoder pdf for details
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] seq1 = {5, 3, 4, 8, 6, 7, 8, 10};
        int[] seq2 = { 2, 4, 5, 9, 10, 11, 12, 13, 14, 15, 4, 5, 2, 1, 2, 3,
                4, 5, 6, 7, 9 };
        System.out.println(lengthOfLongestSSeq(seq1));
        System.out.println(lengthOfLongestSSeq(seq2));
    }

    private static int lengthOfLongestSSeq(int[] seq) {
        int maxLengthSoFar = 0;
        int currMaxLength = 1;
        for(int i = 1; i < seq.length; i++) {
            if(seq[i -1] < seq[i]) {
                currMaxLength++;
            }
            else {
                maxLengthSoFar = Math.max(maxLengthSoFar, currMaxLength);
                currMaxLength = 1;
            }
        }
        maxLengthSoFar = Math.max(maxLengthSoFar, currMaxLength);
        return maxLengthSoFar;
    }
}
