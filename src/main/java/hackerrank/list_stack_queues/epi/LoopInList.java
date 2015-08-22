package hackerrank.list_stack_queues.epi;

/**
 * Created by sharath on 8/21/15.
 */
public class LoopInList {
    private static class Node {
        int data;
        Node next;
    }

    public static void checkLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                System.out.println("Loop exists in the given list");
                int loopLength = 0;
                do {
                    fast = fast.next;
                    loopLength++;
                } while(slow != fast);
                System.out.println("Length of the loop is " + loopLength);

                // finding the node at which cycle starts.
                // If L is length of loop, advance one pointer by L. Start another at the beginning.
                // They both will meet at a node which is beginning of the cycle.

                slow = head;
                fast = head;
                while(loopLength > 0) {
                    fast = fast.next;
                    loopLength--;
                }

                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                System.out.println("Cycle begins at node " + slow.data);
                break;
            }
        }
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
        n8.next = n4;

        n1.data = 2;
        n2.data = 5;
        n3.data = 7;
        n4.data = 3;
        n5.data = 4;
        n6.data = 1;
        n7.data = 9;
        n8.data = 0;

        checkLoop(n1);

    }
}
