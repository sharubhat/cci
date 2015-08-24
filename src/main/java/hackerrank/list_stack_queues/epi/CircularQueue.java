package hackerrank.list_stack_queues.epi;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Created by sharath on 8/24/15.
 */
public class CircularQueue<E> {
    private static int head = 0, tail = 0, size = 0;
    private static final int SCALE_FACTOR = 2;
    private E[] entries;

    public CircularQueue(int defaultCapacity) {
        this.entries = (E[]) new Object[defaultCapacity];
    }

    // Amortized time complexity of enqueue is O(1)
    public void enqueue(E e) {
        if(size == entries.length) {
            // this modifies the underlying array as long as it's not an array of primitives.
            Collections.rotate(Arrays.asList(entries), -head);
            head = 0;
            tail = size;
            entries = Arrays.copyOf(entries, size * SCALE_FACTOR);
        }

        entries[tail] = e;
        tail = (tail+1) % entries.length;
        ++size;
    }

    // time complexity of dequeue is O(1)
    public E dequeue() {
        if(size == 0) {
            throw new NoSuchElementException("Empty queue");
        }
        --size;
        E e = entries[head];
        head = (head+1) % entries.length;
        return e;
    }

    public int size() {
        return size;
    }
}
