package c01_arrays_and_strings.p1_1;

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
 *    If yes, there are only 256 characters
 */
public class Unique {
    // Runs in O(n) but need to know the character set before hand to decide size of array
    public boolean hasAllUniqueChars(String input) {
        if(input != null && !input.isEmpty() && input.length() <= 265) {
            boolean[] charSet = new boolean[256];
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

    // probably a little more of space but need not worry about character set
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

}
