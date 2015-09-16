package hackerrank.bitwise_operations;

/**
 * Created by sharath on 6/27/15.
 */
public class Find1s {
    public static short ones(long x) {
        short result = 0;
        while(x != 0) {
            result += (x & 1);
            x >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Number of 1s in 1 - " + ones(1));
        System.out.println("Number of 1s in 2 - " + ones(2));
        System.out.println("Number of 1s in 3 - " + ones(3));
        System.out.println("Number of 1s in 4 - " + ones(4));
        System.out.println("Number of 1s in 1023 - " + ones(1023));
    }
}
