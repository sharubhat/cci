package c01_arrays_and_strings.additional_problems;

import java.util.Arrays;

/**
 * Created by sharath on 8/12/14.
 *
 * Problem description:
 * Check if two strings are anagrams
 *
 * Questions to ask:
 * 1. Are all characters ASCII?
 *    If yes, there are only 256 characters
 */
public class Anagrams {
    public boolean areAnagrams(String s1, String s2) {
        if(s1 != null && s2 != null
                && !s1.isEmpty() && !s2.isEmpty()
                && s1.length() == s2.length()) {
            int[] charset = new int[256];
            for (int i = 0; i < s1.length(); i++) {
                charset[s1.charAt(i)]++;
            }

            for (int j = 0; j < s2.length(); j++) {
                charset[s2.charAt(j)]--;
                if (charset[s2.charAt(j)] < 0)
                    return false;
            }
            return true;
        }
        return false;
    }

    public boolean checkAnagrams(String s1, String s2) {
        if(s1 != null && s2 != null
                && !s1.isEmpty() && !s2.isEmpty()
                && s1.length() == s2.length()) {
            return sorted(s1).equals(sorted(s2));
        }
        return false;
    }

    private String sorted(String s) {
        char[] input =  s.toCharArray();
        Arrays.sort(input);
        return new String(input);
    }
}
