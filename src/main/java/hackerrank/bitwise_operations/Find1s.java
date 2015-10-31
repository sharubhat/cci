package hackerrank.bitwise_operations;

/**
 * Created by sharath on 6/27/15.
 */
public class Find1s {
    // O(n) solution where n is total number of bits
    public static short ones(long x) {
        short result = 0;
        while(x != 0) {
            result += (x & 1);
            x >>= 1;
        }
        return result;
    }

    // O(s) where s is number of set bits
    // Subtracting 1 toggles all bits from right to left till the leftmost set bit.
    // So if we subtract a number by 1 and bitwise & it with itself, we unset the rightmost set bit.
    // if we do the last operation in a loop, it would run as many times as the number of set bits unsetting them
    // from right to left until there are no more set bits.
    public static long onesBetter(long x) {
        long count = 0L;
        while(x > 0) {
            x = x & (x-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.printf("Number of 1s in 1 - %d  %d%n", ones(1), onesBetter(1));
        System.out.printf("Number of 1s in 2 - %d  %d%n", ones(2), onesBetter(2));
        System.out.printf("Number of 1s in 3 - %d  %d%n", ones(3), onesBetter(3));
        System.out.printf("Number of 1s in 4 - %d  %d%n", ones(4), onesBetter(4));
        System.out.printf("Number of 1s in 1023 - %d  %d%n", ones(1023), onesBetter(1023));
    }
}
