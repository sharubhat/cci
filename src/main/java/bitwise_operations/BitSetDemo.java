package bitwise_operations;

import java.util.BitSet;

/**
 * Created by sharath on 8/5/15.
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();

        // setting some bits
        System.out.println(bits1.length());
        for(int i = 0; i < 16; i++) {
            if(i % 2 == 0) bits1.set(i);
            if(i % 5 != 0) bits2.set(i);
        }
        System.out.println(bits1.length());

        System.out.println("Initial pattern in bits1:");
        System.out.println(bits1);
        System.out.println("Initial pattern in bits2:");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println("bits2 AND bits1: ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println("bits2 OR bits1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("bits2 XOR bits1: ");
        System.out.println(bits2);
    }
}
