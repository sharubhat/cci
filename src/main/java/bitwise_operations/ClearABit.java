package bitwise_operations;

/**
 * Clearing a bit at given position means changing the bit at that position to 0 no matter what it was earlier.
 *
 * To turn a bit with value '1' or '0' to '0', it should be '&' ('bitwise AND) with 0.
 *
 * To get a byte with only bit at nth position 0, we can twiddle the output of left shift 1 by n. i.e. ~(1 << n).
 *
 * Ans: a &= ~(1 << n)
 *
 * Assumption : 0 is the least significant bit and n is (n+1)th position from right
 * Created by sharath on 6/27/15.
 */
public class ClearABit {
    public static void main(String[] args) {
        int c = 10;

        System.out.println("Number being considered is " + Integer.toBinaryString(c));
        System.out.printf("Clearing 0th bit %s %n", Integer.toBinaryString(c & ~1));
        System.out.printf("Clearing 1st bit %s %n", Integer.toBinaryString(c & ~(1 << 1)));
        System.out.printf("Clearing 2nd bit %s %n", Integer.toBinaryString(c & ~(1 << 2)));
        System.out.printf("Clearing 3nd bit %4s %n", Integer.toBinaryString(c & ~(1 << 3)));
    }
}
