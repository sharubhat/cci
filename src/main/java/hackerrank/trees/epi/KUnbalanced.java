package hackerrank.trees.epi;

/**
 * Created by sharath on 9/15/15.
 */
public class KUnbalanced {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair<F, S> {
        final F first;
        final S second;
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void print(Node n) {
        System.out.print(n.data + " ");
    }

    public static Node findUnbalanced(Node root, int k) {
        Node found = null;
        findUnbalancedHelper(root, k, found);
        return found;
    }

    private static Pair<Integer, Boolean> findUnbalancedHelper(Node root, int k, Node found) {
        int countLeft = 0, countRight = 0;
        boolean isBalancedLeft = true, isBalancedRight = true;

        if (root.left != null) {
            Pair<Integer, Boolean> returnLeft = findUnbalancedHelper(root.left, k, found);
            if (returnLeft == null)
                return null;
            countLeft = returnLeft.first;
            isBalancedLeft = returnLeft.second;
        }
        if (root.right != null) {
            Pair<Integer, Boolean> returnRight = findUnbalancedHelper(root.right, k, found);
            if (returnRight == null)
                return null;
            countRight = returnRight.first;
            isBalancedRight = returnRight.second;
        }
        System.out.println(String.format("root=%s, countLeft=%s, countRight=%s, isBalancedLeft=%s, isBalancedRight=%s, found=%s", root, countLeft, countRight, isBalancedLeft, isBalancedRight, found));
        if (Math.abs(countLeft - countRight) <= k) {
            // we are k-balanced
            return new Pair<>(countLeft + countRight + 1, true);
        } else if (isBalancedLeft && isBalancedRight) {
            // we are k-unbalanced, our children are both k-balanced
            found = root;
        }
        // we are k-unbalanced, either/both children are k-unbalanced
        return new Pair<>(countLeft + countRight + 1, false);
    }

}
