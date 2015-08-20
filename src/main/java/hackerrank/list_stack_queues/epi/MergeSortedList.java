package hackerrank.list_stack_queues.epi;

/**
 * Merge two sorted lists.
 *
 * Created by sharath on 8/19/15.
 */
public class MergeSortedList {
    private static class Node {
        int data;
        Node next;
    }

    public static Node merge(Node first, Node second) {
        Node result = null, curr = null;
        while(first != null && second != null) {
            if(first.data <= second.data) {
                if(result == null) {
                    result = first;
                    curr = result;
                } else {
                    curr.next = first;
                    curr = curr.next;
                }
                first = first.next;
            } else {
                if(result == null) {
                    result = second;
                    curr = result;
                } else {
                    curr.next = second;
                    curr = curr.next;
                }
                second = second.next;
            }
        }

        if(first != null) {
            curr.next = first;
        }

        if(second != null) {
            curr.next = second;
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;

        n1.data = 2;
        n2.data = 5;
        n3.data = 7;
        n4.data = 3;
        n5.data = 11;

        Node res = merge(n1, n4);

        while(res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}
