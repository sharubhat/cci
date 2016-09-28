package java8.java_lambda_expressions_n_streams.lambda_expressions_part_1;

/**
 * Created by sharath on 4/16/16.
 */
public class StringUtils {
    public static String betterString(String s1, String s2, TwoStringPredicate tester) {
        if(tester.isBetter(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }

    private StringUtils() {} // Uninstantiatable class; contains only static methods.
}
