package heap;

/**
 * Created by sharath on 1/22/15.
 */
public interface AdaptablePQ<K extends Comparable<K>, V> extends PQ<K, V> {
    public Entry<K, V> remove(Entry<K, V> e);
    public K replaceKey(Entry<K, V> e, K key);
    public V replaceValue(Entry<K, V> e, V value);
}
