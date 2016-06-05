package hackerrank.arrays_strings_and_everything.cci.p1_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharath on 7/31/14.
 *
 * Problem description:
 * Algorithm to determine of string has all unique characters
 *
 * Questions to ask:
 * 1. Are all characters ASCII?
 *    If yes, there are only 128 characters(256 in extended ascii)
 */
public class Unique {
    /*
        Runs in O(n) time complexity and O(k) space, k being number of characters in the character set.
        Assumption that character set is ascii is fine because whatever is the character set, it would be
        consisting of fixed number of characters and this logic holds good.
    */
    public boolean hasAllUniqueChars(String input) {
        if(input != null && !input.isEmpty() && input.length() <= 128) {
            boolean[] charSet = new boolean[128];
            for (int i = 0; i < input.length(); i++) {
                int c = input.charAt(i);
                if (charSet[c])
                    return false;
                else
                    charSet[c] = true;
            }
            return true;
        }
        return false;
    }

    // worst case still requires O(k) space
    public boolean hasAllUniqueCharsUsingSet(String input) {
        if(input != null && !input.isEmpty()) {
            Set<Character> store = new HashSet<>();
            for (int i = 0; i < input.length(); i++) {
                if (!store.add(input.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    /*
        Assuming characters are all lower case and are between a to z,
        we could save space by using a bit vector.
     */
    boolean isUniqueChars(String s) {
        if(s != null && !s.isEmpty()) {
            int checker = 0b0;
            for (int i = 0; i < s.length(); i++) {
                int val = s.charAt(i) - 'a';
                // check if bit is set at position val, set if not already
                if ((checker & (0b1 << val)) > 0) {
                    return false;
                }
                checker |= (0b1 << val);
            }
            return true;
        }
        return false;
    }
}
