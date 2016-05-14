package hackerrank.arrays_strings_and_everything;

/**
 * Question to ask:
 * 1. Can there be delimiters within the string such as space, underscore, comma or dots?
 *
 * Hint : You don't need to know ascii value for numbers or any character to solve this problem.
 * Also know what atoi in C does.
 *      - anything starting with characters not in '+, -, [0-9]' returns 0.
 *      - otherwise returns digits until a character is encountered.
 *
 * Created by sharath on 8/4/15.
 */
public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("- 143"));
        System.out.println(atoi("- 143a45"));
        System.out.println("Value : " + atoi(""));
    }

    private static int atoi(String strInput) {
        if(strInput == null || strInput.length() == 0)
            return 0;

        // if there are delimiters, do this for all delimiter characters
        strInput = strInput.replace(" ", "");

        boolean positive = true;
        long sum = 0L;

        if(strInput.charAt(0) == '-') {
            positive = false;
        } else if(strInput.charAt(0) < '0' || strInput.charAt(0) > '9') {
            return 0;
        }

        for(int j = 1; j < strInput.length(); j++) {
            if(strInput.charAt(j) >= '0' && (strInput.charAt(j) <= '9')) {
                sum = (sum * 10) + (strInput.charAt(j) - '0');
            } else {
                break;
            }
        }

        long finalResult = positive ? sum : (-sum);

        // remember, 'atoi' is required to return an integer; handle overflow
        if (finalResult > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (finalResult < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) finalResult;
    }
}
