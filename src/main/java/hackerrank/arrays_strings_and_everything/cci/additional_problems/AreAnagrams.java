package hackerrank.arrays_strings_and_everything.cci.additional_problems;

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
public class AreAnagrams {
    public boolean areAnagrams(String s1, String s2) {
        if(s1 != null && s2 != null
                && s1.length() == s2.length()) {
            if(s1.length() == 1)
                return s1.equals(s2);
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
        return (s1 != null && s2 != null
                && s1.length() == s2.length()
                && sorted(s1).equals(sorted(s2)));
    }

    private String sorted(String s) {
        char[] input =  s.toCharArray();
        Arrays.sort(input);
        return new String(input);
    }
}
