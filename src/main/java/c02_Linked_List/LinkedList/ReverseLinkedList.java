package c02_Linked_List.LinkedList;

/**
 * Created by sharath on 8/5/15.
 */
public class ReverseLinkedList {
    static class LListNode {
        public int data;
        public LListNode next;

        public LListNode(int data) {
            this.data = data;
        }

        public void print() {
            LListNode start = this;
            while(start != null) {
                System.out.print(" [" + start.data + "] ");
                start = start.next;
            }
            System.out.println();
        }
    }

    public static LListNode reverse(LListNode first) {
        // reverse of null (the empty list) is null.
        if(first == null)
            return null;
        // reverse of a one element list is the element itself
        if(first.next == null)
            return first;
        // reverse of an n element list is the reverse of the second element on followed by the first element.
        LListNode second = first.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        first.next = null;

        LListNode reverse = reverse(second);

        // This is tricky. We need to connect first to end of the reverse list.
        // Either you could traverse every time to end of reverse, or
        // make use of the fact that second element is going to be at the end of reversed list starting at second.
        second.next = first;

        return reverse;
    }

    public static void main(String[] args) {
        LListNode n1 = new LListNode(1);
        LListNode n2 = new LListNode(2);
        LListNode n3 = new LListNode(3);
        LListNode n4 = new LListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.print();

        reverse(n1).print();
    }
}
