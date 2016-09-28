package hackerrank.bitwise_operations.epi;

/**
 * To get the two's complement negative notation of an integer, you write out the number in binary.
 * You then invert the digits, and add one to the result.
 * -1 = -(1) = 11111111111111111111111111111110 + 1 = 11111111111111111111111111111111
 *
 * All zeros with 1 in MSB(most significant bit) represents Integer.MIN_VALUE
 *
 * Created by sharath on 6/4/16.
 */
public class BitsJava7 {
    public static void main(String[] args) {
        System.out.println(0b01111111111111111111111111111111); // prints Integer.MAX_VALUE
        System.out.println(0b11111111111111111111111111111111); // prints -1
        System.out.println(0b00000000000010000000000000000000);
        System.out.println(0b10000000000000000000000000000000);
        System.out.print("Zero : ");
        System.out.println(0b0);
        System.out.print("One : ");
        System.out.println(0b1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int bits2 = 0b1000001;
        int bits1 = 0b1111111;
        bits2 &= bits1;

        System.out.println(bits1);
        System.out.println(Integer.toBinaryString(bits2));
    }
}
