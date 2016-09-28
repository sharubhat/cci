package java8.java_lambda_expressions_n_streams.lambda_expressions_part_2;

import java.util.Arrays;

/**
 * Make an array containing a few Strings.
 * Replace the explicit lambda with a method reference.
 *
 * Created by sharath on 3/12/16.
 */
public class SortingExamples {
    public static void main(String[] args) {
        String[] words = {"hi", "hello", "hola", "bye", "goodbye", "adios"};
//        Arrays.sort(words, (s1, s2) -> containsEComparator(s1, s2));
        Arrays.sort(words, SortingExamples::containsEComparator);
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
