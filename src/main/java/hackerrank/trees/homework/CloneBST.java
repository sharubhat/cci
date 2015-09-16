package hackerrank.trees.homework;

/**
 * Created by sharath on 9/14/15.
 */
public class CloneBST {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node clone(Node root, Node newRoot) {
        if(root != null) {
            newRoot = new Node(root.data);
            newRoot.left = clone(root.left, newRoot.left);
            newRoot.right = clone(root.right, newRoot.right);
            return newRoot;
        }
        return null;
    }

    private static Node createBST() {
        Node root = new Node(25);
        Node l1 = new Node(15);
        Node r1 = new Node(35);
        Node l1l2 = new Node(10);
        Node l1r2 = new Node(20);
        Node r1l2 = new Node(30);
        Node r1r2 = new Node(40);
        Node r1r2l = new Node(37);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;
        r1r2.left = r1r2l;

        return root;
    }

    public static void inOrderRec(Node root) {
        if(root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Node cloned = clone(createBST(), null);
        inOrderRec(cloned);
    }
}
