package hackerrank.trees.homework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given in-order and pre-order traversal results of a BST as arrays, write a function to rebuild the tree.
 *
 * Created by sharath on 9/14/15.
 */
public class RebuildTree {

    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    static void constructTree(int[] iInOrderArray, int[] iPreOrderArray) {
        Map<Integer, Integer> lookupTable = buildLookupTable(iInOrderArray);
        int len = iInOrderArray.length;
        Node bstRoot = constructTreeHelper(iInOrderArray, 0, len - 1, iPreOrderArray, 0, len - 1, lookupTable);
        levelOrder(bstRoot);
    }

    private static Map<Integer, Integer> buildLookupTable(int[] iInOrderArray) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < iInOrderArray.length; i++) {
            map.put(iInOrderArray[i], i);
        }
        return map;
    }

    private static Node constructTreeHelper(int[] in, int inStart, int inEnd,
                                            int[] pre, int preStart, int preEnd,
                                            Map<Integer, Integer> lookupTable) {
        if (inStart <= inEnd) {
            Node root = new Node(pre[preStart]);
            int rootIndex = lookupTable.get(pre[preStart]);
            int len = rootIndex - inStart;
            root.left = constructTreeHelper(in, inStart, rootIndex - 1, pre, preStart + 1, preStart + len, lookupTable);
            root.right = constructTreeHelper(in, rootIndex + 1, inEnd, pre, preStart + len + 1, preEnd, lookupTable);
            return root;
        }
        return null;
    }

    public static void levelOrder(Node root) {
        if(root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int nodesInCurrentLevel = 1;
            int nodesInNextLevel = 0;
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                nodesInCurrentLevel--;
                if(node != null) {
                    System.out.print(node.data + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                    nodesInNextLevel += 2;
                }
                if(nodesInCurrentLevel == 0) {
                    nodesInCurrentLevel = nodesInNextLevel;
                    nodesInNextLevel = 0;
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = {25, 15, 10, 20, 35, 30, 27, 40};
        int[] in =  {10, 15, 20, 25, 27, 30, 35, 40};
        constructTree(in, pre);
    }
}
