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

    public void insert(Node n) {
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

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node tmp = null;
        while(curr != null) {
            tmp = curr;
            curr = curr.next;
            tmp.next = prev;
            prev = tmp;
        }
        head = prev;
    }

    public LinkedList reverseRec() {
        return reverseRecurse(head, new LinkedList());
    }

    // tail recursive
    private LinkedList reverseRecurse(Node curr, LinkedList acc) {
        if(curr == null) {
            return acc;
        }
        else {
            Node tmp = curr;
            curr = curr.next;
            acc.insert(tmp);
            return reverseRecurse(curr, acc);
        }
    }

    public void display() {
        Node n = head;
        while (n != null) {
            System.out.print("[" + n.data + "] ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4});
        list.reverse();
        list.display();

        list.reverseRec().display();
    }

}
