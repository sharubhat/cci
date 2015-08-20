package hackerrank.list_stack_queues.epi;

/**
 * Created by sharath on 8/19/15.
 */
public class MergeSortedDList {
    private static class DNode {
        int data;
        DNode prev;
        DNode next;
    }
    
    public static DNode merge(DNode first, DNode second) {
        DNode result = null, curr = null;
        while(first != null && second != null) {
            if(first.data <= second.data) {
                if(result == null) {
                    result = first;
                    curr = result;
                    first = first.next;
                } else {
                    DNode tmp = first;
                    first = first.next;
                    curr.next = tmp;
                    tmp.prev = curr;
                    curr = curr.next;
                }
            } else {
                if(result == null) {
                    result = second;
                    curr = result;
                    second = second.next;
                } else {
                    DNode tmp = second;
                    second = second.next;
                    curr.next = tmp;
                    tmp.prev = curr;
                    curr = curr.next;
                }
            }
        }

        if(first != null) {
            curr.next = first;
            first.prev = curr;
        }

        if(second != null) {
            curr.next = second;
            second.prev = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        DNode n1 = new DNode();
        DNode n2 = new DNode();
        DNode n3 = new DNode();
        DNode n4 = new DNode();
        DNode n5 = new DNode();

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;

        n2.prev = n1;
        n3.prev = n2;
        n5.prev = n4;

        n1.data = 2;
        n2.data = 5;
        n3.data = 7;
        n4.data = 3;
        n5.data = 11;

        DNode res = merge(n1, n4);

        // making sure I can print it both ways.
        while(res.next != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }

        System.out.println(res.data);

        while(res != null) {
            System.out.print(res.data + " ");
            res = res.prev;
        }
    }
}
