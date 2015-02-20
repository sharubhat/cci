package c04_trees_and_graphs.trees.bst_generic;

/**
 * Created by sharath on 1/23/15.
 */
public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {

    public AVLTree(BSTBuilder<E> builder) {
        super(builder);
    }

    protected static class ALVNode<E extends Comparable<E>> extends Node<E> {
        public static final int LEFT_HEAVY = -1;
        public static final int BALANCED = 0;
        public static final int RIGHT_HEAVY = 1;

        private int balance;

        public ALVNode(E data) {
            super(data);
            balance = BALANCED;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return this.balance + ": " + super.toString();
        }
    }

    private boolean inscrease;


}
