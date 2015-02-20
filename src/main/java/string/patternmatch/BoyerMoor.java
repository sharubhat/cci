package string.patternmatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharath on 1/23/15.
 *
 * Refer DS and Algo in Java by Goodrich and Tamassia
 */
public class BoyerMoor {
    public static int find(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if(m == 0)
            return 0;

        Map<Character, Integer> last = new HashMap<>();
        // set -1 as default for all text characters
        for(int i = 0; i < n; i++) {
            last.put(text[i], -1);
        }
        // rightmost occurrence in pattern is last
        for(int i = 0; i < m; i++) {
            last.put(pattern[i], i);
        }
        // start with the end of the pattern aligned at index m-1 of the text
        int i = m - 1;  // an index to text
        int k = m - 1;  // an index to pattern
        while(i < n) {
            if(text[i] == pattern[k]) { // a matching character
                if(k == 0)              // entire pattern has been found
                    return i;
                i--;                    // examine previous characters of text and pattern
                k--;
            } else {
                // The pattern is then shifted so that its last occurrence of character text[i]
                // is aligned with the corresponding text[i].
                i += m - Math.min(k, 1 + last.get(text[i])); // case analysis for jump step
                k = m - 1;  // restart at end of the pattern
            }
        }
        return -1;  // pattern was never found
    }

    public static void main(String[] args) {
        String pat = "needle";
        String txt = "Finding needle in a haystack";
        int offset1 = find(txt.toCharArray(), pat.toCharArray());

        // print results
        System.out.println("text:    " + txt);
        System.out.println("pattern: " + pat);
        System.out.println("Found at index " + offset1);
    }
}
