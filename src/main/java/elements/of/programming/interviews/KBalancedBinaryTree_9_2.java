package elements.of.programming.interviews;

/**
 * Created by sharath on 1/13/15.
 */
public class KBalancedBinaryTree_9_2 {
    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTree<Integer> root = new BinaryTree<>(3);
        root.setLeft(new BinaryTree<>(2));
        root.getLeft().setLeft(new BinaryTree<>(1));
        root.setRight(new BinaryTree<>(5));
        root.getRight().setLeft(new BinaryTree<>(4));
        root.getRight().setRight(new BinaryTree<>(6));
        int k = 0;
        BinaryTree<Integer> ans = findNonKBalancedNode(root, k);
        assert (ans.getData().equals(2));
        System.out.println(ans.getData());
    }

    private static <T> BinaryTree<T> findNonKBalancedNode(BinaryTree<T> n, int k) {
        return findNonKBalancedNodeHelper(n, k).getFirst();
    }

    private static <T> Touple<BinaryTree<T>, Integer> findNonKBalancedNodeHelper(BinaryTree<T> n, int k) {
        if(n == null) {
            return new Touple<>(null, 0);
        }

        Touple<BinaryTree<T>, Integer> L = findNonKBalancedNodeHelper(n.getLeft(), k);
        if(L.getFirst() != null) {
            return L;
        }

        Touple<BinaryTree<T>, Integer> R = findNonKBalancedNodeHelper(n.getRight(), k);
        if(L.getFirst() != null) {
            return R;
        }

        int nodeNum = L.getSecond() + R.getSecond() + 1;
        if(Math.abs(L.getSecond() - R.getSecond()) > k) {
            return new Touple<>(n, nodeNum);
        }
        return new Touple<>(null, nodeNum);
    }
}
