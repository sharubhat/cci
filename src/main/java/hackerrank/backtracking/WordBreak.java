package hackerrank.backtracking;

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

 * Approach: Back tracking Naive Approach

 * Navigate the given input string.
 * Take a blank string and keep adding one character at a time to it.
 * Keep checking if the word exist in the dictionary.
 * If word exist in the dictionary then add that word to the answer string and make recursive call to the rest of the string.
 * If any of the recursive call returns false then backtrack and remove the word from the answer string and again keep adding the characters to string.
 * If all the recursive calls return true that means string has been broken successfully.
 *
 * Created by sharath on 9/30/15.
 */
public class WordBreak {
}
