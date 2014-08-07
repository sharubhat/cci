package c02_Linked_List.p2_4;

import c02_Linked_List.LinkedList.LinkedList;
import c02_Linked_List.LinkedList.Node;

/**
 * Created by sharath on 8/4/14.
 *
 * Problem description:
 * Partition linked list around value x such that all nodes less than x comes before
 * and all nodes greater than or equal to x
 */
public class PartitionList {
    // This is probably the easiest solution give the way linkedlist is defined.
    // However, a better and complex way would be
    // to have start and end pointers for two lists and then merge them
    public LinkedList partition(LinkedList list, int i) {
        LinkedList lesser = new LinkedList();
        LinkedList greater = new LinkedList();
        LinkedList equal = new LinkedList();
        Node curr = list.head;
        while(curr != null) {
            if(curr.data == i)
                equal.insert(curr.data);
            else if(curr.data < i)
                lesser.insert(curr.data);
            else
                greater.insert(curr.data);
            curr = curr.next;
        }
        LinkedList result = new LinkedList();
        Node hi = greater.head;
        while(hi != null) {
            result.insert(hi.data);
            hi = hi.next;
        }
        Node eq = equal.head;
        while(eq != null) {
            result.insert(eq.data);
            eq = eq.next;
        }
        Node less = lesser.head;
        while(less != null) {
            result.insert(less.data);
            less = less.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6, 1, 0, 11, 3, 5, 4, 7, 8, 10});
        list.display();
        PartitionList partitionList = new PartitionList();
        LinkedList result = partitionList.partition(list, 6);
        result.display();
    }


}
