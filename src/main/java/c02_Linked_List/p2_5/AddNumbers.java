package c02_Linked_List.p2_5;

import c02_Linked_List.LinkedList.LinkedList;

/**
 * Created by sharath on 8/5/14.
 *
 * Problem description:
 * Add two numbers which are represented as number reversed linked lists
 */
public class AddNumbers {
    public LinkedList add(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        LinkedList reminder = new LinkedList();
        reminder.insertAtEnd(0);
        return result;
    }
    public static void main(String[] args) {
        // numbers are 60347365 and 87453 and sum should be 60434818
        // Result linked list would be [6] [0] [4] [3] [4] [8] [1] [8]
        LinkedList list1 = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6});
        LinkedList list2 =  new LinkedList(new int[]{3, 5, 4, 7, 8});
        list1.display();
        list2.display();
        new AddNumbers().add(list1, list2).display();
    }
}
