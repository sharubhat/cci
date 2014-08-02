package c01.arrays.and.strings.p1_1;

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
    public boolean hasAllUniqueChars(String input) {
        if(input == null || input.length() == 0)
            throw new IllegalArgumentException();
        if(input.length() > 265)
            return false;
        boolean[] charSet = new boolean[256];
        for(int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if(charSet[c])
                return false;
            else
                charSet[c] = true;
        }
        return true;
    }

}
