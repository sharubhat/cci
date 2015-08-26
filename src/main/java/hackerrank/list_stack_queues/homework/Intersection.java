package hackerrank.list_stack_queues.homework;

/**
 * Created by sharath on 8/25/15.
 */
public class Intersection {
    private static class LinkedListNode {
        int val;
        LinkedListNode next;
    }

    static int LinkedListIntersection(LinkedListNode inputList1, LinkedListNode inputList2) {
        int length1 = 0;
        int length2 = 0;

        LinkedListNode list1Iter = inputList1;
        LinkedListNode list2Iter = inputList2;

        while(list1Iter != null) {
            list1Iter = list1Iter.next;
            length1++;
        }

        while(list2Iter != null) {
            list2Iter = list2Iter.next;
            length2++;
        }

        boolean isL1Larger = length1 > length2;
        int diff = Math.abs(length1 - length2);
        list1Iter = inputList1;
        list2Iter = inputList2;
        if(isL1Larger) {
            while(diff-- > 0) {
                list1Iter = list1Iter.next;
            }
        } else {
            while(diff-- > 0) {
                list2Iter = list2Iter.next;
            }
        }

        boolean intersecting = false;
        int pointOfIntersection = -1;

        while(list1Iter != null) {
            if(list1Iter.val == list2Iter.val) {
                intersecting = true;
                if(pointOfIntersection == -1)
                    pointOfIntersection = list1Iter.val;
            } else {
                intersecting = false;
                pointOfIntersection = -1;
            }
            list1Iter = list1Iter.next;
            list2Iter = list2Iter.next;
        }
        if(intersecting)
            return pointOfIntersection;
        return -1;
    }
}
