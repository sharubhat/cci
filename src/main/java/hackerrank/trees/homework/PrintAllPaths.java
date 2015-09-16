package hackerrank.trees.homework;

import java.util.ArrayList;

/**
 * Print all paths in a binary tree.
 *      1
 *   2     3
 * 4   5  6  7
 *
 * Output:
 * 1 2 4
 * 1 2 5
 * 1 3 6
 * 1 3 7
 *
 * Created by sharath on 9/14/15.
 */
public class PrintAllPaths {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        printAllPaths(createBT());
    }

    private static Node createBT() {
        Node root = new Node(1);
        Node l1 = new Node(2);
        Node r1 = new Node(3);
        Node l1l2 = new Node(4);
        Node l1r2 = new Node(5);
        Node r1l2 = new Node(6);
        Node r1r2 = new Node(7);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;

        return root;
    }

    public static void printAllPaths(Node root) {
        printAllPathsHelper(root, new ArrayList<Integer>());
    }

    // It's important to remember that we need list for each path
    private static void printAllPathsHelper(Node root, ArrayList<Integer> paths) {
        if(root != null) {
            paths.add(root.data);
            if(root.left == null && root.right == null)
                print(paths);
            printAllPathsHelper(root.left, new ArrayList<>(paths));
            printAllPathsHelper(root.right, new ArrayList<>(paths));
        }
    }

    private static void print(ArrayList<Integer> paths) {
        for(int node : paths) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
