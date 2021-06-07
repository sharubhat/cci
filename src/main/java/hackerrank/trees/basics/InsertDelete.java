package hackerrank.trees.basics;

import java.util.Stack;

public class InsertDelete {
    public static void main(String[] args) {
        Node root2 = createBST2();
        inorder(root2);
        insert(root2, 12);
        inorder(root2);
        delete(root2, 5);
        inorder(root2);
        insert(root2, 12);
        inorder(root2);
    }

    private static void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root + " ");
            root = root.right;
        }
        System.out.println();
    }

    private static void insert(Node root, int i) {
        if (root.data < i) {
            if (root.right == null) {
                root.right = new Node(i);
            } else {
                insert(root.right, i);
            }
        } else if (root.data > i) {
            if (root.left == null) {
                root.left = new Node(i);
            } else {
                insert(root.left, i);
            }
        }
    }

    public static void delete(Node root, int key) {
        Node curr = root;
        Node parent = root;
        boolean isLeftChild = false;

        // get to the node with key
        while(curr.data != key) {
            parent = curr;
            if(key < curr.data) {
                isLeftChild = true;
                curr = curr.left;
            } else {
                isLeftChild = false;
                curr = curr.right;
            }
            if(curr == null) {
                throw new RuntimeException("Key not found");
            }
        }

        // case 1: Node to be deleted has no children
        // lets go ahead and delete it for good
        if(curr.left == null && curr.right == null) {
            if(isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        } else if(curr.left == null) {    // case 2: Node to be deleted has one child
            if(isLeftChild) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        } else if(curr.right == null) {
            if(isLeftChild) {
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        } else { // case 3: Node to be deleted has two children, replace the node with in order successor
            Node successor = inorderSuccessor(curr, curr.data); // get successor of node to delete (current)
            if(isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = curr.left; // connect successor to current node's left child
        }
    }

    public static Node inorderSuccessor(Node root, int key) {
        Node successor = null;
        while(root != null) {
            if (root.data > key) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
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
        Node l1l2r3r4 = new Node(9);
        Node l1l2r3r4l5 = new Node(8);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1l2.left = l1l2l3;
        l1l2.right = l1l2r3;
        l1l2r3.right = l1l2r3r4;
        l1l2r3r4.left = l1l2r3r4l5;
        r1.left = r1l1;
        r1.right = r1r2;

        return root;
    }
}
