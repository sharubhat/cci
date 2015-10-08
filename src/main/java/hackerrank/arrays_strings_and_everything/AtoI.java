package hackerrank.arrays_strings_and_everything;

/**
 * Question to ask:
 * 1. Can there be delimiters within the string such as space, underscore, comma or dots?
 *
 * Hint : You don't need to know ascii value for numbers or any character to solve this problem.
 *
 * Created by sharath on 8/4/15.
 */
public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("- 143"));
    }

    static int atoi(String strInput) {
        if(strInput == null)
            return 0;

        strInput = strInput.replace(" ", "");

        int i = 0;
        boolean positive = true;
        long sum = 0L;

        if(strInput.charAt(i) == '-') {
            positive = false;
            i++;
        } else if(strInput.charAt(i) == '+'){
            positive = true;
            i++;
        } else if(strInput.charAt(i) < '0' || strInput.charAt(i) > '9') {
            return 0;
        }

        for(int j = i; j < strInput.length(); j++) {
            if(strInput.charAt(j) >= '0' && (strInput.charAt(j) <= '9')) {
                sum = (sum * 10) + (strInput.charAt(j) - '0');
            } else {
                break;
            }
        }

        long finalResult = positive ? sum : (-sum);

        if (finalResult > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (finalResult < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) finalResult;
    }
}
