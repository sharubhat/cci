package hackerrank.trees.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Merge two BSTs in O(m+n). The merged tree should contain all elements of both trees and also be balanced BST.
 * Finally print tree level by level.
 * 
 * Created by sharath on 9/13/15.
 */
public class MergeTrees {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node n1 = createBST1();
        Node n2 = createBST2();
        Node mergedBST = mergeTwoBSTs(n1, n2);
        printLevelOrder(mergedBST);
    }

    private static Node createBST1() {
        Node root = new Node(25);
        Node l1 = new Node(15);
        Node r1 = new Node(35);
        Node l1l2 = new Node(10);
        Node l1r2 = new Node(20);
        Node r1l2 = new Node(30);
        Node r1r2 = new Node(40);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;

        return root;
    }

    private static Node createBST2() {
        Node root = new Node(27);
        Node l1 = new Node(17);
        Node r1 = new Node(37);
        Node l1l2 = new Node(13);
        Node l1r2 = new Node(23);
        Node r1l2 = new Node(33);
        Node r1r2 = new Node(43);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;

        return root;
    }

    public static Node mergeTwoBSTs(Node n1, Node n2) {
        ArrayList<Integer> list1 = flatten(n1, new ArrayList<>());
        ArrayList<Integer> list2 = flatten(n2, new ArrayList<>());
        ArrayList<Integer> sortedAndMerged = mergeSortedLists(list1, list2);
        return createBSTFromList(sortedAndMerged);
    }

    private static ArrayList<Integer> flatten(Node n, ArrayList<Integer> list) {
        if (n.left != null)
            flatten(n.left, list);
        list.add(n.data);
        if (n.right != null)
            flatten(n.right, list);
        return list;
    }

    public static ArrayList<Integer> mergeSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> sortedList = new ArrayList<>(list1.size() + list2.size());
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                sortedList.add(list1.get(index1++));
            } else {
                sortedList.add(list2.get(index2++));
            }
        }

        while (index1 < list1.size()) {
            sortedList.add(list1.get(index1++));
        }

        while (index2 < list2.size()) {
            sortedList.add(list2.get(index2++));
        }
        return sortedList;
    }

    private static Node createBSTFromList(ArrayList<Integer> sortedAndMerged) {
        return createMinBST(sortedAndMerged, 0, sortedAndMerged.size() - 1);
    }

    private static Node createMinBST(ArrayList<Integer> array, int start, int end) {
        if (end < start)
            return null;
        int mid = start + (end - start) / 2;
        Node node = new Node(array.get(mid));
        node.left = createMinBST(array, start, mid - 1);
        node.right = createMinBST(array, mid + 1, end);
        return node;
    }

    public static void printLevelOrder(Node root) {
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
}
