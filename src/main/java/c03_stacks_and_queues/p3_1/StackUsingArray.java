package c03_stacks_and_queues.p3_1;

import java.util.EmptyStackException;

/**
 * Created by sharath on 8/8/14.
 *
 * Problem description:
 * Use an array which works as 3 independent stacks
 *
 * Questions to ask:
 * 1. Are the stacks of fixed size? If not, problem gets more complicated
 *
 */
public class StackUsingArray {
    private final int size;
    private int[] store;
    private int[] index = new int[]{-1, -1, -1};
    public StackUsingArray(int size) {
        this.size = size;
        this.store = new int[size];
    }

    public boolean push(int stackNum, int item) {
        if(exists(stackNum, item))
            return false;
        ensureCapacity(stackNum);
        store[size / 3 * (stackNum - 1) + (index[stackNum - 1]++) + 1] = item;
        return true;
    }

    private void ensureCapacity(int stackNum) {
        if(index[stackNum - 1] >= (size / 3 - 1))
            throw new StackOverflowError("Fixed size stack");
    }

    private boolean exists(int stackNum, int item) {
        for(int i = size / 3 * (stackNum - 1); i < size / 3 * stackNum; i++) {
            if(store[i] == item)
                return true;
        }
        return false;
    }

    public int size(int stackNum) {
        return index[stackNum - 1] + 1;
    }

    public int pop(int stackNum) {
        int stackIndex = index[stackNum - 1];
        if(stackIndex == -1)
            throw new EmptyStackException();
        int item = store[size / 3 * (stackNum - 1) + stackIndex];
        index[stackNum - 1]--;
        return item;
    }

    public int peek(int stackNum) {
        int stackIndex = index[stackNum - 1];
        if(stackIndex == -1)
            throw new EmptyStackException();
        return store[size / 3 * (stackNum - 1) + stackIndex];
    }

    public boolean empty(int stackNum) {
        return index[stackNum - 1] == -1;
    }
}
