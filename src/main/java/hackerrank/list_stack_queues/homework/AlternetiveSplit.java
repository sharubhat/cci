package hackerrank.list_stack_queues.homework;

/**
 * Created by sharath on 8/24/15.
 */
public class AlternetiveSplit {
    private static class LinkedListNode{
        int val;
        LinkedListNode next;
    }

    static void alternativeSplit(LinkedListNode pList) {
        int count = 1;
        LinkedListNode oddList = null;
        LinkedListNode oddPointer = null;
        LinkedListNode evenList = null;
        LinkedListNode evenPointer = null;

        while(pList != null) {
            LinkedListNode tmp = pList;
            pList = pList.next;
            tmp.next = null;

            if(count % 2 == 1) {
                if(oddPointer == null && oddList == null) {
                    oddPointer = tmp;
                    oddList = tmp;
                } else {
                    oddPointer.next = tmp;
                    oddPointer = oddPointer.next;
                }
            } else {
                if(evenPointer == null && evenList == null) {
                    evenPointer = tmp;
                    evenList = tmp;
                } else {
                    evenPointer.next = tmp;
                    evenPointer = evenPointer.next;
                }
            }
            count++;
        }

        while(oddList != null) {
            if(oddList.next == null)
                System.out.println(oddList.val);
            else
                System.out.print(oddList.val + ",");
            oddList = oddList.next;
        }

        while(evenList != null) {
            if(evenList.next == null)
                System.out.println(evenList.val);
            else
                System.out.print(evenList.val + ",");
            evenList = evenList.next;
        }

    }
}
