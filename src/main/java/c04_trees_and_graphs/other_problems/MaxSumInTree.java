package c04_trees_and_graphs.other_problems;

/**
 * Created by sharath on 8/13/14.
 *
 * Problem description
 *
 * Find the path that gives the maximum sum using one number from each level.
 * Each element of the path should be adjacent to the previous one.
 *
 * 1-                4
 * 2-            2       -1
 * 3-        3       7       9
 * 4-    20      0       3       99
 */
public class MaxSumInTree {

//    class tNode {
//        public int data;
//        public boolean visited;
//        public int sum;
//        public tNode left;
//        public tNode right;
//    }
//    public int[] findPath(tNode n) {
//        int[] path = new int[4];
//        Queue<tNode> q = new LinkedList<>();
//        n.sum = n.data;
//        q.add(n);
//        tNode node;
//        while(!q.isEmpty()) {
//            node = q.remove();
//            if(node.left != null) {
//                q.add(node.left);
//                node.left.sum = node.left.data + node.sum;
//            } else if(node.right != null) {
//                q.add(node.right);
//                node.right.sum = node.right.data + node.sum;
//            }
//            node.sum = Math.max(node.left.sum, node.right.sum);
//        }
//    }
}
