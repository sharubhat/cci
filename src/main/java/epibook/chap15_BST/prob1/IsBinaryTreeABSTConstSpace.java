package epibook.chap15_BST.prob1;

import epibook.chap15_BST.BinaryTreePrototypeTemplate.BinaryTreeNode;

/**
 * TODO: Pending implementation.
 * Created by sharath on 6/29/15.
 */
public class IsBinaryTreeABSTConstSpace {

    private static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        return false;
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(3);
        tree.setLeft(new BinaryTreeNode<>(2));
        tree.getLeft().setLeft(new BinaryTreeNode<>(1));
        tree.setRight(new BinaryTreeNode<>(5));
        tree.getRight().setLeft(new BinaryTreeNode<>(4));
        tree.getRight().setRight(new BinaryTreeNode<>(6));
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
