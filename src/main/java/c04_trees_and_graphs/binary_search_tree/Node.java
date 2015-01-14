package c04_trees_and_graphs.binary_search_tree;

/**
 * Created by sharath on 8/10/14.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *       Class diagram
 *
 *       Node
 *       ________________________________________
 *       +data                          :int
 *       +left                          :Node
 *       +right                         :Node
 *       +parent                        :Node
 *       ________________________________________
 *       +Node(int)
 *       +insertInOrder(int)            :void
 *       +isBST()                       :boolean
 *       +height()                      :int
 *       +numberOfNodes()               :int
 *       +find(int)                     :Node
 *       +min()                         :Node
 *       +max()                         :Node
 *       +createMinBST(int([]))         :Node
 *       -createMinBST(int([]),int,int) :Node
 *       +printNode()                   :void
 *       +inOrderTraverse()             :void
 *       +inOrderIterative()            :void
 *       +preOrderTraverse()            :void
 *       +preOderIterative()            :void
 *       +postOrderTraversal()          :void
 *       +postOrderIterative()          :void
 *       +convertToArray()              :int([])
 *       -convertToArray(int([]))       :void
 *       +convertToArrayBFS()           :int([])
 *       +treeSuccessor()               :Node
 *       -treeSuccessor(Node)       :Node
 *       +deleteNode(int)               :void
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int d) {
        this.data = d;
    }

    public void insertInOrder(int d) {
        if(d < data) {
            if(left == null) {
                left = new Node(d);
                left.parent = this;
            }
            else
                left.insertInOrder(d);
        } else {
            if(right == null) {
                right = new Node(d);
                right.parent = this;
            }
            else
                right.insertInOrder(d);
        }
    }

    public boolean isBST() {
        if(left != null)
            if(left.data > data || !left.isBST())
                return false;
        if(right != null)
            if(right.data < data || !right.isBST())
                return false;
        return true;
    }

    public int height() {
        int leftHeight = (left == null)? 0 : left.height();
        int rightHeight = (right == null)? 0 : right.height();
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int numberOfNodes() {
        return 1 + ((left == null)? 0 : left.numberOfNodes())
                + ((right == null)? 0 : right.numberOfNodes());
    }

    public Node find(int d) {
        if(d == data)
            return this;
        else if(d < data)
            return (left == null)? null : left.find(d);
        else if(d > data)
            return (right == null)? null : right.find(d);
        return null;
    }

    public Node min() {
        if(left == null)
            return this;
        else
            return left.min();
    }

    public Node max() {
        if(right == null)
            return this;
        else
            return right.max();
    }

    public static Node createMinBST(int[] array) {
        return createMinBST(array, 0, array.length - 1);
    }

    private static Node createMinBST(int[] array, int start, int end) {
        if(end < start)
            return null;
        int mid = start + (end - start)/2;
        Node node = new Node(array[mid]);
        node.left = createMinBST(array, start, mid - 1);
        node.right = createMinBST(array, mid + 1, end);
        return node;
    }

    public void printNode() {
        System.out.print("[" + data + "]");
    }

    public void inOrderTraverse() {
        if(left != null)
            left.inOrderTraverse();
        printNode();
        if(right != null)
            right.inOrderTraverse();
    }

    public void inOrderIterative() {
        Stack<Node> buffer = new Stack<>();
        Node current = this;
        /* stop when both buffer is empty and
           current is null, i.e. you have traversed all nodes
         */
        while(!(buffer.isEmpty() && current == null)) {
            if(current != null) {
                buffer.push(current);
                current = current.left;
            } else {
                current = buffer.pop();
                current.printNode();
                current = current.right;
            }
        }
    }

    public void preOrderTraverse() {
        printNode();
        if(left != null)
            left.preOrderTraverse();
        if(right != null)
            right.preOrderTraverse();
    }

    public void preOderIterative() {
        Stack<Node> buffer = new Stack<>();
        Node current = this;
        while(!(buffer.isEmpty() || current == null)) {
            if(current != null) {
                printNode();
                if(current.right != null)
                    buffer.push(current.right);
                current = current.left;
            } else {
                current = buffer.pop();
            }
        }
    }

    public void postOrderTraversal() {
        if(left != null)
            left.postOrderTraversal();
        if(right != null)
            right.postOrderTraversal();
        printNode();
    }

    public void postOrderIterative() {
        Stack<Node> buffer = new Stack<>();
        Node curr = null;
        Node prev = null;
        buffer.push(this);
        while(!buffer.isEmpty()) {
            curr = buffer.peek();
            if(prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null)
                    buffer.push(curr.left);
                else if(curr.right != null)
                    buffer.push(curr.right);
            } else if(curr.left == prev) {
                if(curr.right != null)
                    buffer.push(curr.right);
            } else {
                printNode();
                buffer.pop();
            }
            prev = curr;
        }
    }

    public int[] convertToArray() {
        int[] output = new int[numberOfNodes()];
        convertToArray(this, output, 0);
        return output;
    }

    private int convertToArray(Node n, int[] output, int index) {
        if(n.left != null)
            index = convertToArray(n.left, output, index);
        if(n.right != null)
            index = convertToArray(n.right, output, index);
        output[index] = n.data;
        return index++;
    }

    public int[] convertToArrayBFS() {
        Queue<Node> q = new LinkedList<>();
        int index = 0;
        Node node;
        int[] output = new int[numberOfNodes()];
        q.add(this);
        while(!q.isEmpty()) {
            node = q.remove();
            output[index++] = node.data;
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return output;
    }

    // successor of a node x is the node with the smallest key greater than x:key
    public Node treeSuccessor() {
        return treeSuccessor(this);
    }
    public Node treeSuccessor(Node x) {
        if(x.right != null)
            return x.right.min();
        Node p = x.parent;
        while(p != null && x == p.right) {
            x = p;
            p = p.parent;
        }
        return p;
    }
}
