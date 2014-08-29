package c01_arrays_and_strings.additional_problems;

/**
 * Created by sharath on 8/29/14.
 */
public class StringReverse {
    public String usingBuilder(String s) {
        if(s == null || s.length() < 2)
            return s;
        return new StringBuilder(s).reverse().toString();
    }

    public String iterative(String s) {
        if(s == null || s.length() < 2)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String recursive(String s) {
        if(s.length() < 2)
            return s;
        else
            return recursive(s.substring(1)) + s.charAt(0);
    }
}
