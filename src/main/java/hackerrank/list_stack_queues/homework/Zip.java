package hackerrank.list_stack_queues.homework;

import java.io.*;

/**
 * Zip a linkedlist from two ends.
 * 1->2->3->4->5->6
 * Result 1->6->2->5->3->4
 * Created by sharath on 8/19/15.
 */
public class Zip {
    public static class LinkedListNode{
        int data;
        LinkedListNode next;
    }

    static LinkedListNode Zip(LinkedListNode pList) {
        LinkedListNode slow = pList;
        LinkedListNode fast = pList;
        LinkedListNode firstListEnd = pList;


        while(slow != null && fast != null && fast.next != null) {
            firstListEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // case of list with only one node
        if(firstListEnd == pList) {
            return pList;
        }
        firstListEnd.next = null;
        // Reverse the second half of the list
        slow = reverse(slow);

        LinkedListNode result = null;
        LinkedListNode curr = null;
        while(pList != null && slow != null) {
            // add pList entry
            if(result == null) {
                result = pList;
                curr = pList;
            } else {
                curr.next = pList;
                curr = curr.next;
            }
            pList = pList.next;
            // add slow entry
            curr.next = slow;
            slow = slow.next;
            curr = curr.next;
        }

        return result;
    }

    static LinkedListNode reverse(LinkedListNode first) {
        if(first == null || first.next == null)
            return first;
        LinkedListNode rest = first.next;
        LinkedListNode reversed = reverse(rest);
        first.next = null;
        rest.next = first;
        return reversed;
    }

    public static void main(String[] args) throws IOException {
        LinkedListNode n1 = new LinkedListNode();
        LinkedListNode n2 = new LinkedListNode();
        LinkedListNode n3 = new LinkedListNode();
        LinkedListNode n4 = new LinkedListNode();
        LinkedListNode n5 = new LinkedListNode();
        LinkedListNode n6 = new LinkedListNode();
        LinkedListNode n7 = new LinkedListNode();
        LinkedListNode n8 = new LinkedListNode();

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

        LinkedListNode curr = Zip(n1);

        System.out.println("\nResult");

        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }


        LinkedListNode k1 = new LinkedListNode();

        curr = Zip(k1);

        System.out.println("\nResult");

        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
