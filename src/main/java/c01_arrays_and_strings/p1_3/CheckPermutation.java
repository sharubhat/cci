package c01_arrays_and_strings.p1_3;

import java.util.Arrays;

/**
 * Created by sharath on 8/2/14.
 *
 * Problem description:
 * Given two strings, find if one is permutation of other
 *
 * Questions to ask:
 * 1. Are all characters ASCII?
 *    If yes, there are only 256 characters
 */
public class CheckPermutation {
    public boolean isPermuteCharArrayCompare(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        char[] arrS1 = s1.toCharArray();
        char[] arrS2 = s2.toCharArray();

        Arrays.sort(arrS1);
        Arrays.sort(arrS2);

        for(int i = 0; i < arrS1.length; i++) {
            if(arrS1[i] != arrS2[i])
                return false;
        }

        return true;
    }

    // Assuming the string is made up of only ASCII characters
    public boolean isPermuteASCII(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        int[] counter = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            counter[s1.charAt(i)]++;
        }
        for(int i = 0; i < s2.length(); i++) {
            if(--counter[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
