package hackerrank.trees.basics;

/**
 * If the node has left sub tree, then the maximum element in that left subtree will be inorder predecessor.
 * If node does not have left sub tree, then node where we took that last right turn is our desired node.
 *
 * Created by sharath on 9/16/15.
 */
public class InOrderPredecessor {
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

    public static Node inorderPredecessor(Node root, int k) {
        Node successor = null;
        if(root != null) {
            Node curr = root;
            while(curr.data != k) {
                if(curr.data < k) {
                    successor = curr;
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            if(curr != null && curr.left != null) {
                successor = findMax(curr.left);
            }
        }
        return successor;
    }

    private static Node findMax(Node root) {
        if(root != null) {
            while(root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = createBST();

        System.out.println("inorderPredecessor of 10 is " + inorderPredecessor(root, 10));
        System.out.println("inorderPredecessor of 15 is " + inorderPredecessor(root, 15));
        System.out.println("inorderPredecessor of 20 is " + inorderPredecessor(root, 20));
        System.out.println("inorderPredecessor of 25 is " + inorderPredecessor(root, 25));
        System.out.println("inorderPredecessor of 30 is " + inorderPredecessor(root, 30));
        System.out.println("inorderPredecessor of 35 is " + inorderPredecessor(root, 35));
        System.out.println("inorderPredecessor of 40 is " + inorderPredecessor(root, 40));
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
