package hackerrank.arrays_strings_and_everything.cci.additional_problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharath on 8/12/14.
 *
 * Return anagrams(permutations) of a given word.
 * Anagrams can't be more than n!(n factorial) for a word of n characters.
 * However if there are duplicate characters, then number of anagrams will be lesser.
 *
 */
public class Anagrams {
    public Set<String> allAnagrams(String s) {
        return allAnagrams("", s, new HashSet<>());
    }

    public Set<String> allAnagrams(String prefix, String s, Set<String> store) {
        int n = s.length();
        if(s.isEmpty())
            store.add(prefix);
        else {
            for(int i = 0; i < n; i++) {
                allAnagrams(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), store);
            }
        }
        return store;
    }
}
