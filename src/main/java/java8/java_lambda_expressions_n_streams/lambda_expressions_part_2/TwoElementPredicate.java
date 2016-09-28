package java8.java_lambda_expressions_n_streams.lambda_expressions_part_2;

/**
 * Created by sharath on 4/16/16.
 */
@FunctionalInterface
public interface TwoElementPredicate<T> {
    boolean isBetter(T element1, T element2);
}
