package c04_trees_and_graphs.trees.bst_generic;

/**
 * Created by sharath on 1/23/15.
 */
public class BinarySearchTreeWithRotate<E extends Comparable<E>>
        extends BinarySearchTree<E> {

    public BinarySearchTreeWithRotate(BinarySearchTree.BSTBuilder<E> builder) {
        super(builder);
    }

    protected Node<E> rotateRight(Node<E> root) {
        Node<E> temp = root.getLeft();
        root.setLeft(temp.getRight());
        temp.setRight(root);
        return temp;
    }

    protected Node<E> rotateLeft(Node<E> root) {
        Node<E> temp = root.getRight();
        root.setRight(temp.getLeft());
        temp.setLeft(root);
        return temp;
    }
}
