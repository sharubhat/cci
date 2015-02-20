package heap;

/**
 * Created by sharath on 1/22/15.
 */
public class HeapAdaptablePQ<K extends Comparable<K>, V>
        extends HeapPQ<K, V> implements AdaptablePQ<K, V>{

    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        private int index;

        public AdaptablePQEntry(K key, V value, int index) {
            super(key, value);
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    protected void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K, V>)heap.get(i)).setIndex(i); // reset entry's index
        ((AdaptablePQEntry<K, V>)heap.get(j)).setIndex(j);
    }

    protected void bubble(int j) {
        if(j > 0 && heap.get(j).getKey().compareTo(heap.get(parent(j)).getKey()) < 0)
            upheap(j);
        else
            downheap(j);
    }

    /**
     * Removes the given entry from priority queue as opposed to removing min
     */
    @Override
    public Entry<K, V> remove(Entry<K, V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        int j = locator.getIndex();
        if(j == heap.size() - 1)
            heap.remove(heap.size() - 1);
        else {
            swap(j, heap.size() - 1);
            heap.remove(heap.size() -1);
            bubble(j);
        }
        return entry;
    }

    private AdaptablePQEntry<K, V> validate(Entry<K, V> entry) {
        for(Entry<K, V> e: heap) {
            if(e.getKey().compareTo(entry.getKey()) == 0)
                return (AdaptablePQEntry<K, V>)e;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Creates a priority queue initialized with the given key-value pairs.
     *
     * @param keys
     * @param values
     */
    public HeapAdaptablePQ(K[] keys, V[] values) {
        super(keys, values);
    }

    @Override
    public K replaceKey(Entry<K, V> e, K key) {
        AdaptablePQEntry<K, V> locator = validate(e);
        locator.setKey(key);
        return key;
    }

    @Override
    public V replaceValue(Entry<K, V> e, V value) {
        AdaptablePQEntry<K, V> locator = validate(e);
        locator.setValue(value);
        return value;
    }
}
