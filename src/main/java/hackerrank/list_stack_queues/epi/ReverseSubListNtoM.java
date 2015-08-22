package hackerrank.list_stack_queues.epi;

/**
 * Created by sharath on 8/20/15.
 */
public class ReverseSubListNtoM {
    private static class Node {
        int data;
        Node next;
    }

    private static Node reverseSubListNtoM(Node node, int n, int m) {
        Node firstEnd = null;
        Node curr = node;
        int counter = 1;
        while(curr != null && counter < n) {
            firstEnd = curr;
            curr = curr.next;
            counter++;
        }
        firstEnd.next = reverseFirstN(curr, (m - n) + 1);
        return node;
    }

    public static Node reverseFirstN(Node oldHead, int revEnd) {
        int count = 1;
        Node curr = oldHead;
        Node reversed= null;
        while(curr != null && count <= revEnd) {
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

        Node res = reverseSubListNtoM(n1, 3, 5);

        curr = res;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
