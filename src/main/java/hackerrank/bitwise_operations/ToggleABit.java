package hackerrank.bitwise_operations;

/**
 * Toggling a bit at given position means changing the bit at that position from '0' to '1' or '1' to '0'.
 *
 * To toggle a bit, it should be '^' ('XOR'ed) with 1.
 *
 * To get a byte with only bit at nth position 0, we can left shift 1 by n. i.e. (1 << n).
 *
 * Ans: a ^= (1 << n)
 *
 * Assumption : 0 is the least significant bit and n is (n+1)th position from right
 * Created by sharath on 6/27/15.
 */
public class ToggleABit {
    public static void main(String[] args) {
        int c = 10;

        System.out.println("Number being considered is " + Integer.toBinaryString(c));
        System.out.printf("Toggling 0th bit %s %n", Integer.toBinaryString(c ^ 1));
        System.out.printf("Toggling 1st bit %s %n", Integer.toBinaryString(c ^ (1 << 1)));
        System.out.printf("Toggling 2nd bit %s %n", Integer.toBinaryString(c ^ (1 << 2)));
    }
}
