package c01_arrays_and_strings.additional_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 8/12/14.
 */
public class FindFirstNonRepeatedChar {
    public char firstNonRepeatedCharUsingList(String s) {
        List<Character> uniqueChars = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(uniqueChars.contains(c)) {
                // Arraylist remove either takes index or takes object
                // to use remove(Object o), c should be Character
                uniqueChars.remove(uniqueChars.indexOf(c));
            } else {
                uniqueChars.add(c);
            }
        }
        if(uniqueChars.isEmpty())
            return '\0';
        return uniqueChars.get(0);
    }

    public char firstNonRepeatedChar(String s) {
        if(s != null || !s.isEmpty()) {
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
