package hackerrank.list_stack_queues.epi;

import java.util.Stack;

/**
 * Either reverse second half and compare with first half or use an additional ds.
 * Created by sharath on 8/25/15.
 */
public class Palindrome {
    private static class Node<E> {
        E data;
        Node<E> next;
    }

    public static <T extends Comparable> boolean checkPalindrome(Node<T> begin) {
        Node<T> slow = begin;
        Node<T> fast = begin;

        int count = 0;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        Stack<T> stack = new Stack<T>();
        while(slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        slow = begin;
        while(count-- > 0 && !stack.isEmpty()) {
            if(slow.data.compareTo(stack.pop()) != 0) {
                return false;
            }
            slow = slow.next;
        }

        if(count == 0)
            return true;
        return false;
    }
}
