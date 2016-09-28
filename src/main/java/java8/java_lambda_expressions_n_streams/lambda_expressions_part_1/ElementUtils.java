package java8.java_lambda_expressions_n_streams.lambda_expressions_part_1;

import java.util.List;

/**
 * Created by sharath on 3/12/16.
 */
public class ElementUtils {
    public static <T> T betterElement(T element1, T element2, TwoElementPredicate<T> tester) {
        if(tester.isBetter(element1, element2)) {
            return element1;
        } else {
            return element2;
        }
    }

    private static <T> T lastEntry(List<T> list) {
        return list.size() > 0 ? list.get(list.size() - 1) : null;
    }

    private static <T> T lastEntry(T[] array) {
        return array.length > 0? array[array.length - 1] : null;
    }

    private ElementUtils() {} // Uninstantiatable class; contains only static methods.
}
