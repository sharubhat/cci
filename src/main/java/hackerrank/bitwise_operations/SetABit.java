package hackerrank.bitwise_operations;

/**
 * Setting a bit at given position means changing the bit at that position to 1 no matter what it was earlier.
 *
 * To turn a bit with value '1' or '0' to '1', it should be '|' ('bitwise OR'ed) with 1.
 *
 * To get a byte with only bit at nth position 1, we can left shift 1 by n. i.e. (1 << n).
 *
 * Ans: a |= (1 << n)
 *
 * Assumption : 0 is the least significant bit and n is (n+1)th position from right
 *
 * Created by sharath on 6/27/15.
 */
public class SetABit {
    public static void main(String[] args) {
        int c = 10;

        System.out.println("Number being considered is " + Integer.toBinaryString(c));
        System.out.printf("Setting 0th bit %s %n", Integer.toBinaryString(c | 1));
        System.out.printf("Setting 1st bit %s %n", Integer.toBinaryString(c | (1 << 1)));
        System.out.printf("Setting 2nd bit %s %n", Integer.toBinaryString(c | (1 << 2)));
    }

    public int setBit(int n, int i) {
        return (n | (1<<i));
    }
}
