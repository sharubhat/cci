package enums;

/**
 * Created by sharath on 9/14/14.
 */
public class JavaEnumForLoopExample {
    public enum Margin {
        TOP, RIGHT, BOTTOM, LEFT;
    }

    public static void main(String[] args) {
        int count = 1;
        for(Margin m : Margin.values()) {
            System.out.printf("Margin %d = %s%n", count++, m);
        }
    }
}
