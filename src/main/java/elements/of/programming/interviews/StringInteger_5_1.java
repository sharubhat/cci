package elements.of.programming.interviews;

/**
 * Created by sharath on 1/5/15.
 *
 * 5.1
 * Problem description:
 * Implement string to int and vice versa functions
 *
 * Questions to ask:
 * 1. Are all characters ASCII?
 *    If yes, there are only 256 characters
 */
public class StringInteger_5_1 {
    public int stringToInt(String s) throws NumberFormatException {
        if(s == null)
            throw new NumberFormatException("null");

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int digit;

        if(len > 0) {
            char firstChar = s.charAt(0);
            if(firstChar < '0') {   // Possible leading '+' or '-'; Ascii values '0' -> 48, '-' -> 45 and '+' -> 43
                if(firstChar == '-')
                    negative = true;
                else if(firstChar != '+')
                    throw new NumberFormatException("For input string: \"" + s + "\"");

                if(len == 1)    // Can't have just + or -
                    throw new NumberFormatException("For input string: \"" + s + "\"");
                i++;
            }
            while(i < len) {
                digit = s.charAt(i++) - '0'; // need to remember that ascii value of 0 is 48
                if(digit < 0 || digit > 9)
                    throw new NumberFormatException("For input string: \"" + s + "\"");
                result = result * 10 + digit;
            }
        } else {
            throw new NumberFormatException("For input string: \"" + s + "\"");
        }

        return negative ? -result : result;
    }

    public String intToString(int n){
        // easiest solution is : return n + "";
        boolean positive = true;
        if(n == 0)
            return new String("0");
        if(n < 0) {
            positive = false;
            n = -n;
        }
        StringBuffer sb = new StringBuffer();

        while(n > 0) {
            int remainder = n % 10;
            n /= 10;
            sb.append(remainder);
        }

        String result = sb.reverse().toString();
        return positive? result : "-" + result;
    }

    public static void main(String[] args) {
//        System.out.println(new StringInteger().intToString(87));

    }
}
