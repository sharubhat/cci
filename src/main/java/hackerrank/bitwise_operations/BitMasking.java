package hackerrank.bitwise_operations;

import java.util.Random;

/**
 * Tricks that are useful in extracting bits based on indices or in other words help clearing unwanted bits.
 *
 * 1. Clear all bits between i to j inclusive.
 * 2. Clear all bits from MSB to k.
 * 3. Clear all bits from k to LSB.
 * 4. Extract kth bit.
 * 5. Reverse kth bit.
 *
 * Created by sharath on 10/20/15.
 */
public class BitMasking {
    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt();
        System.out.println("Number : " + Integer.toBinaryString(x));
        System.out.println("* 1. Clear all bits between i to j inclusive.");

        System.out.println("* 2. Clear all bits from MSB to k.");
        System.out.println("* 3. Clear all bits from k to LSB.");
        System.out.println("* 4. Extract kth bit.");
        int k = r.nextInt(10);
        System.out.printf("     %dth bit is %d%n", k, (x >>> k) & 1);
        System.out.println("* 5. Reverse kth bit.");
    }
}
