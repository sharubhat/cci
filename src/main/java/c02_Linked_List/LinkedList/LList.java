package c02_Linked_List.LinkedList;

/**
 * Created by sharath on 7/22/15.
 */
public class LList {
    static class Node {
        int data;
        Node next;

        Node(int i) {
            this.data = i;
        }
   }

    Node head;

    void add(Node n) {
        n.next = this.head;
        this.head = n;
    }

    void append(LList list) {
        Node curr = this.head;
        while(curr != null) {
            curr = curr.next;
        }
        curr.next = list.head;
    }

    void prepend(LList lList) {
        Node curr = lList.head;
        while(curr != null) {
            curr = curr.next;
        }
        curr.next = this.head;
        this.head = lList.head;
    }

    public void reverse() {
        Node prev = null;
        while(this.head != null) {
            Node tmp = this.head;
            this.head = this.head.next;
            tmp.next = prev;
            prev = tmp;
        }
        this.head = prev;
    }

    public void revRec() {
        this.head = revRecHelper(this.head, new LList());
    }

    private Node revRecHelper(Node head, LList acc) {
        if(head == null)
            return acc.head;
        else {
            Node tmp = head;
            head = head.next;
            acc.add(tmp);
            return revRecHelper(head, acc);
        }
    }

    public String toString() {
        Node curr = this.head;
        StringBuilder sb = new StringBuilder();
        while(curr != null) {
            sb.append("[ " + curr.data + " ] ");
            curr = curr.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LList list = new LList();
        list.add(new Node(4));
        list.add(new Node(3));
        list.add(new Node(2));
        list.add(new Node(1));
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        list.revRec();
        System.out.println(list);
    }
}
