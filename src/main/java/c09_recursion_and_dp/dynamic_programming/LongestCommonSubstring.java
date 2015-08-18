package c09_recursion_and_dp.dynamic_programming;

/**
 * The Longest Common Substring problem is, given two strings s and t,
 * find the longest substring (contiguous characters) that is in both s and t.
 * This has been used to find the similarity between two different genes.
 * Note that this is not the same as the Longest Common Subsequence problem,
 * in which characters are not necessarily contiguous.
 * However, both can be solved using dynamic programming.
 *
 * As an example, say that s = "tofoodie” and t = “toody”.
 * The longest substring in each is “ood” at three characters.
 * There are several substrings of two characters,
 * including “to” and “oo” and “od”.

 * Created by sharath on 7/20/15.
 */
public class LongestCommonSubstring {
    public String longestSubstring(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
            return "";

        // ignore case (something to clarify)
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[][] num = new int[s1.length()][s2.length()];
        int maxlen = 0;
        int lastSubsBegin = 0;

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i == 0 || j == 0)
                        num[i][j] = 1;
                    else {
                        num[i][j] = 1 + num[i - 1][j - 1];
                    }

                    if(num[i][j] > maxlen) {
                        maxlen = num[i][j];
                        int thisSubsBegin = i - num[i][j] + 1;
                        if(lastSubsBegin == thisSubsBegin) {
                            sb.append(s1.charAt(i));
                        } else {
                            lastSubsBegin = thisSubsBegin;
                            sb = new StringBuilder();
                            sb.append(s1.substring(lastSubsBegin, i + 1));
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonSubstring l = new LongestCommonSubstring();
        System.out.println(l.longestSubstring("Please, peter go swimming!", "I’m peter goliswi"));
    }
}
