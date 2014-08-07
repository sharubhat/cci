package c02_Linked_List.LinkedList;

/**
 * Created by sharath on 8/4/14.
 */
public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int[] input) {
        this();
        for (int i = input.length - 1; i >= 0; i--) {
            this.insert(input[i]);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void insertAtEnd(int data) {
        Node curr = head;
        while(curr != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);
    }

    public void display() {
        Node n = head;
        while (n != null) {
            System.out.print("[" + n.data + "] ");
            n = n.next;
        }
        System.out.println();
    }

}
