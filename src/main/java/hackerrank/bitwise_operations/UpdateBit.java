package hackerrank.bitwise_operations;

/**
 * Created by sharath on 9/7/15.
 */
public class UpdateBit {
    public int updateBitAtIByV(int n, int i, int v) {
        int bitmask = ~(1 << i);
        return (n & bitmask) | (v << i);
    }
}
