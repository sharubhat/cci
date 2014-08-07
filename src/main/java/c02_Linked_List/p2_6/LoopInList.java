package c02_Linked_List.p2_6;

import c02_Linked_List.LinkedList.LinkedList;
import c02_Linked_List.LinkedList.Node;

/**
 * Created by sharath on 8/6/14.
 *
 * Problem description:
 * Given a linked list, check if it has a loop
 * Return the node at the beginning of the loop
 *
 * Complexity is O(n)
 */
public class LoopInList {
    public boolean hasLoop(LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
        //list.head.next.next.next.next.next.next = list.head.next.next.next;
        System.out.println(new LoopInList().hasLoop(new LinkedList()));
    }
}
