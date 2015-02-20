package c04_trees_and_graphs.trees.bst_generic;

/**
 * Created by sharath on 1/15/15.
 */
public class BinaryTree<E extends Comparable<E>> {
    protected static class Node<E extends Comparable<E>> {
        private E data;
        private Node<E> right;
        private Node<E> left;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    protected Node<E> root;
    public BinaryTree() {
        this.root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node(data);
        if(leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if(rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    public BinaryTree<E> getLeftSubTree() {
        if(root != null && root.left != null)
            return new BinaryTree(root.left);
        else
            return null;
    }

    public BinaryTree<E> getRightSubTree() {
        if(root != null && root.right != null)
            return new BinaryTree(root.right);
        else
            return null;
    }

    public E getData() {
        return root.getData();
    }

    public boolean isLeaf() {
        return root != null && root.left == null && root.right == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        return sb.toString();
    }

    public void preOrderTraversal(Node<E> node, StringBuilder sb) {
        if(node != null) {
            sb.append(node.toString()).append(" ");
            if(node.left != null)
                preOrderTraversal(node.left, sb);
            if(node.right != null)
                preOrderTraversal(node.right, sb);
        }
    }
}
