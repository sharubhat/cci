package elements.of.programming.interviews;

/**
 * Created by sharath on 1/12/15.
 *
 * Problem 7.4
 *
 * Find if two lists are overlapping(merge at some point and have same rest of the nodes)
 *
 * Cases:
 * 1. Lists don't meet.
 * 2. Lists meet and have no loops.
 * 3. One of the list has a loop(implies they can't meet).
 * 4. Both lists have a loop and they meet.
 */
public class OverlappingLists_7_4 {
    public static ListNode<Integer> overlappingLists(ListNode<Integer> L1, ListNode<Integer> L2) {
        ListNode<Integer> head1 = CheckingCycle_7_2.hasCycle(L1);
        ListNode<Integer> head2 = CheckingCycle_7_2.hasCycle(L2);

        if(head1 == null && head2 == null) {
            // there are no cycles in the list
            return overlappingNoCycleLists(L1, L2);
        } else if(head1 == null && head2 != null ||
                head1 != null && head2 == null) {
            // one of the lists has cycle
            return null;
        }
        // both lists have cycle
        return overlappingCycleLists(L1, L2);
    }

    private static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        int l1Length = length(l1), l2length = length(l2);
        if(l1Length > l2length) {
            l1 = advanceListByN(l1, l1Length - l2length);
        }
        else if(l1Length < l2length) {
            l2 = advanceListByN(l2, l2length - l1Length);
        }
        // now the two lists must be of same length, begin comparison
        while(l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null ? l1 : l2;
    }

    private static ListNode<Integer> advanceListByN(ListNode<Integer> l, int i) {
        while(i-- > 0) {
            l = l.next;
        }
        return l;
    }

    private static int length(ListNode<Integer> listNode) {
        ListNode<Integer> head = listNode;
        int length = 0;
        while(head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


    private static ListNode<Integer> overlappingCycleLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        return null;
    }
}
