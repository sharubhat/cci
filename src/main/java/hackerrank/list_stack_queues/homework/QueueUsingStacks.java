package hackerrank.list_stack_queues.homework;

import java.util.Stack;

/**
 * Created by sharath on 8/25/15.
 */
public class QueueUsingStacks {
    private static class LinkedListNode {
        int val;
        LinkedListNode next;
    }

    static LinkedListNode ImplementQueue(LinkedListNode operationsList) {
        Stack<LinkedListNode> s1 = new Stack<>();
        Stack<LinkedListNode> s2 = new Stack<>();

        LinkedListNode result = null;
        LinkedListNode resultIter = null;

        while(operationsList != null) {
            LinkedListNode tmp = operationsList;
            operationsList = operationsList.next;
            tmp.next = null;
            if(tmp.val > 0) {
                enqueue(tmp, s1);
            } else {
                if(result == null) {
                    result = dequeue(s1, s2);
                    resultIter = result;
                }
                else {
                    resultIter.next = dequeue(s1, s2);
                    resultIter = resultIter.next;
                }
            }

        }
        return result;
    }

    private static LinkedListNode dequeue(Stack<LinkedListNode> s1, Stack<LinkedListNode> s2) {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if(!s2.isEmpty())
            return s2.pop();
        else {
            LinkedListNode tmp =  new LinkedListNode();
            tmp.val = -1;
            return tmp;
        }
    }

    private static void enqueue(LinkedListNode operationsList, Stack<LinkedListNode> s1) {
        s1.push(operationsList);
    }

    public static void main(String[] args) {
            LinkedListNode n1 = new LinkedListNode();
            LinkedListNode n2 = new LinkedListNode();
            LinkedListNode n3 = new LinkedListNode();
            LinkedListNode n4 = new LinkedListNode();
//            LinkedListNode n5 = new LinkedListNode();
//            LinkedListNode n6 = new LinkedListNode();
//            LinkedListNode n7 = new LinkedListNode();
//            LinkedListNode n8 = new LinkedListNode();

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
//            n4.next = n5;
//            n5.next = n6;
//            n6.next = n7;
//            n7.next = n8;

            n1.val = 1;
            n2.val = 2;
            n3.val = -1;
            n4.val = -1;
//            n5.val = 4;
//            n6.val = 1;
//            n7.val = 9;
//            n8.val = 0;

        ImplementQueue(n1);
    }
}
