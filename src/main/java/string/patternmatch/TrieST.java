package string.patternmatch;

/**
 * Created by sharath on 1/24/15.
 *
 * Array of 256 is preferred over arraylist.
 * However, we will be allocating 256 bytes array for every node.
 * So, if w is average length of key, then space required is RNw.
 */
public class TrieST<V> {
    private static final int R = 256;

    protected static class Node<V> {
        private V val;
        private Node<V>[] next = new Node[R];
    }

    private Node<V> root;

    public V get(String key) {
        Node<V> x = get(root, key, 0);
        if(x == null)
            return null;
        return x.val;
    }

    protected Node<V> get(Node<V> curr, String key, int d) {
        if(curr == null)
            return null;
        if(d == key.length())
            return curr;
        char c = key.charAt(d); // use dth char to identify sub-trie
        return get(curr.next[c], key, d + 1);
    }

    public void put(String key, V value) {
        root = put(root, key, value, 0);
    }

    protected Node<V> put(Node<V> curr, String key, V value, int d) {
        if(curr == null)
            return null;
        if(d == key.length()) {
            curr.val = value;
            return curr;
        }
        char c = key.charAt(d);
        curr.next[c] = put(curr.next[c], key, value, d+1);
        return curr;
    }
}
