package hackerrank.trees.basics;

/**
 * Find in-order successor in a binary search tree.
 *
 * Candidates for inorder successor of a node are as follows:
 * Minimum node or the left most child in the right sub tree of that node.
 * The node where last left turn was taken to reach the given node.
 *
 * Time complexity : O(logN) (Complexity is height of the tree, so it can be as worst as O(N))
 *
 * Created by sharath on 9/15/15.
 */
public class InOrderSuccessor {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }

    public static Node inorderSuccessor(Node root, int k) {
        Node successor = null;
        while(root != null) {
            if (root.data > k) {
                successor = root;
                root = root.left;
            } else if (root.data <= k) {
                root = root.right;
            }
        }
        return successor;
    }

    public static Node successorRec(Node root, int k) {
        if (root != null) {
            if (root.data > k) {
                Node successor = successorRec(root.left, k);
                return successor == null ? root : successor;
            } else {
                return successorRec(root.right, k);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = createBST();

        System.out.println("inorderSuccessor of 10 is " + inorderSuccessor(root, 10));
        System.out.println("inorderSuccessor of 15 is " + inorderSuccessor(root, 15));
        System.out.println("inorderSuccessor of 20 is " + inorderSuccessor(root, 20));
        System.out.println("inorderSuccessor of 25 is " + inorderSuccessor(root, 25));
        System.out.println("inorderSuccessor of 30 is " + inorderSuccessor(root, 30));
        System.out.println("inorderSuccessor of 35 is " + inorderSuccessor(root, 35));
        System.out.println("inorderSuccessor of 40 is " + inorderSuccessor(root, 40));

        Node root2 = createBST2();
        System.out.println("inorderSuccessor of 8 is " + inorderSuccessor(root2, 8));
        System.out.println("inorderSuccessor of 15 is " + inorderSuccessor(root2, 15));
        root2 = createBST2();
        System.out.println("inorderSuccessor of 8 is " + successorRec(root2, 8));
        System.out.println("inorderSuccessor of 15 is " + successorRec(root2, 15));
    }

    private static Node createBST2() {
        Node root = new Node(15);
        Node l1 = new Node(10);
        Node r1 = new Node(20);
        Node l1l2 = new Node(5);
        Node r1l1 = new Node(17);
        Node r1r2 = new Node(25);
        Node l1l2l3 = new Node(1);
        Node l1l2r3 = new Node(7);
        Node l1l2r3r4 = new Node(8);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1l2.left = l1l2l3;
        l1l2.right = l1l2r3;
        l1l2r3.right = l1l2r3r4;
        r1.left = r1l1;
        r1.right = r1r2;

        return root;
    }

    private static Node createBST() {
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
        l1.right =l1r2;
        r1.left = r1l2;
        r1.right = r1r2;

        return root;
    }
}
