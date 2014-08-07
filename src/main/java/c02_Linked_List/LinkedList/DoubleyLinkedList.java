package c02_Linked_List.LinkedList;

/**
 * Created by sharath on 8/6/14.
 *
 * Doubly Linked Lists.
 * In your most comfortable programming language,
 * implement a doubly linked list.
 * What is the time complexity of inserting
 * To the head of the list? // O(1) given there is a reference to head, else O(n)
 * To the tail of the list? // O(1) given there is a reference to tail, else O(n)
 * To somewhere in the middle of the list? // O(n)
 * Removing from the head? // O(1) given there is a reference to head, else O(n)
 * Removing from the tail? // O(1) given there is a reference to tail, else O(n)
 * Removing from the middle? // O(n)
 */
public class DoubleyLinkedList {
    private int count;
    public DNode head;
    public DNode tail;

    public DoubleyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }
    
    public void add(int value) {
        addFirst(value);
    }

    public DNode remove(){
        return removeFirst();
    }

    public void addFirst(int value) {
        DNode curr = new DNode(value);
        if(head == null) {
            head = curr;
            tail = curr;
        }
        else {
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
        count++;
    }

    public DNode removeFirst() {
        if(!isEmpty())
            throw new IndexOutOfBoundsException("Empty list");
        DNode curr = head;
        head = head.next;
        if(head != null)
            head.prev = null;
        else
            tail = null;
        curr.next = null;
        count--;
        return curr;
    }

    public void addLast(int value) {
        DNode curr = new DNode(value);
        if(tail == null) {
            head = curr;
            tail = curr;
        }
        else {
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }
        count++;
    }

    public DNode removeLast(){
        if(!isEmpty())
            throw new IndexOutOfBoundsException("Empty List");
        DNode curr = tail;
        tail = tail.prev;
        if(tail != null)
            tail.next = null;
        else
            head = null;
        curr.prev = null;
        count--;
        return curr;
    }

    public void display() {
        DNode curr =  head;
        while(curr != null) {
            System.out.print("[" + curr.data + "] ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void displayReverse(){
        DNode curr = tail;
        while(curr != null) {
            System.out.print("[" + curr.data + "] ");
            curr = curr.prev;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoubleyLinkedList dl1 = new DoubleyLinkedList();
        dl1.addFirst(9);
        dl1.addFirst(8);
        dl1.addFirst(7);
        dl1.addFirst(6);
        dl1.addFirst(5);
        dl1.addFirst(4);
        dl1.addFirst(3);
        dl1.addFirst(2);
        dl1.addFirst(1);

        dl1.display();
        dl1.displayReverse();

        while(!dl1.isEmpty()) {
            dl1.removeFirst();

            System.out.println();
            dl1.display();
            dl1.displayReverse();
        }

        DoubleyLinkedList dl = new DoubleyLinkedList();
        dl.addLast(9);
        dl.addLast(8);
        dl.addLast(7);
        dl.addLast(6);
        dl.addLast(5);
        dl.addLast(4);
        dl.addLast(3);
        dl.addLast(2);
        dl.addLast(1);

        dl.display();
        dl.displayReverse();

        while(!dl.isEmpty()) {
            dl.removeLast();

            System.out.println();
            dl.display();
            dl.displayReverse();
        }
    }
}
