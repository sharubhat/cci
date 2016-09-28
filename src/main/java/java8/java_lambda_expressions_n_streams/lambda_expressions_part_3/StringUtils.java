package java8.java_lambda_expressions_n_streams.lambda_expressions_part_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by sharath on 4/20/16.
 */
public class StringUtils {
    public static List<String> allMatches(List<String> candidates, Predicate<String> matchFunction) {
        List<String> results = new ArrayList<>();
        for(String possibleMatch : candidates) {
            if(matchFunction.test(possibleMatch)) {
                results.add(possibleMatch);
            }
        }
        return results;
    }
}
