package hackerrank.list_stack_queues.epi;

/**
 * Reverse K items at a time in a given linked list. If the last group of nodes are lesser than k, then leave them as is.
 * 1->2->3->4->5, k = 2 results in
 * 2->1->4->3->5
 *
 * Incorrect solution, needs to be fixed.
 *
 * Created by sharath on 8/20/15.
 */
public class ReverseKAtATime {
    private static class Node {
        int data;
        Node next;
    }

    public static Node reverseKAtATime(Node first, int k) {
        Node dummyHead = first,
                sublistPredecessor = dummyHead,
                sublistHead = dummyHead.next,
                sublistSuccessor = dummyHead,
                sublistTail = dummyHead.next;
        while (sublistHead != null) {
            int remaining = k;
            while (remaining > 0) {
                sublistSuccessor = sublistTail;
                sublistTail = sublistTail.next;
                --remaining;
                if (sublistTail == null) {
                    break;
                }
            }
            if (remaining > 0) {
                return dummyHead.next;
            }

            sublistSuccessor.next = null;
            // reverse linked list iteratively - sublistHead
            reverseI(sublistHead);

            // Splice the reversed sublist
            sublistPredecessor.next = sublistSuccessor;
            // go on to the head of next sublist
            sublistPredecessor = sublistHead;
            sublistHead.next = sublistTail;
            sublistSuccessor = null;

        }
        return dummyHead.next;
    }

    private static Node reverseI(Node first) {
        Node head = null;
        while (first != null) {
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
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        Node n8 = new Node();

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        n1.data = 2;
        n2.data = 5;
        n3.data = 7;
        n4.data = 3;
        n5.data = 4;
        n6.data = 1;
        n7.data = 9;
        n8.data = 0;

        Node curr = n1;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        Node res = reverseKAtATime(n1, 3);

        curr = res;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

}
