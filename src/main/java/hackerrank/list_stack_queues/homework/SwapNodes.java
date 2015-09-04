package hackerrank.list_stack_queues.homework;

import java.io.IOException;

/**
 * In a given singly Linked List of length N, swap kth node from the beginning,
 * with kth node from the end. We are not swapping just the contents; we are swapping
 * the nodes themselves. 'k' is understood as base on 1, i.e. 1 <= k <= N
 * Approach:

 Find the length of the list, say it is ‘Len’.
 If k>Len, No Swapping.
 If kth node from the front and the end are same (k == (length + 1)/2), No Swapping.
 If above two steps are not true then we need swapping of the elements.
 Take a pointer left, move it by k nodes. Keep track of node prior to left( call it as left_prev, we need it for the swapping).
 Set left_prev = null if k=1.
 Take a pointer right, move it by len-k+1 nodes(it will be the kth node from the end). Keep track of node prior to left( call it as right_prev, we need it for the swapping).
 Set right_prev = null if k=Len.
 If left_prev!=NULL means left node is not the first node, so make left_prev will point to right
 If right_prev!=NULL means right node is not the first node, so right_prev will point to left node.
 Now just swap the next and right.next to complete the swapping.
 NOTE:We need to change the head of list if k =1 (head = right) or k = len (head = left).

 * Created by sharath on 8/31/15.
 */
public class SwapNodes {
    private static class LinkedListNode{
        int val;
        LinkedListNode next;
    }

    private static int getLength(LinkedListNode pList) {
        int length = 0;
        LinkedListNode curr = pList;
        while(curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }

    static LinkedListNode swapNodes(LinkedListNode pList, int k) {
        int length = getLength(pList);
        if(k > length || k == (length + 1)/2)
            return pList;

        LinkedListNode left = pList;
        LinkedListNode left_prev = null;
        // it's important to understand how this nodeCount maps to node as we are moving ahead.
        // make sure to take an example and write it down before getting into coding.
        int nodeCount = k;
        while (--nodeCount > 0) {
            left_prev = left;
            left = left.next;
        }

        LinkedListNode right = pList;
        LinkedListNode right_prev = null;
        nodeCount = length - k + 1;
        while(--nodeCount > 0) {
            right_prev = right;
            right = right.next;
        }

        if(left_prev != null) {
            left_prev.next = right;
        }

        if(right_prev != null) {
            right_prev.next = left;
        }

        LinkedListNode tmp = left.next;
        left.next = right.next;
        right.next = tmp;

        if(k == 1) {
            pList = right;
        }
        if(k == length) {
            pList = left;
        }

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
        n2.val = 2;
        n3.val = 4;
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
