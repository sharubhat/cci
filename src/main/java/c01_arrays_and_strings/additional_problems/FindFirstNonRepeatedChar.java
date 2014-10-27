package c01_arrays_and_strings.additional_problems;

/**
 * Created by sharath on 8/12/14.
 */
public class FindFirstNonRepeatedChar {
    public char firstNonRepeatedChar(String s) {
        if(s != null && !s.isEmpty()) {
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(s.indexOf(c) == s.lastIndexOf(c)) {
                    return c;
                }
            }
        }
        return '\0';
    }
}
