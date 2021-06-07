package hackerrank.trees.basics;

public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}