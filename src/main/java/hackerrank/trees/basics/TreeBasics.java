package hackerrank.trees.basics;

/**
 * Created by sharath on 9/15/15.
 */
public class TreeBasics {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        int leftHeight = (root.left == null)? 0 : height(root.left);
        int rightHeight = (root.right == null)? 0 : height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int numberOfNodes(Node root) {
        return 1 + ((root.left == null)? 0 : numberOfNodes(root.left))
                + ((root.right == null)? 0 : numberOfNodes(root.right));
    }

    // *************** weight balance ***************

    // A binary tree is weight balanced if for each node it holds that the number of inner nodes in the left subtree
    // and the number of inner nodes in the right subtree differ by at most 1.
    public static boolean isWeightBalanced(Node root) {
        return getWeightBalance(root) != -1;
    }

    private static int getWeightBalance(Node root) {
        if(root == null)
            return 0;
        int leftWeightBalance = getWeightBalance(root.left);
        int rightWeightBalance = getWeightBalance(root.right);

        if(leftWeightBalance == -1 ||
                rightWeightBalance == -1 ||
                Math.abs((leftWeightBalance - rightWeightBalance)) > 1)
            return -1;
        return Math.max(leftWeightBalance, rightWeightBalance) + 1;
    }

    // *************** weight balance end ***************

    // *************** height balance ***************

    // A binary tree is height balanced if for any two leaves the difference of the depth is at most 1.
    public static boolean isHeightBalanced(Node root) {
        return (maxLeafHeight(root) - minLeafHeight(root) <= 1);
    }

    public static int maxLeafHeight(Node root) {
        return root == null ? 0 : Math.max(maxLeafHeight(root.left), maxLeafHeight(root.right)) + 1;
    }

    public static int minLeafHeight(Node root) {
        return root == null ? 0 : Math.min(minLeafHeight(root.left), minLeafHeight(root.right)) + 1;
    }

    // *************** height balance end ***************

    public static void print(Node n) {
        System.out.print(n.data + " ");
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
