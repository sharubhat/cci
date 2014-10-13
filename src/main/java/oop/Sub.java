package oop;

/**
 * Created by sharath on 9/21/14.
 */
public class Sub extends Super {
    public int i = 2;

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.printf("sup.i = %s and sup.getI() = %s%n", sup.i, sup.getI());
        System.out.printf("sup.i = %s and ((Sub)sup).i = %s%n", sup.i, ((Sub)sup).i);
    }
}
