package string.patternmatch;

/**
 * Created by sharath on 1/24/15.
 *
 * Ternary search trie
 */
public class TST<V> {

    protected static class Node<V> {
        char entry;
        Node<V> left, mid, right;
        V val;
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
        char c = key.charAt(d);
        if(c < curr.entry)
            return get(curr.left, key, d);
        else if(c > curr.entry)
            return get(curr.right, key, d);
        else if(d < key.length() - 1)
            return get(curr.mid, key, d + 1);
        else
            return curr;
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    protected Node<V> put(Node<V> curr, String key, V value, int d) {
        char c = key.charAt(d);
        if(curr == null) {
            curr = new Node<>();
            curr.entry = c;
        }
        if(c < curr.entry) {
            curr.left = put(curr.left, key, value, d);
        } else if(c > curr.entry) {
            curr.right = put(curr.right, key, value, d);
        } else if(d < key.length() - 1) {
            curr.mid = put(curr.mid, key, value, d + 1);
        } else {
            curr.val = value;
        }
        return curr;
    }
}
