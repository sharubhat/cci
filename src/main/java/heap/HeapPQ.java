package heap;

import java.util.ArrayList;

/**
 * Created by sharath on 1/22/15.
 * <p/>
 * size(), isEmpty(), min() take O(1) time
 * insert() and removeMin() take O(log n)* time -> * amortized if using dynamic array
 */
public class HeapPQ<K extends Comparable<K>, V> extends AbstractPQ<K, V> {

    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (heap.get(j).getKey().compareTo(heap.get(p).getKey()) >= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    protected void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (heap.get(leftIndex).getKey().compareTo(heap.get(rightIndex).getKey()) > 0) {
                    smallChildIndex = rightIndex;
                }
                if (heap.get(smallChildIndex).getKey().compareTo(heap.get(j).getKey()) >= 0) {
                    swap(j, smallChildIndex);
                }
            }
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        downheap(0);
        return answer;
    }


    // Bottom up heap construction

    /**
     * Creates a priority queue initialized with the given key-value pairs.
     */
    public HeapPQ(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++)
            heap.add(new PQEntry<>(keys[j], values[j]));
        heapify();
    }

    /**
     * Performs a bottom-up construction of the heap in linear time.
     */
    protected void heapify() {
        int startIndex = parent(size() - 1); // start at PARENT of last entry
        for (int j = startIndex; j >= 0; j--) // loop until processing the root
            downheap(j);
    }
}
