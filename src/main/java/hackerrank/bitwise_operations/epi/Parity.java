package hackerrank.bitwise_operations.epi;

/**
 * Parity of a word is 1 if number of set bits in it is odd, 0 if it's even.
 *
 * Created by sharath on 10/18/15.
 */
public class Parity {
    static final int WORD_SIZE = 16;
    static final int BIT_MASK = 0xFFFF;

    public static short parity(int x) {
        short res = 0;
        while(x > 0) {
            res ^= 1;
            x &= (x - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        short[] map = createLookupTable();
        for(int i = 0; i < 100; i++) {
            System.out.printf("Parity of %d (%s) is : %d - %d%n", i, Integer.toBinaryString(i), parity(i), parityFaster(i, map));
        }
    }

    private static short parityFaster(long i, short[] map) {
        return (short)
                (map[(int)((i >>> (WORD_SIZE * 3)) & BIT_MASK)] ^
                        map[(int)((i >>> (WORD_SIZE * 2)) & BIT_MASK)] ^
                        map[(int)((i >>> WORD_SIZE) & BIT_MASK)] ^
                        map[(int)(i & BIT_MASK)]);
    }

    private static short[] createLookupTable() {
        short[] map = new short[1 << WORD_SIZE];
        for(int i = 0; i < (1 << WORD_SIZE); i++) {
            map[i] = parity(i);
        }
        return map;
    }
}
