package hackerrank.bitwise_operations.cci;

/**
 * Created by sharath on 9/7/15.
 */
public class InsertMIntoN_5_1 {
    public static int clearBitsFromIThroughJ(int n, int i, int j) {
        int bitmask = (~0 << (j + 1)) | ((1 << i) - 1);
        return n & bitmask;
    }

    public static int insertMIntoNFromItoJ(int M, int N, int i, int j) {
        if(i >= 32 || j < i)
            return 0;
        int cleared = clearBitsFromIThroughJ(N, i, j);
        int shifted = M << i;
        System.out.println(Integer.toBinaryString(cleared));
        System.out.println(Integer.toBinaryString(shifted));
        return cleared | shifted;
    }

    public static void main(String[] args) {
        int M = Integer.parseInt("10011", 2);
        int N = Integer.parseInt("10000000000", 2);
        System.out.println(Integer.toBinaryString(insertMIntoNFromItoJ(M, N, 2, 6)));
    }
}
