package hackerrank.trees.epi;

/**
 * Created by sharath on 9/15/15.
 */
public class SymmetricBinaryTree {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void print(Node n) {
        System.out.print(n.data + " ");
    }

    public static boolean isSymmetric(Node tree) {
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(Node left, Node right) {
        // if either of them is true and other is false, ^ returns true
        if(left == null ^ right == null)
            return false;
        else {
            if(left == null && right == null)
                return true;
            else {
                return left.data == right.data &&
                        checkSymmetric(left.left, right.right) &&
                        checkSymmetric(left.right, right.left);
            }
        }
    }

    public static void main(String[] args) {

    }
}
