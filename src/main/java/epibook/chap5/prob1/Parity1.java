package epibook.chap5.prob1;

/**
 * A number AND 1 gives the last bit. (x >> 1) moves bits by one.
 * Put them in a loop until the number becomes 0 and that's how we can examine each bit right to left.
 *
 * Parity of a number is 1 is the number of bits set to 1 is odd.
 * While counting total number of 1's in a number, we have seen that adding result of each AND gives total count.
 * Here instead off adding them, we could XOR the result which alternates between 0 and 1 based on occurrence.
 *
 * Created by sharath on 6/27/15.
 */
public class Parity1 {
    public static short parity(long x) {
        short result = 0;
        while(x != 0) {
            result ^= (x & 1);
            x >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parity(2));
        System.out.println(parity(1));
        System.out.println(parity(3));
        System.out.println(parity(4));
    }
}
