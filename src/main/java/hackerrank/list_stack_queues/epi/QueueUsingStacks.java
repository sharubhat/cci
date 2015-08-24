package hackerrank.list_stack_queues.epi;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by sharath on 8/24/15.
 */
public class QueueUsingStacks<E> {
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();

    public void enqueue(E e) {
        s1.push(e);
    }

    public E dequeue() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if(!s2.isEmpty()) {
            return s2.pop();
        }
        throw new NoSuchElementException("Empty queue");
    }
}
