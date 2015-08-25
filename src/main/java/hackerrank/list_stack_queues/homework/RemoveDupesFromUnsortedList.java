package hackerrank.list_stack_queues.homework;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharath on 8/24/15.
 */
public class RemoveDupesFromUnsortedList {
    private static class LinkedListNode{
        int val;
        LinkedListNode next;
    }

    public static LinkedListNode removeDupes(LinkedListNode first) {
        LinkedListNode prev = first;
        LinkedListNode curr = null;
        Set<Integer> lookUpStore = new HashSet<>();
        if(prev != null) {
            lookUpStore.add(prev.val);
            curr = prev.next;
        }
        
        while(curr != null) {
            if(!lookUpStore.contains(curr.val)) {
                lookUpStore.add(curr.val);
                curr = curr.next;
                prev = prev.next;
            } else {
                curr = curr.next;
                prev.next = curr;
            }
        }
        return first;
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

        n1.val = 2;
        n2.val = 5;
        n3.val = 7;
        n4.val = 2;
        n5.val = 4;
        n6.val = 7;
        n7.val = 9;
        n8.val = 0;

        LinkedListNode curr = removeDupes(n1);

        System.out.println("\nResult");

        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

    }
}
