package hackerrank.trees.others;

/**
 * Created by sharath on 11/12/15.
 */
public class MirrorABinaryTree {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void mirror(Node root){
        print(root);
        Node x = mirrorTree(root);
        System.out.print("\n Mirror Image ");
        print(x);
    }
    public Node mirrorTree(Node root){
        if(root!=null){

            mirrorTree(root.left);
            mirrorTree(root.right);
            Node t = root.left;
            root.left = root.right;
            root.right = t;

        }
        return root;
    }
    public void print(Node root){
        if(root!=null){
            print(root.left);
            System.out.print(" " + root.data);
            print(root.right);
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        MirrorABinaryTree i  = new MirrorABinaryTree();
        i.mirror(root);
    }
}
