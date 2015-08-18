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
        for (int i = input.length - 1; i >= 0; i--) {
            this.insert(input[i]);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int data) {
        insert(new Node(data));
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

    public Node remove() {
        if(isEmpty()) {
            return head;
        }
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        return tmp;
    }

    public Node removeAtEnd() {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            Node tmp = head;
            head = null;
            return tmp;
        }

        Node prev = null;
        Node curr = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }

    public void reverse() {
        Node prev = null;
        while(head != null) {
            Node tmp = head;
            head = head.next;
            tmp.next = prev;
            prev = tmp;
        }
        head = prev;
    }

    public void revRec() {
        this.head = revRecHelper(this.head, new LinkedList());
    }

    // tal recursive.
    private Node revRecHelper(Node head, LinkedList acc) {
        if(head == null)
            return acc.head;
        else {
            Node tmp = head;
            head = head.next;
            acc.insert(tmp);
            return revRecHelper(head, acc);
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

        list.remove().display();
        list.display();
        list.removeAtEnd().display();
        list.display();
        //list.reverseRec().display();
    }

}
