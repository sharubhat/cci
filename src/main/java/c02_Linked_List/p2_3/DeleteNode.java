package c02_Linked_List.p2_3;

import c02_Linked_List.LinkedList.LinkedList;
import c02_Linked_List.LinkedList.Node;

/**
 * Created by sharath on 8/4/14.
 *
 * Problem description:
 * Delete a node given access to only that node
 */
public class DeleteNode {
    public void deleteNode(Node curr) {
        Node next = curr.next;
        curr.data = next.data;
        curr.next = next.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6, 1, 0, 11, 3, 5, 4, 7, 8, 10});
        list.display();
        Node node = list.head.next.next.next.next;
        DeleteNode d = new DeleteNode();
        d.deleteNode(node);
        list.display();
    }
}
