package c02_Linked_List.LinkedList;

/**
 * Created by sharath on 8/4/14.
 */
public class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
    }

    public void display() {
        Node n = this;
        while (n != null) {
            System.out.print("[" + n.data + "] ");
            n = n.next;
        }
        System.out.println();
    }
}
