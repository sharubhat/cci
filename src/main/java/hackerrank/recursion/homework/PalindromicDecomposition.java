package hackerrank.recursion.homework;

import java.util.Set;

/**
 * Decompose string into sub-strings such that they are palindromes. Single character is considered a palindrome.
 * Created by sharath on 8/18/15.
 */
public class PalindromicDecomposition {
    private static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public Set<String> decompose(String str) {
        return null;
    }
}
