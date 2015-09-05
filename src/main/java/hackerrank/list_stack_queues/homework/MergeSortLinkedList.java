package hackerrank.list_stack_queues.homework;

/**
 * Sort a singly linked list using merge sort. Sort ascending.
 * Created by sharath on 8/23/15.
 */
public class MergeSortLinkedList {
    private static class LinkedListNode{
        int val;
        LinkedListNode next;
    }

    static LinkedListNode mergeSortList(LinkedListNode pList) {
        if(pList == null || pList.next == null)
            return pList;

        LinkedListNode slow = pList;
        LinkedListNode fast = pList;
        LinkedListNode slow_prev = null;
        while(fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode rightHalf = slow;
        slow_prev.next = null;
        LinkedListNode leftHalf = pList;

        LinkedListNode leftSorted = mergeSortList(leftHalf);
        LinkedListNode rightSorted = mergeSortList(rightHalf);
        LinkedListNode merged = merge(leftSorted, rightSorted);
        return merged;
    }

    private static LinkedListNode merge(LinkedListNode l, LinkedListNode r) {
        LinkedListNode emptypList = new LinkedListNode();
        LinkedListNode merged = emptypList;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                emptypList.next = l;
                l = l.next;

            } else {
                emptypList.next = r;
                r = r.next;
            }
            emptypList = emptypList.next;
        }

        if(l != null) {
            emptypList.next = l;
        }

        if(r != null) {
            emptypList.next = r;
        }

        return merged.next;
    }

    public static void main(String[] args) {
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

        n1.val = 11;
        n2.val = 2;
        n3.val = 4;
        n4.val = 1;
        n5.val = 1;
        n6.val = -99;
        n7.val = 0;
        n8.val = 2;

        LinkedListNode curr = mergeSortList(n1);

        System.out.println("\nResult");

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
