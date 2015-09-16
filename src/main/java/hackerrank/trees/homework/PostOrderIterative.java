package hackerrank.trees.homework;

import java.util.Stack;

/**
 * Created by sharath on 9/8/15.
 */
public class PostOrderIterative {

    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void postOrderIterative(Node root) {
        Stack<Node> buffer = new Stack<>();
        Node curr = null;
        Node prev = null;
        buffer.push(root);
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
                System.out.print(curr.data + " ");
                buffer.pop();
            }
            prev = curr;
        }
    }

    public static void main(String[] args) {
        System.out.println("Iterative post order traversal");
        postOrderIterative(createBST());
        System.out.println("\nRecursive post order traversal for verification");
        postOrder(createBST());
    }

    public static void postOrder(Node root) {
        if(root.left != null)
            postOrder(root.left);
        if(root.right != null)
            postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static Node createBST() {
        Node root = new Node(25);
        Node l1 = new Node(15);
        Node r1 = new Node(35);
        Node l1l = new Node(10);
        Node l1r = new Node(20);
        Node r1l = new Node(30);
        Node r1r = new Node(40);
        root.left = l1;
        root.right = r1;
        l1.left = l1l;
        l1.right =l1r;
        r1.left = r1l;
        r1.right = r1r;

        return root;
    }

}
