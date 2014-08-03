package c01_arrays_and_strings.p1_4;

/**
 * Created by sharath on 8/2/14.
 *
 * Problem description:
 * Replaces all spaces in a string with %20
 * If solving in java, then convert it to character array.
 * Assume that the array has just enough length to hold final string.
 *
 * Questions to ask:
 * Can't think of any
 */
public class ReplaceSpaces {
    public String replaceSpaces(String input) {
        if(input == null || input.length() == 0)
            throw new IllegalArgumentException();
        int spaceCount = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ')
                spaceCount++;
        }
        // One ' ' should be replaced by 3 chars i.e. you need 2 additional char space per ' '
        char[] result = new char[input.length() + spaceCount * 2];
        int j = result.length - 1;
        for(int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == ' ') {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            }
            else
                result[j--] = input.charAt(i);
        }
        return new String(result);
    }
}
