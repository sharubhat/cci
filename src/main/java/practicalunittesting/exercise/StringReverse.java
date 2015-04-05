package practicalunittesting.exercise;

/**
 * Created by sharath on 4/4/15.
 */
public class StringReverse {
    public String reverse(String s) {
        if(s == null || s.isEmpty())
            throw new IllegalArgumentException("String to be reversed can't be null/empty");

        StringBuilder reversedString = new StringBuilder(s.length());
        for(int i = s.length() - 1; i >= 0; i--) {
            reversedString.append(s.charAt(i));
        }
        return reversedString.toString();
    }
}
