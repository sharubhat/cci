package c02_Linked_List.p2_2;

import c02_Linked_List.LinkedList.LinkedList;
import c02_Linked_List.LinkedList.Node;

/**
 * Created by sharath on 8/4/14.
 *
 * Problem description:
 * Find last k elements of the list
 *
 * Questions to ask:
 * 1. Should I just print the nodes or return the LinkedList
 */
public class KthToLast {
    public Node kthToLast(LinkedList list, int k) {
        if (k < 0 || list.isEmpty())
            return null;
        Node runner = list.head;
        for (int i = 0; i < k; i++) {
            runner = runner.next;
        }
        Node current = list.head;

        while (runner != null) {
            runner = runner.next;
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        KthToLast kthToLast = new KthToLast();
        LinkedList list = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6, 1, 0, 11, 3, 5, 4, 7, 8, 10});
        list.display();
        kthToLast.kthToLast(list, 5).display();
    }
}
