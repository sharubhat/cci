package hackerrank.list_stack_queues.epi;

/**
 * Reverse a single linked list.
 *
 * Created by sharath on 8/19/15.
 */
public class ReverseList {
    private static class Node {
        int data;
        Node next;
    }

    public static Node reverseR(Node first) {
        // no elements or one element, just return it
        if(first == null || first.next == null)
            return first;
        Node rest = first.next;
        // once the first node is disconnected, set it's next to null to avoid a loop.
        first.next = null;
        // reverse the rest
        Node reversed = reverseR(rest);
        // rest pointer is now pointing to last node in reversed. Connect first to rest pointer.
        rest.next = first;
        return reversed;
    }

    private static Node reverseI(Node first) {
        Node head = null;
        while(first != null) {
            Node tmp = first;
            first = first.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        n1.next = n2;
        n2.next = n3;

        n1.data = 2;
        n2.data = 5;
        n3.data = 7;

        Node res = reverseR(n1);

        Node curr = res;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
        res = reverseI(res);

        curr = res;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

}
