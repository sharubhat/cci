package heap;

/**
 * Created by sharath on 1/22/15.
 */
public abstract class AbstractPQ<K extends Comparable<K>, V> implements PQ<K,V> {

    //-------------nested PQEntry class-----------------
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;
        public PQEntry(K key, V value) {
            this.k = key;
            this.v = value;
        }

        public K getKey() {
            return k;
        }

        public void setKey(K k) {
            this.k = k;
        }

        public V getValue() {
            return v;
        }

        public void setValue(V v) {
            this.v = v;
        }
    }
    //-------------end of nested PQEntry class-----------------

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
