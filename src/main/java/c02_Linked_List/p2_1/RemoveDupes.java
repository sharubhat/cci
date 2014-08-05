package c02_Linked_List.p2_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharath on 8/3/14.
 * <p/>
 * Problem description:
 * Remove duplicates from unsorted linked list
 * <p/>
 * Questions to ask:
 * 1. Is this single linked list
 * 2. Can I use additional storage
 * Follow up question might be, remove without additional buffer
 */
public class RemoveDupes {
    public void removeDupes(LinkedList list) {
        Node prev = null;
        Node curr = list.head;
        if(curr == null)
            throw new IllegalArgumentException();
        Set<Integer> buffer = new HashSet<>();
        while (curr != null) {
            if (buffer.add(curr.data)) {
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
    }

    public void noBufferRemoveDupes(LinkedList list) {
        if(list.head == null)
            throw new IllegalArgumentException();
        Node curr = list.head;
        while(curr != null) {
            Node runner = curr;
            while(runner.next != null) {
                if(curr.data == runner.next.data) {
                    runner.next = runner.next.next;
                }
                else
                    runner = runner.next;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        RemoveDupes r = new RemoveDupes();
        LinkedList list = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6, 1, 0});
        list.display();
        r.removeDupes(list);
        list.display();


        list = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6, 1, 0});
        list.display();
        r.noBufferRemoveDupes(list);
        list.display();
    }
}
