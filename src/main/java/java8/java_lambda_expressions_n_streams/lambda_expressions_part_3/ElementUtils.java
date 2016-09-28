package java8.java_lambda_expressions_n_streams.lambda_expressions_part_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by sharath on 4/20/16.
 */
public class ElementUtils {
    public static <T> List<T> allMatches(List<T> candidates, Predicate<T> matchFunction) {
        List<T> results = new ArrayList<>();
        for(T possibleMatch : candidates) {
            if(matchFunction.test(possibleMatch)) {
                results.add(possibleMatch);
            }
        }
        return results;
    }
}
