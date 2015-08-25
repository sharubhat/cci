package hackerrank.list_stack_queues.epi;

/**
 * Reverse sublist from start to finish, inclusive of finish
 * Created by sharath on 8/25/15.
 */
public class RevSublist {
    private static class Node {
        int data;
        Node next;
    }

    private static Node reverseSubListNtoM(Node L, int start, int finish) {
        if(start == finish)
            return L;

        Node subListHead = L;
        int k = 1;
        while(k++ < start) {
            subListHead = subListHead.next;
        }

        // Reverse the sublist in place
        Node subListIter = subListHead.next;
        while(++start < finish) {
            Node tmp = subListIter.next;
            subListIter.next = tmp.next;
            tmp.next = subListHead.next;
            subListHead.next = tmp;
        }
        return L;
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

        Node res = reverseSubListNtoM(n1, 1, 5);

        curr = res;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }


}
