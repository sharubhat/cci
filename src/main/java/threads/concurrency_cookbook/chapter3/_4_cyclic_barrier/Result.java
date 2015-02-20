package threads.concurrency_cookbook.chapter3._4_cyclic_barrier;

/**
 * Created by sharath on 2/4/15.
 */
public class Result {
    private int data[];

    public Result(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
