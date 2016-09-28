package hackerrank.arrays_strings_and_everything.cci.tries;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sharath on 6/4/16.
 */
public class Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(new String[]{"newmoon", "new moon", "newton", "old wine", "oldie"});
        Trie t = new Trie(words);
        System.out.println(t.contains("old"));
        System.out.println(t.contains("new"));
        System.out.println(t.contains("ola"));
    }
}
