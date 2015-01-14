package enums;

/**
 * Created by sharath on 9/14/14.
 */
public enum Operations_WithBodiesNData {
    PLUS("+") {double apply(double x, double y){return x + y;}},
    MINUS("-") {double apply(double x, double y){return x - y;}},
    TIMES("*") {double apply(double x, double y){return x * y;}},
    DIVIDE("/") {double apply(double x, double y){return x / y;}};

    private final String symbol;
    Operations_WithBodiesNData(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // abstract method is to make sure that every constant in the enum provides an implementation
    abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");
        for(Operations_WithBodiesNData op : Operations_WithBodiesNData.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
