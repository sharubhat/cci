package hackerrank.list_stack_queues.homework;

import java.io.IOException;

/**
 * Created by sharath on 8/24/15.
 */
public class SwapKth {
    private static class LinkedListNode{
        int val;
        LinkedListNode next;
    }

    static LinkedListNode swapNodes(LinkedListNode pList, int iK) {
        LinkedListNode curr = pList;
        int numNodes = 0;
        while(curr != null) {
            numNodes++;
            curr = curr.next;
        }
        if(numNodes % 2 == 0 && iK == numNodes/2)
            return pList;
        else if(numNodes % 2 != 0 && iK == (numNodes/2 + 1))
            return pList;
        else if(iK > numNodes/2)
            iK = numNodes - iK;

        LinkedListNode kBeginPrev = null, kBeginNext = null, kBegin = null;
        LinkedListNode kEndPrev = null, kEndNext = null, kEnd = null;
        curr = pList;

        int count = 0;

        while(curr != null && count < iK) {
            kBeginPrev = curr;
            curr = curr.next;
            kBegin = curr;
            count++;
        }

        kBeginNext = kBegin.next;

        LinkedListNode slow = pList;
        LinkedListNode fast = kBeginNext;

        count = 1;
        while(fast != null && count < iK) {
            kEndPrev = slow;
            slow = slow.next;
            kEnd = slow;
            fast = fast.next;
            count++;
        }

        kEndNext = slow.next;

        kBeginPrev.next = kEnd;
        kEnd.next = kBeginNext;
        kEndPrev.next = kBegin;
        kBegin.next = kEndNext;

        return pList;
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
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;

        n1.val = 11;
        n2.val = 4;
        n3.val = 2;
        n4.val = 1;
//        n5.val = 1;
//        n6.val = -99;
//        n7.val = 0;
//        n8.val = 2;

        LinkedListNode curr = swapNodes(n1, 3);

        System.out.println("\nResult");

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
