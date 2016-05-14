package hackerrank.arrays_strings_and_everything;

import java.io.*;

/**
 * Check if a given string is palindrome(returns same string when reversed) ignoring case and the following
 * characters : '.', ',', '!', '-', ';', ':', '\'', '"', ' '
 *
 * Created by sharath on 8/1/15.
 */
public class StringPalindrome {

    private static boolean isPalindrome(String strInput) {
        if(strInput == null || strInput.isEmpty())
            return false;
        if(strInput.length() == 1)
            return true;
        strInput = strInput.toLowerCase();
        return isPalindromeRec(strInput.toCharArray(), 0, strInput.length() - 1);
    }

    private static boolean isPalindromeRec(char[] input, int start, int end) {
        if(start >= end)
            return true;
        while(start < end &&
                (input[start] == '.' ||
                input[start] == ',' ||
                input[start] == '!' ||
                input[start] == '-' ||
                input[start] == ';' ||
                input[start] == ':' ||
                input[start] == '\'' ||
                input[start] == '"' ||
                        input[start] == ' ')
                ) {
            start++;
        }

        while(start < end &&
                (input[end] == '.' ||
                input[end] == ',' ||
                input[end] == '!' ||
                input[end] == '-' ||
                input[end] == ';' ||
                input[end] == ':' ||
                input[end] == '\'' ||
                input[end] == '"' ||
                        input[end] == ' ')
                ) {
            end--;
        }

        if(input[start] == input[end])
            return isPalindromeRec(input, ++start, --end);
        
        return false;
    }

    public static void main(String[] args) throws IOException{
        System.out.println(isPalindrome("Never a foot too far, even."));
        System.out.println(isPalindrome("test"));
    }
}
