package hackerrank.dynamic_programming.others;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an string and a dictionary of words, find out if the input string can be broken into
 * a space separated sequence of one or more dictionary words.
 *
 * Example:
 *
 * dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
 *
 * String = "IamSumit"
 * Output: "I am Sumit"
 *
 * String ="thisisadog"
 * Output : String can't be broken
 *
 * Approach: Back tracking Naive Approach
 *
 * Navigate the given input string.
 * Take a blank string and keep adding one character at a time to it.
 * Keep checking if the word exist in the dictionary.
 * If word exist in the dictionary then add that word to the answer string and make recursive call to the rest of the string.
 * If any of the recursive call returns false then backtrack and remove the word from the answer string and
 * again keep adding the characters to string.
 * If all the recursive calls return true that means string has been broken successfully.
 *
 * Created by sharath on 10/3/15.
 */
public class WordBreak {
    public void wordBreak(String input, Set<String> dict) {
        if (!wordBreak(input, "", dict, new HashSet<>()))
            System.out.println("String can't be broken");
    }

    private boolean wordBreak(String s, String sol, Set<String> dict, Set<String> store) {
        if (s == null || s.isEmpty()) {
            System.out.println(sol);
            return true;
        } else if(store.contains(s)) {
            System.out.println(s);
            return false;
        } else {
            String word = "";
            for (int i = 0; i < s.length(); i++) {
                word += s.charAt(i);
                if (dict.contains(word)) {
                    if (wordBreak(s.substring(i + 1), sol + word + " ", dict, store)) {
                        return true;
                    }
                }
            }
            store.add(s);
            return false;
        }
    }

    public static void main(String[] args) {
        String in = "IamSumit";
        Set<String> dict = new HashSet<>();
        dict.add("I");
        dict.add("have");
        dict.add("Sumit");
        dict.add("Jain");
        dict.add("am");
        dict.add("this");
        dict.add("dog");
        dict.add("is");
        dict.add("thisisa");

        WordBreak wb = new WordBreak();
        wb.wordBreak(in, dict);
        wb.wordBreak("thisisadog", dict);
    }
}
