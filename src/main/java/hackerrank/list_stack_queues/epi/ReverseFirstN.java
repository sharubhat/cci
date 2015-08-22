package hackerrank.list_stack_queues.epi;

/**
 * Reverses first N nodes and returns a new List.
 *
 * Created by sharath on 8/20/15.
 */
public class ReverseFirstN {
    private static class Node {
        int data;
        Node next;
    }

    public static Node reverseFirstN(Node oldHead, int revEnd) {
        int count = 0;
        Node curr = oldHead;
        Node reversed= null;
        while(curr != null && count < revEnd) {
            Node freeNode = curr;
            curr = curr.next;
            freeNode.next = reversed;
            reversed = freeNode;
            count++;
        }
        oldHead.next = curr;
        return reversed;
    }

    public static void main(String[] args) {
            Node n1 = new Node();
            Node n2 = new Node();
            Node n3 = new Node();
            Node n4 = new Node();
            Node n5 = new Node();

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;

            n1.data = 2;
            n2.data = 5;
            n3.data = 7;
            n4.data = 3;
            n5.data = 4;

            Node res = reverseFirstN(n1, 3);

            Node curr = res;
            while(curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
    }
}
