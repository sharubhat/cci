package epibook.chap15_BST.prob4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import epibook.chap15_BST.BinaryTreePrototypeTemplate.BTNode;

/**
 * Return K largest elements in reverse order.
 *
 * Created by sharath on 6/29/15.
 */
public class FindKLargestBST {

    private static List<Integer> findKLargestInBST(BTNode<Integer> tree, int k) {
        List<Integer> result = new ArrayList<>();
        findKLargestInBSTRec(tree, k, result);
        return result;
    }

    private static void findKLargestInBSTRec(
            BTNode<Integer> tree, int k, List<Integer> result) {
        if(tree != null && result.size() < k) {
            findKLargestInBSTRec(tree.getRight(), k, result);
            if(result.size() < k) {
                result.add(tree.getData());
                findKLargestInBSTRec(tree.getLeft(), k, result);
            }
        }
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BTNode<Integer> tree = new BTNode<>(3);
        tree.setLeft(new BTNode<>(2));
        tree.getLeft().setLeft(new BTNode<>(1));
        tree.setRight(new BTNode<>(5));
        tree.getRight().setLeft(new BTNode<>(4));
        tree.getRight().setRight(new BTNode<>(6));
        Random r = new Random();
        int k;
        if (args.length == 1) {
            k = Integer.parseInt(args[0]);
        } else {
            k = r.nextInt(6) + 1;
        }
        System.out.println("k = " + k);
        List<Integer> ans = findKLargestInBST(tree, k);
        System.out.println(ans);
        for (int i = 1; i < ans.size(); ++i) {
            assert(ans.get(i - 1) >= ans.get(i));
        }
    }
}
