package epibook.chap15_BST.prob1;

import epibook.chap15_BST.BinaryTreePrototypeTemplate.BinaryTreeNode;

/**
 * Slightly complicated solution of comparing each node from root. O(n2) as it repeatedly traverses the node.
 *
 * Created by sharath on 6/29/15.
 */
public class IsBinaryTreeABST {
    private static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areKeysInRange(BinaryTreeNode<Integer> node, Integer low, Integer high) {
        if(node == null)
            return true;
        else if(node.getData().compareTo(low) < 0 || node.getData().compareTo(high) > 0)
            return false;

        return areKeysInRange(node.getLeft(), low, node.getData()) &&
                areKeysInRange(node.getRight(), node.getData(), high);
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
