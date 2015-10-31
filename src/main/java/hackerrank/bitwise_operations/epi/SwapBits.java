package hackerrank.bitwise_operations.epi;

import java.util.Random;

/**
 * Swap bits in a given word at two specified indices.
 *
 * Hint : When do you have to swap? Do you really need to swap?
 * Ans : Swap only if they are different from each other. Instead of swapping, just reverse the bits.
 *
 * Notes :
 *
 * y = x & (x-1) clears the lowest set bit.
 * y = x & ~(x-1) extracts the lowest set bit of x,
 * meaning it returns a number with only that bit set which is the lowest set bit in original word.
 * Created by sharath on 10/20/15.
 */
public class SwapBits {
    public static void main(String[] args) {
        Random r = new Random();
        long x = r.nextLong();
        int k = r.nextInt(20), j = r.nextInt(20);

        System.out.println("k = " + k + " j = " + j);

        System.out.printf("%64s%n", Long.toBinaryString(x));
        System.out.printf("%64s%n", Long.toBinaryString(swapBits(x, k, j)));
    }

    private static long swapBits(long x, long k, long j) {
        if(((x >>> k) & 1) != ((x >>> j) & 1)) {
            System.out.println((x >>> k) & 1);
            System.out.println((x >>> j) & 1);
            long bitMask = (1L << k) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
}
