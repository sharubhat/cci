package epibook.chap15_BST.prob1;

import epibook.chap15_BST.BinaryTreePrototypeTemplate.BTNode;

/**
 * TODO: Pending implementation.
 * Created by sharath on 6/29/15.
 */
public class IsBinaryTreeABSTConstSpace {

    private static boolean isBinaryTreeBST(BTNode<Integer> tree) {
        return false;
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
        // should output true.
        assert isBinaryTreeBST(tree);
        System.out.println(isBinaryTreeBST(tree));
        // 10
        // 2 5
        // 1 4 6
        tree.setData(10);
        // should output false.
        assert !isBinaryTreeBST(tree);
        System.out.println(isBinaryTreeBST(tree));
        // should output true.
        assert isBinaryTreeBST(null);
        System.out.println(isBinaryTreeBST(null));
    }
}
