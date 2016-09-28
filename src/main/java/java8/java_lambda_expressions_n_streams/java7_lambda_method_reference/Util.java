package java8.java_lambda_expressions_n_streams.java7_lambda_method_reference;

/**
 * Created by sharath on 4/20/16.
 */
public class Util {
    protected static double method1(int x, int y, CosCalculator cal) {
        return cal.cosCal(x) * cal.cosCal(y);
    }
}
