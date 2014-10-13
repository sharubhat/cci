package enums;

/**
 * // enum with constant-specific method implementations
 * Created by sharath on 9/14/14.
 */
public enum Operation {
    PLUS {
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);
}
