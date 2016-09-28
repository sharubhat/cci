package java8.java_lambda_expressions_n_streams.java7_lambda_method_reference;

/**
 * Created by sharath on 4/20/16.
 */
public class Main {
    public static void main(String[] args) {
        int x = 5, y = 7;
        System.out.println(Util.method1(x, y, new CosCalculator() {
            @Override
            public Double cosCal(double d) {
                return Math.cos(d);
            }
        }));

        /* using lambda expressions.
         Note : CosCalculator is a SAM(single abstract method) interface which has a method cosCal
         that takes a double and returns a double. The anonymous inner class in java 7 implementation
         therefore can be replaced by a lambda expression that given a double does exactly what
         cosCal does and returns a double.

         What java does under the hood?
         Java looks at signature of method1 and understands that the type of lambda supplied
          should be CosCalculator which has a single method cosCal. Then it sees that the syntax of
          lambda matches cosCal signature. So inside method1, whenever there is a call to cosCal,
          it invokes the lambda that is supplied by calling function.
          */
        System.out.println(Util.method1(x, y, d -> Math.cos(d)));

        /* using method reference
        Note : Lambda in above line of code can be replaced by a method reference
         */
        System.out.println(Util.method1(x, y, Math::cos));
    }
}
