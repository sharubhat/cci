package hackerrank.graphs_and_other_ds.cci.Q4_03_List_of_Depths;

import hackerrank.graphs_and_other_ds.cci.BSTNode;

import java.util.*;

/**
 * Created by sharath on 5/30/16.
 */
public class DepthsBFS {
    public static List<List<BSTNode>> createLevelLinkedList(BSTNode root) {
        List<List<BSTNode>> result = new ArrayList<>();
        // visit the root
        List<BSTNode> current = new LinkedList<>();
        if(root != null)
            current.add(root);
        while(current.size() > 0) {
            List<BSTNode> parents = current;
            result.add(parents);
            current = new LinkedList<>();
            for(BSTNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    public static void printResult(List<List<BSTNode>> result){
        int depth = 0;
        for(List<BSTNode> entry : result) {
            Iterator<BSTNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + (i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BSTNode root = createTreeFromArray(nodes_flattened);
        List<List<BSTNode>> list = createLevelLinkedList(root);
        printResult(list);
    }

    /* Creates tree by mapping the array left to right, top to bottom. */
    public static BSTNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            BSTNode root = new BSTNode(array[0]);
            Queue<BSTNode> queue = new LinkedList<>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                BSTNode r = queue.element();
                if (r.left == null) {
                    r.left = new BSTNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new BSTNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length) {
                    done = true;
                }
            }
            return root;
        } else {
            return null;
        }
    }
}
