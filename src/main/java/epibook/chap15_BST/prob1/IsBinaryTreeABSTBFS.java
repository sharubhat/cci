package epibook.chap15_BST.prob1;

import epibook.chap15_BST.BinaryTreePrototypeTemplate.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharath on 6/29/15.
 */
public class IsBinaryTreeABSTBFS {

    public static class QNode {
        public BinaryTreeNode<Integer> node;
        public Integer lower, higher;

        public QNode(BinaryTreeNode<Integer> node, Integer lower, Integer higher) {
            this.node = node;
            this.higher = higher;
            this.lower = lower;
        }
    }

    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        Queue<QNode> BFSQueue = new LinkedList<>();
        BFSQueue.add(new QNode(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while(!BFSQueue.isEmpty()) {
            QNode curr = BFSQueue.remove();
            if(curr.node != null) {
                if(curr.node.getData().compareTo(curr.lower) < 0 ||
                        curr.node.getData().compareTo(curr.higher) > 0) {
                    return false;
                }

                BFSQueue.add(new QNode(curr.node.getLeft(), curr.lower, curr.node.getData()));
                BFSQueue.add(new QNode(curr.node.getRight(), curr.node.getData(), curr.higher));
            }
        }
        return true;
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
