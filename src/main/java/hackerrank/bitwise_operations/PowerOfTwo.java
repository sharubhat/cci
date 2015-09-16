package hackerrank.bitwise_operations;

/**
 * How to check If Integer is Power of Two in Java?
 * <p>
 * Created by sharath on 9/7/15.
 */
public class PowerOfTwo {
    public static boolean isPowerofTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String args[]) {
        System.out.printf("is %d power of Two? %b%n", 2, isPowerofTwo(2));
        System.out.printf("is %d power of Two? %b%n", 4, isPowerofTwo(4));
        System.out.printf("is %d power of Two? %b%n", 5, isPowerofTwo(5));
        System.out.printf("is %d power of Two? %b%n", 1, isPowerofTwo(1));
        System.out.printf("is %d power of Two? %b%n", -1, isPowerofTwo(-1));
    }
}
