package hackerrank.bitwise_operations;

/**
 * Created by sharath on 9/7/15.
 */
public class GetBit {
    public boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
