package c02_Linked_List.p2_7;

import c02_Linked_List.LinkedList.LinkedList;
import c02_Linked_List.LinkedList.Node;

import java.util.Stack;

/**
 * Created by sharath on 8/7/14.
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
        // This is the case of off numbered list
        // where slow has reached the middle element.
        // Just ignore the middle element by moving to next.
        if(fast != null && fast.next == null) {
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 2, 1});
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(list));
    }
}
