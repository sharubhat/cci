package hackerrank.bitwise_operations;

import java.util.Random;

/**
 * Commit to memory - java int is 32 bit. 64 bit integer refers to data type long.
 *
 * Created by sharath on 10/20/15.
 */
public class BitHacks {
    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt();
        System.out.printf("Number is %d%n", x);
        System.out.printf("Number is                - %32s%n", Integer.toBinaryString(x));
        System.out.printf("Clearing lowest set bit  - %32s%n", Integer.toBinaryString(x & (x-1)));
        System.out.printf("Lowest of the set bit is - %32s%n", Integer.toBinaryString(x & ~(x-1)));

    }
}
