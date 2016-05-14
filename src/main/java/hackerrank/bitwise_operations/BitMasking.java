package hackerrank.bitwise_operations;

import java.util.Random;

/**
 * Tricks that are useful in extracting bits based on indices or in other words help clearing unwanted bits.
 *
 * 1. Clear all bits between i to j inclusive.
 * 2. Clear all bits from MSB(left most bit) to k.
 * 3. Clear all bits from k to LSB(right most bit).
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
        int temp = r.nextInt(10);
        int i = temp < 0 ? -temp : temp;
        int j = r.nextInt(i);
        System.out.printf("     %d, %d%n", i, j);
        System.out.printf("     %32s %n     %32s%n", Integer.toBinaryString(x), Integer.toBinaryString(x & maskItoJ(i, j)));
        System.out.println("* 2. Clear all bits from MSB to k.");
        System.out.println("* 3. Clear all bits from k to LSB.");
        System.out.println("* 4. Extract kth bit.");
        int k = r.nextInt(10);
        System.out.printf("     %dth bit is %d%n", k, (x >>> k) & 1);
        System.out.printf("     %dth bit is %d%n", k, (x & (1 << k)) == 0 ? 0 : 1);
        System.out.println("* 5. Reverse kth bit.");
    }

    private static int maskItoJ(int i, int j) {
        // left shift 1 by i+1, subtract 1 from it, gives all 1s from 0th to ith position.
        int maskI = (1 << (i + 1)) -1;
        // left shift 1 by j, subtract 1 from it, gives all 1s from 0th to j-1th position.
        int maskJ = (1 << j) - 1;
        // xor above two removes all common 1s leaving 1s between i through j inclusive.
        // negate creates a mask that has all 0s between i through j inclusive.
        return ~(maskI ^ maskJ);
    }
}
