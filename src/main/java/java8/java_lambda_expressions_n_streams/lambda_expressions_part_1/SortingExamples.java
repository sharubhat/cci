package java8.java_lambda_expressions_n_streams.lambda_expressions_part_1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Make an array containing a few Strings.
 * Sort it by
 * • length (i.e., shortest to longest)
 * • reverse length (i.e., longest to shortest)
 * • alphabetically by the first character only (Hint: charAt(0) returns the numeric code for the first character)
 * • Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
 * (Hint: remember that the body of a lambda is allowed to have curly braces and a return statement.
 * See the first two lambda examples in the notes.)
 * • Redo the previous problem, but use a static helper method so that your lambda looks like this:
 * Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
 *
 * Created by sharath on 3/12/16.
 */
public class SortingExamples {
    public static void main(String[] args) {
        String[] words = {"hi", "hello", "hola", "bye", "goodbye", "adios"};
        System.out.println("Original array: " + Arrays.asList(words));
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length() - s2.length();
//            }
//        });
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted by length ascending: " + Arrays.asList(words));
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        System.out.println("Sorted by length descending: " + Arrays.asList(words));
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.charAt(0) - o2.charAt(0);
//            }
//        });
        Arrays.sort(words, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.println("Sorted by first character: " + Arrays.asList(words));

        Arrays.sort(words, (s1, s2) ->
        {
            int compareFlag = 0;
            if (s1.contains("e") && !s2.contains("e"))
                compareFlag = -1;
            else if (!s1.contains("e") && s2.contains("e"))
                compareFlag = 1;
            return compareFlag;
        });
        System.out.println("Sorted by whether it contains 'e' [v1] : " + Arrays.asList(words));
        Arrays.sort(words, (s1, s2) -> containsEComparator(s1, s2));
        System.out.println("Sorted by whether it contains 'e' [v1] : " + Arrays.asList(words));
    }

    static int containsEComparator(String s1, String s2) {
        int compareFlag = 0;
        if (s1.contains("e") && !s2.contains("e"))
            compareFlag = -1;
        else if (!s1.contains("e") && s2.contains("e"))
            compareFlag = 1;
        return compareFlag;
    }
}
