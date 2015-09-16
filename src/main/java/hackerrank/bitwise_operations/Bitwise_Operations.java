package hackerrank.bitwise_operations;

/**
 * Created by sharath on 6/27/15.
 */
public class Bitwise_Operations {
    public static void main(String[] args) {
        char c = '1';

        Integer cInt = new Integer(c);

        System.out.println("One byte is 8 bits");
        System.out.printf("Java char is %d bit or %d bytes. -- Character.SIZE or Character.SIZE/8 %n", Character.SIZE, Character.SIZE/8);
        System.out.printf("Java int is %d bit or %d bytes. -- Integer.SIZE %n", Integer.SIZE, Integer.SIZE/8);
        System.out.printf("Java float is %d bit or %d bytes. -- Float.SIZE %n", Float.SIZE, Float.SIZE/8);
        System.out.printf("Java double is %d bit or %d bytes. -- Double.SIZE %n", Double.SIZE, Double.SIZE/8);

        System.out.printf("Number of one-bits in the two's complement " +
                "binary representation of %c is %d -- Integer.bitCount(c) %n", c, Integer.bitCount(c));
        System.out.printf("ASCII value or byte value of %c is %d -- cInt.byteValue() %n", c, cInt.byteValue());

        System.out.println();
        System.out.println("Two ways of printing an integer to binary string :");
        System.out.printf("%d binary representation is %s -- Integer.toBinaryString(c) %n", cInt.byteValue(), Integer.toBinaryString(c));
        System.out.printf("%d binary representation is %s -- Integer.toString(c, 2) %n", cInt.byteValue(), Integer.toString(c, 2));
        System.out.println();

        System.out.printf("%d octal representation is %s -- Integer.toString(c, 8) %n", cInt.byteValue(), Integer.toString(c, 8));

        System.out.println();
        System.out.println("Bitwise complement inverts the bits making '0' a '1' and '1' a '0'.");
        System.out.printf("Bitwise complement of %d in binary is %s -- Integer.toBinaryString(~c) %n", cInt.byteValue(), Integer.toBinaryString(~c));
        System.out.printf("Bitwise complement of %d is %s '~c' %n", cInt.byteValue(), ~c);

        System.out.println();
        System.out.println("Singed left shift (<<), signed right shift (>>), and unsigned right shift (>>>)");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Left shift by n is multiplication by 2 power n and right shift is division.");

        System.out.println("The signed left shift (<<) operator shifts a  bit (or bits) to the left " +
                "by the distance specified in the right operand." +
                "\nIn this case, the leftmost digit is shifted at the end of the register, " +
                "and a new 0 is shifted into the rightmost position. " +
                "\nNo matter, the number is positive or negative; in both of case the leading bit position " +
                "is always filled with a zero.\n");
        System.out.println("Left shift of Integer.MAX_VALUE");
        System.out.printf("\t 01111111111111111111111111111111 or %d by 1 results in %n", Integer.MAX_VALUE);
        System.out.printf("\t %s or %d %n", Integer.toBinaryString(Integer.MAX_VALUE << 1), Integer.MAX_VALUE << 1);
        System.out.printf("\t 01111111111111111111111111111111 or %d by 3 results in %n", Integer.MAX_VALUE);
        System.out.printf("\t %s or %d %n", Integer.toBinaryString(Integer.MAX_VALUE << 3), Integer.MAX_VALUE << 3);

        System.out.println();
        System.out.println("The signed right shift (>>) operator shifts a  bit (or bits) to the right by the distance " +
                "specified in the right operand and fills the left most bit by the sign bit. " +
                "\nIn this case the rightmost bit (or bits) is shifted out, and a new 0 is filled with the sign bit into " +
                "the high-order bits to the left position if the left operand is positive; " +
                "\notherwise 1, if the left operand is negative. This technique is known as sign extension.\n");

        System.out.println("Right shift of Integer.MAX_VALUE");
        System.out.printf("\t '01111111111111111111111111111111' or %d by 1 results in %n", Integer.MAX_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MAX_VALUE >> 1), Integer.MAX_VALUE >> 1);
        System.out.printf("\t '01111111111111111111111111111111' or %d by 3 results in %n", Integer.MAX_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MAX_VALUE >> 3), Integer.MAX_VALUE >> 3);

        System.out.println("Right shift of Integer.MIN_VALUE");
        System.out.printf("\t '10000000000000000000000000000000' or %d by 1 results in %n", Integer.MIN_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MIN_VALUE >> 1), Integer.MIN_VALUE >> 1);
        System.out.printf("\t '10000000000000000000000000000000' or %d by 3 results in %n", Integer.MIN_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MIN_VALUE >> 3), Integer.MIN_VALUE >> 3);

        System.out.println();
        System.out.println("The unsigned right shift (>>>) operator behave like the signed right shift operator. i.e. it shifts a bit (or bits) to the right. " +
                "\nBut unlike (>>) operator, this operator always shifts zeros into the leftmost position by the distance specified in the right operand. " +
                "\nSo the result of applying the >>>operator is always positive.\n");

        System.out.println("Unsigned right shift of Integer.MAX_VALUE");
        System.out.printf("\t '01111111111111111111111111111111' or %d by 1 results in %n", Integer.MAX_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MAX_VALUE >> 1), Integer.MAX_VALUE >> 1);
        System.out.printf("\t '01111111111111111111111111111111' or %d by 3 results in %n", Integer.MAX_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MAX_VALUE >> 3), Integer.MAX_VALUE >> 3);

        System.out.println("Unsigned right shift of Integer.MIN_VALUE");
        System.out.printf("\t '10000000000000000000000000000000' or %d by 1 results in %n", Integer.MIN_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MIN_VALUE >>> 1), Integer.MIN_VALUE >>> 1);
        System.out.printf("\t '10000000000000000000000000000000' or %d by 3 results in %n", Integer.MIN_VALUE);
        System.out.printf("\t '%32s' or %d %n", Integer.toBinaryString(Integer.MIN_VALUE >>> 3), Integer.MIN_VALUE >>> 3);


    }
}
