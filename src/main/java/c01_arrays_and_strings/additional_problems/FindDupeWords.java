package c01_arrays_and_strings.additional_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sharath on 8/11/14.
 *
 * Find duplicate words in a given string
 */
public class FindDupeWords {
    public List<String> duplicates(String input) {
        Set<String> uniqueWords = new HashSet<>();
        List<String> dupes = new ArrayList<>();
        for(String s : input.split(" ")) {
            if(!uniqueWords.add(s)) {
                dupes.add(s);
            }
        }
        return dupes;
    }
}
