package hackerrank.graphs_and_other_ds.cci.Q4_06_Successor;

import hackerrank.graphs_and_other_ds.cci.BSTNode;

/**
 * pseudo code:
 *
 * Node inorderSuccessor(Node n) {
 *     if( n has a right subtree) {
 *         return leftmost child of right subtree
 *     } else {
 *         while(n is the right child of n's parent) {
 *             n = n.parent;
 *         }
 *         return n.parent;
 *     }
 * }
 *
 * TODO : fix the main() method in the program as well as Node class
 * // compiles but doesn't run as BSTNode can't be cast to Node.
 *
 * Created by sharath on 5/30/16.
 */
class Node extends BSTNode {
    public Node parent;
    public Node(int data, Node p) {
        super(data);
        this.parent = p;
    }
}
public class InorderSuccessor {
    public static Node inorderSuccessor(Node n) {
        if(n == null)
            return null;
        if(n.right != null) {
            return leftMostChild((Node)n.right);
        } else {
            Node par = n.parent;
            while(par != null && par.left != n) {
                n = par;
                par = par.parent;
            }
            return par;
        }
    }

    private static Node leftMostChild(Node n) {
        if(n == null)
            return null;
        while(n.left != null) {
            n = (Node)n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node root = (Node)Node.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            Node node = (Node)root.find(array[i]);
            Node next = inorderSuccessor(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }
}
