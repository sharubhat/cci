package elements.of.programming.interviews;

/**
 * Created by sharath on 1/12/15.
 *
 * Problem 7.2
 */
public class CheckingCycle_7_2 {
    public static ListNode<Integer> hasCycle(ListNode<Integer> list) {
        ListNode<Integer> slow = list, fast = list;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                // There is a cycle, calculating the cycle length
                int cyclelen = 0;
                do {
                    ++cyclelen;
                    fast = fast.next;
                } while(slow != fast);

                // find the start of the cycle
                fast = list;
                slow = list;
                // fast forward 'fast' pointer by cyclelen
                while(cyclelen-- > 0) {
                    fast = fast.next;
                }
                // now move 'slow' and 'fast' by one node at a time
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // slow points to beginning of the cycle
            }
        }

        // there is no cycle
        return null;
    }

    public static void main(String[] args) {
        ListNode<Integer> l3 = new ListNode<>(3, null);
        ListNode<Integer> l2 = new ListNode<>(2, l3);
        ListNode<Integer> l1 = new ListNode<>(1, l2);

        // should output "l1 does not have cycle."
        assert (hasCycle(l1) == null);
        System.out.println("l1 " + (hasCycle(l1) != null ? "has" : "does not have")
                + " cycle.");

        // make it a cycle
        l3.next = l2;
        // should output "l1 has cycle, located at node has value 2"
        assert (hasCycle(l1) != null);
        assert (hasCycle(l1).data == 2);
        ListNode<Integer> temp = hasCycle(l1);
        if (temp != null) {
            System.out
                    .println("l1 has cycle, located at node has value " + temp.data);
        } else {
            System.out.println("l1 does not have cycle");
        }
    }
}
