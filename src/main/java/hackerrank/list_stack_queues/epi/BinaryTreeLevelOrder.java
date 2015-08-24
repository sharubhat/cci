package hackerrank.list_stack_queues.epi;

import java.util.*;

/**
 * Given a binary tree, return an array consisting of the keys.
 * Keys should appear in the order of the corresponding nodes’ depths,
 * breaking ties from left to right.
 *
 * Created by sharath on 8/24/15.
 */
public class BinaryTreeLevelOrder {
    private static class BinaryTreeNode<E> {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private E data;

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public BinaryTreeNode(E data) {
            this.data = data;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }

    public static List<List<Integer>> btDepthOrder(BinaryTreeNode<Integer> tree) {
        Queue<BinaryTreeNode<Integer>> processingNodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        processingNodes.add(tree);
        int numNodesToProcessAtCurrLevel = processingNodes.size();
        List<Integer> currLevel = new ArrayList<>();
        while(processingNodes != null) {
            BinaryTreeNode<Integer> curr = processingNodes.poll();
            --numNodesToProcessAtCurrLevel;
            if(curr != null) {
                currLevel.add(curr.getData());
                processingNodes.add(curr.getLeft());
                processingNodes.add(curr.getRight());
            }
            if(numNodesToProcessAtCurrLevel == 0) {
                numNodesToProcessAtCurrLevel = processingNodes.size();
                result.add(currLevel);
                currLevel.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //      3
        //    2   5
        //  1    4 6
        // 10
        // 13
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(3);
        tree.setLeft(new BinaryTreeNode<>(2));
        tree.getLeft().setLeft(new BinaryTreeNode<>(1));
        tree.getLeft().getLeft().setLeft(new BinaryTreeNode<>(10));
        tree.getLeft().getLeft().getLeft().setRight(new BinaryTreeNode<>(13));
        tree.setRight(new BinaryTreeNode<>(5));
        tree.getRight().setLeft(new BinaryTreeNode<>(4));
        tree.getRight().setRight(new BinaryTreeNode<>(6));
        List<List<Integer>> result = btDepthOrder(tree);
        List<List<Integer>> goldenRes = new ArrayList<>();
        goldenRes.add(Arrays.asList(3));
        goldenRes.add(Arrays.asList(2, 5));
        goldenRes.add(Arrays.asList(1, 4, 6));
        goldenRes.add(Arrays.asList(10));
        goldenRes.add(Arrays.asList(13));
        goldenRes.add(new ArrayList());
        System.out.println(goldenRes.equals(result));
        System.out.println(result);
    }


}
