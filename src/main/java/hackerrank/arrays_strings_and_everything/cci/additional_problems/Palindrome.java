package hackerrank.arrays_strings_and_everything.cci.additional_problems;

/**
 * Created by sharath on 8/12/14.
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        if(s != null && !s.isEmpty() && s.length() > 1) {
            int length = s.length();
            for(int i = 0; i < length / 2; i++) {
                if(s.charAt(i) != s.charAt(length - 1 - i))
                    return false;
            }
            return true;
        }
        return false;
    }
}
