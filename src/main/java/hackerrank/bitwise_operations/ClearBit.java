package hackerrank.bitwise_operations;

/**
 * Created by sharath on 9/7/15.
 */
public class ClearBit {
    public static int clearBit(int n, int i) {
        return (n & ~(1 << i));
    }

    public static int clearBitsMSBThroughI(int n, int i) {
        int bitmask = (1 << i) - 1;
        return n & bitmask;
    }

    public static int clearBitsFromIThrough0(int n, int i) {
        int bitmask = ~((1 << (i+1)) - 1);
        return n & bitmask;
    }

    // assume i < j
    public static int clearBitsFromIThroughJ(int n, int i, int j) {
        // 11111111111111111111111111000000 | 11 -> 11111111111111111111111111000011
        int bitmask = (~0 << (j + 1)) | ((1 << i) - 1);
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(255));
        System.out.println(Integer.toBinaryString(clearBit(255, 2)));
        System.out.println(Integer.toBinaryString(clearBitsMSBThroughI(255, 2)));
        System.out.println(Integer.toBinaryString(clearBitsFromIThrough0(255, 2)));
        System.out.println(Integer.toBinaryString(clearBitsFromIThroughJ(250, 2, 5)));
    }
}
