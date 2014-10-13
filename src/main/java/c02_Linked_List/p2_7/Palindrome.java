package c02_Linked_List.p2_7;

import c02_Linked_List.LinkedList.LinkedList;
import c02_Linked_List.LinkedList.Node;

import java.util.Stack;

/**
 * Created by sharath on 8/7/14.
 *
 * Problem description:
 * Check if the given link is a palindrome
 *
 */
public class Palindrome {
    public boolean isPalindrome(LinkedList list) {
        if(list.isEmpty())
            return true;
        Stack<Node> buffer  = new Stack<>();
        Node slow = list.head;
        Node fast = list.head;
        while(fast != null && fast.next != null) {
            buffer.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        // This is the case of odd numbered list
        // where slow has reached the middle element.
        // Just ignore the middle element by moving to next.
        if(fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            Node node = buffer.pop();
            if(node.data != slow.data)
                return false;
            slow = slow.next;
        }
        return true;
    }
}
