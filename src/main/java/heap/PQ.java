package heap;

/**
 * Created by sharath on 1/22/15.
 */
public interface PQ<K, V> {
    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
}
