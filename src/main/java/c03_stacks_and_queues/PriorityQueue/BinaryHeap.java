package c03_stacks_and_queues.PriorityQueue;

import java.util.Arrays;

/**
 * Created by sharath on 9/4/14.
 *
 * P.S: Element at 0th position of array is ignored(kept as null) for simplicity. This makes calculation of
 * positions of parent and children simpler.
 * Solution here is for min-heap
 *
 */
public class BinaryHeap<T extends Comparable<T>> implements PriorityQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size;

    /**
     * Constructs a new binary heap
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap() {
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds a value to the min-heap
     * @param value
     */
    @Override
    public void add(T value) {
        // grow array if needed
        if(size >= array.length - 1)
            array = resize();

        // place element into heap bottom
        array[++size] = value;
        bubbleUp();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new IllegalStateException("Heap is empty");
        return array[1];
    }

    @Override
    public T remove() {
        T result = peek();

        // get rid of the last leaf
        array[1] = array[size];
        array[size--] = null;
        bubbleDown();

        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Performs bubble up operation to place a newly inserted element in it's correct place so that heap maintains the
     * min-heap order property.
     */
    protected void bubbleUp() {
        int index = this.size - 1;
        while(hasParent(index) && parent(index).compareTo(array[index]) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    /**
     * Performs bubble down operation to place the element that is at the root of the heap in its correct place so that
     * the heap maintains the min-heap order property.
     */
    protected void bubbleDown() {
        int index = 1;

        while(hasLeftChild(index)) {
            // which of the children is smaller?
            int smallerChild = leftIndex(index);

            // bubble with the smaller child, if parent has a smaller child
            if(hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            }

            if(array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                break;
            }

            // make sure to update loop counter/index of where last element is put
            index = smallerChild;
        }
    }

    protected boolean hasParent(int i) {
        return i > 1;
    }

    protected int leftIndex(int i) {
        return i * 2;
    }

    protected int rightIndex(int i) {
        return i * 2 + 1;
    }

    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }

    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }

    protected T parent(int i) {
        return array[parentIndex(i)];
    }

    protected int parentIndex(int i) {
        return i / 2;
    }

    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> minInts = new BinaryHeap<>();

        minInts.add(13);
        minInts.add(20);
        minInts.add(11);
        minInts.add(44);
        minInts.add(3);
        minInts.add(7);
        minInts.add(9);

        System.out.println(minInts);
        System.out.println(minInts.peek());

        while (!minInts.isEmpty()) {
            System.out.println(minInts.remove());
            System.out.println(minInts);
        }

        System.out.println();
        System.out.println();

        PriorityQueue<String> minStrs = new BinaryHeap<>();
        minStrs.add("Kona");
        minStrs.add("Daisy");
        minStrs.add("Meghan");
        minStrs.add("Martin");

        System.out.println(minStrs);

        while (!minStrs.isEmpty()) {
            System.out.println(minStrs.remove());
        }

        System.out.println();
    }
}
