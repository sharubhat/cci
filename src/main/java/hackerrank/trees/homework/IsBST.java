package hackerrank.trees.homework;

/**
 * Check if given tree is BST
 *
 * Created by sharath on 9/8/15.
 */
public class IsBST {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean checkBST(Node root) {
        if(root ==  null)
            return true;
        boolean leftBST = root.left != null ? (root.data > root.left.data && checkBST(root.left)) : true;
        boolean rightBST = root.right != null ? (root.data < root.right.data && checkBST(root.right)) : true;
        return leftBST && rightBST;
    }

    public static void main(String[] args) {
        Node testTree = createBST();
        System.out.println(checkBST(testTree));
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
