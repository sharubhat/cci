package hackerrank.list_stack_queues.epi;

import java.util.Stack;

/**
 * Created by sharath on 8/22/15.
 */
public class StackWithMax<E extends Comparable> extends Stack<E> {
    Stack<E> maxStack;

    public StackWithMax() {
        maxStack = new Stack<>();
    }


    @Override
    public E push(E item) {
        if(!maxStack.empty()) {
            if (item.compareTo(maxStack.peek()) >= 0) {
                maxStack.push(item);
            } else {
                maxStack.push(maxStack.peek());
            }
        } else {
            maxStack.push(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized E pop() {
        maxStack.pop();
        return super.pop();
    }

    @Override
    public synchronized E peek() {
        return super.peek();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    public E max() {
        return maxStack.peek();
    }


    public static void main(String[] args) {
        StackWithMax<Integer> s = new StackWithMax<>();
        s.push(5);
        print(s);

        s.push(2);
        print(s);

        s.push(7);
        print(s);

        s.pop();
        print(s);

        s.push(7);
        print(s);

        s.pop();
        print(s);

        s.push(7);
        print(s);

        s.push(7);
        print(s);

        s.push(9);
        print(s);
        s.pop();
        print(s);

    }

    private static void print(StackWithMax<Integer> s) {
        System.out.print("Peek " + s.peek());
        System.out.println(" Max " + s.max());
    }
}
