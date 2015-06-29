package epibook.chap15_BST;

/**
 * Created by sharath on 6/29/15.
 */
public class BinaryTreePrototypeTemplate {
    public static class BTNode<T> {
        private T data;
        private BTNode<T> left, right;

        public BTNode() {}

        public BTNode(T data) { this.data = data; }

        public BTNode(T data, BTNode<T> left,
                              BTNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() { return data; }

        public void setData(T data) { this.data = data; }

        public BTNode<T> getLeft() { return left; }

        public void setLeft(BTNode<T> left) { this.left = left; }

        public BTNode<T> getRight() { return right; }

        public void setRight(BTNode<T> right) { this.right = right; }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            BTNode that = (BTNode)o;

            if (data != null ? !data.equals(that.data) : that.data != null) {
                return false;
            }
            if (left != null ? !left.equals(that.left) : that.left != null) {
                return false;
            }
            if (right != null ? !right.equals(that.right) : that.right != null) {
                return false;
            }

            return true;
        }
    }
}
