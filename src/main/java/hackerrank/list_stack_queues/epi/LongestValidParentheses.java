package hackerrank.list_stack_queues.epi;

import java.util.Stack;

/**
 * Created by sharath on 8/22/15.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int maxLength = 0, end = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(stack.isEmpty()) {
                end = i;
            } else {
                stack.pop();
                int start = stack.isEmpty()? end : stack.peek();
                maxLength = Math.max(maxLength, i-start);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")(((())()(()(") == 6);
        System.out.println(longestValidParentheses("((())()(()(") == 6);
        System.out.println(longestValidParentheses(")(") == 0);
        System.out.println(longestValidParentheses("()") == 2);
        System.out.println(longestValidParentheses("") == 0);
        System.out.println(longestValidParentheses("()()())") == 6);
    }
}
