package c03_stacks_and_queues.PriorityQueue;

/**
 * Created by sharath on 9/4/14.
 *
 * An interface that defines the operations for a PrioityQueue ADT for any type.
 */
public interface PriorityQueue<T> {
    /**
     * Adds a value to a priority queue
     */
    void add(T value);

    /**
     * Test if the priority queue is empty
     */
    boolean isEmpty();

    /**
     * Returns, but does not delete the element at the top of the queue
     *
     * @return the element at the top of priority queue
     * @throws java.lang.IllegalStateException if priority queue is empty
     */
    T peek();

    /**
     * Deletes and returns the element at the top of the priority queue
     * @return the element at the top of priority queue
     * @throws java.lang.IllegalStateException if priority queue is empty
     */
    T remove();

}
