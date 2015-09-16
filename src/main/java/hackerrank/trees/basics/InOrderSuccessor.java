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
        if(root != null) {
            Node curr = root;
            while(curr.data != k) {
                if(curr.data > k) {
                    successor = curr;
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if(curr != null && curr.right != null) {
                successor = findMin(curr.right);
            }
        }
        return successor;
    }

    private static Node findMin(Node root) {
        if(root != null) {
            while(root.left != null) {
                root = root.left;
            }
        }
        return root;
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
