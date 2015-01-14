package c01_arrays_and_strings.additional_problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sharath on 8/12/14.
 */
public class FindFirstNonRepeatedChar {
    // Don't get fooled by indexOf offered by the string class.
    // indexOf internally is using for loop. So this algorithm runs at O(n2)
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

    // Relatively faster approach O(n) time at the cost of additional space
    public char firstNonRepeatedUsingList(String s) {
        Map<Character, Integer> store = new LinkedHashMap<>();
        char c = '\0';
        if(s != null && !s.isEmpty()) {
            // O(n) time
            for(int i = 0; i < s.length(); i++) {
                if(store.containsKey(s.charAt(i)))      // O(1) time
                    store.put(s.charAt(i), store.get(s.charAt(i)) + 1); // O(1)
                else
                    store.put(s.charAt(i), 1);      // O(1)
            }
        }
        // O(n) time
        for(Map.Entry e : store.entrySet()) {
            if((Integer)e.getValue() == 1) { // O(1) time
                c = (Character) e.getKey();
                break;
            }
        }
        return c;
    }
}
