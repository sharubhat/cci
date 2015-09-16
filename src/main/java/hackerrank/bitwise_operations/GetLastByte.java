package hackerrank.bitwise_operations;

/**
 * Created by sharath on 9/7/15.
 */
public class GetLastByte {
    public static int getLastByte(int n) {
        return n & ((1 << 8) - 1);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((1 << 8) - 1));
        System.out.println(Integer.toBinaryString(258));
        System.out.println(Integer.toBinaryString(getLastByte(258)));
        System.out.println(Integer.toBinaryString(getLastByte(255)));
        System.out.println(Integer.toBinaryString(getLastByte(100)));
        System.out.println(Integer.toBinaryString(getLastByte(10)));
    }
}
