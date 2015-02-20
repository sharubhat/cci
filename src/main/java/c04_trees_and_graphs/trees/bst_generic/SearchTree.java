package c04_trees_and_graphs.trees.bst_generic;

/**
 * Created by sharath on 1/15/15.
 */
public interface SearchTree<E extends Comparable<E>> {
    void add(E item);
    boolean contains(E target);
    E find(E target);
    E delete(E target);
    boolean remove(E target);
}
