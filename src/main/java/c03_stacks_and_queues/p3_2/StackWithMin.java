package c03_stacks_and_queues.p3_2;

import java.util.Stack;

/**
 * Created by sharath on 8/9/14.
 *
 * Problem description:
 * Design a stack with min that returns min element
 *
 * push, pop, min should work in O(1)
 *
 * Note: Min changes both on push and pop
 * Questions to ask:
 * 1. Is it okay to use java.util.Stack ?
 *    If not, use two linked lists that work like stack
 */
public class StackWithMin extends Stack<Integer> {
    private Stack<Integer> min;
    public StackWithMin() {
        min = new Stack<>();
    }

    public int push(int item) {
        if(min.isEmpty())
            min.push(item);
        else {
            if(item <= min()) {
                min.push(item);
            }
        }
        return super.push(item);
    }

    public Integer pop() {
        if(peek() == min()) {
            min.pop();
        }
        return super.pop();
    }

    public int min() {
        return min.peek();
    }

    @Override
    public boolean equals(Object that) {
        return super.equals(that);
    }
}
