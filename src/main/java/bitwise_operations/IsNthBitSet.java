package bitwise_operations;

/**
 * Check if a bit at position n is set.
 *
 * We know the logic to set a bit at position n. i.e. to OR it with (1 << n).
 * Also, we know the logic to check if the last bit is set(even or odd logic) which is to AND with 1.
 *
 * Combining both techniques, we can and given number with (1<<n). But the result will not be 1,
 * instead it will be a number with exactly nth bit set.
 * So, compare the result with (1 << n) and if they are equal, we know the bit is set in original number.
 *
 * Created by sharath on 6/27/15.
 */
public class IsNthBitSet {

    public static void main(String[] args) {
        int c = 10;

        System.out.println("Number being considered is " + Integer.toBinaryString(c));
        System.out.println("Is 0th bit set?" + ((c & 1) == 1));
        System.out.println("Is 1st bit set?" + ((c & (1 << 1)) == (1 << 1)));
        System.out.println("Is 2nd bit set?" + ((c & (1 << 2)) == (1 << 2)));
        System.out.println("Is 3rd bit set?" + ((c & (1 << 3)) == (1 << 3)));
    }
}
