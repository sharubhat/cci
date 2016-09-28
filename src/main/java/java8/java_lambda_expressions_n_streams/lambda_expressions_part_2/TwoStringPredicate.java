package java8.java_lambda_expressions_n_streams.lambda_expressions_part_2;

/**
 * An interface for which lambdas can be used.
 *
 * Created by sharath on 4/16/16.
 */
@FunctionalInterface
public interface TwoStringPredicate {
    boolean isBetter(String s1, String s2);
}
