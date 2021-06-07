package hackerrank.trees.basics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Brushing up on basics. This class will show ways of traversing a binary tree both recursively and iteratively.
 *
 * Simple technique to remember the traversals.
 * You always visit the root. So in pre - visit root first; in - visit root in between; post - visit root at the end.
 *
 *
 * Pre-order : visit root, traverse left then right (Visit the root first and then the children.).
 * Uses of Pre-order
 * Pre-order traversal is used to create a copy of the tree.
 * Pre-order traversal is also used to get prefix expression on of an expression tree.
 * Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
 *
 *
 * In-order : traverse left, visit root, traverse right
 * Uses of Inorder
 * In case of binary search trees (BST), In-order traversal gives nodes in ascending order.
 *
 *
 * Post-order : traverse left then right and visit root (Visit the children first and then the parent.).
 * Uses of Post-order:
 * Post-order traversal is used to delete the tree. Please see the solution for deletion of tree for details.
 * Post-order traversal is also useful to get the postfix expression of an expression tree.
 * Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.
 *
 * Created by sharath on 9/9/15.
 */
public class Traversals {
    public static void print(Node n) {
        System.out.print(n.data + " ");
    }

    // recursive pre-order
    public static void preOrderRec(Node root) {
        if(root != null) {
            print(root);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // iterative pre-order
    public static void preOrder(Node root) {
        if(root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if(root == null)
                    root = stack.pop();
                else {
                    print(root);
                    stack.push(root.right);
                    root = root.left;
                }
            }
        }
    }

    // recursive in-order
    public static void inOrderRec(Node root) {
        if(root != null) {
            inOrderRec(root.left);
            print(root);
            inOrderRec(root.right);
        }
    }

    // iterative in-order
    public static void inOrder(Node root) {
        if(root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if(root == null) {
                    root = stack.pop();
                    print(root);
                    root = root.right;
                } else {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
    }

    // recursive post-order
    public static void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            print(root);
        }
    }

    // iterative post-order
    public static void postOrder(Node root) {
        if(root != null) {
            Stack<Node> stack = new Stack<>();
            do {
                // first push right, then push root, then traverse left subtree until all nodes are exhausted.
                while (root != null) {
                    stack.push(root.right);
                    stack.push(root);
                    root = root.left;
                }
                // pop when there is no node left
                root = stack.pop();
                // if there is a right child and it's same as the one on top of stack, then take that right child out,
                // put back the root on stack, go down the right subtree.
                if(root != null) {
                    if (root.right != null && !stack.isEmpty() && root.right.equals(stack.peek())) {
                        Node rightChild = stack.pop();
                        stack.push(root);
                        root = rightChild;
                    } else {
                        print(root);
                        root = null;
                    }
                }
            } while (!stack.isEmpty());
        }
    }

    public static void levelOrder(Node root) {
        if(root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int nodesInCurrentLevel = 1;
            int nodesInNextLevel = 0;
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                nodesInCurrentLevel--;
                if(node != null) {
                    print(node);
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

    public static void main(String[] args) {
        //******************** empty tree

        System.out.println("Iterative preorder traversal");
        preOrder(null);
        System.out.println("\nRecursive preorder traversal");
        preOrderRec(null);

        System.out.println("\n\nIterative inorder traversal");
        inOrder(null);
        System.out.println("\nRecursive inorder traversal");
        inOrderRec(null);

        System.out.println("\n\nIterative post order traversal");
        postOrder(null);
        System.out.println("\nRecursive post order traversal");
        postOrderRec(null);

        System.out.println("\n\nLevel order traversal");
        levelOrder(null);

        //******************** one extra node on left

        System.out.println("Iterative preorder traversal");
        preOrder(createBST());
        System.out.println("\nRecursive preorder traversal");
        preOrderRec(createBST());

        System.out.println("\n\nIterative inorder traversal");
        inOrder(createBST());
        System.out.println("\nRecursive inorder traversal");
        inOrderRec(createBST());

        System.out.println("\n\nIterative post order traversal");
        postOrder(createBST());
        System.out.println("\nRecursive post order traversal");
        postOrderRec(createBST());

        System.out.println("\n\nLevel order traversal");
        levelOrder(createBST());


        //******************** one extra node on right

        System.out.println("Iterative preorder traversal");
        preOrder(createBST2());
        System.out.println("\nRecursive preorder traversal");
        preOrderRec(createBST2());

        System.out.println("\n\nIterative inorder traversal");
        inOrder(createBST2());
        System.out.println("\nRecursive inorder traversal");
        inOrderRec(createBST2());

        System.out.println("\n\nIterative post order traversal");
        postOrder(createBST2());
        System.out.println("\nRecursive post order traversal");
        postOrderRec(createBST2());

        System.out.println("\n\nLevel order traversal");
        levelOrder(createBST2());
    }



    private static Node createBST() {
        Node root = new Node(25);
        Node l1 = new Node(15);
        Node r1 = new Node(35);
        Node l1l2 = new Node(10);
        Node l1r2 = new Node(20);
        Node r1l2 = new Node(30);
        Node r1r2 = new Node(40);
        Node r1l2l3 = new Node(27);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right =l1r2;
        r1.left = r1l2;
        r1.right = r1r2;
        r1l2.left = r1l2l3;

        return root;
    }

    private static Node createBST2() {
        Node root = new Node(25);
        Node l1 = new Node(15);
        Node r1 = new Node(35);
        Node l1l2 = new Node(10);
        Node l1r2 = new Node(20);
        Node r1l2 = new Node(30);
        Node r1r2 = new Node(40);
        Node r1l2r3 = new Node(32);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right =l1r2;
        r1.left = r1l2;
        r1.right = r1r2;
        r1l2.right = r1l2r3;

        return root;
    }

}
