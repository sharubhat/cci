package hackerrank.list_stack_queues.epi;

import java.util.Stack;

/**
 * Created by sharath on 8/22/15.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isWellFormed("()"));
        System.out.println(isWellFormed("()[]{}"));
        System.out.println(isWellFormed("[()[]]{}"));
        System.out.println(isWellFormed("(()[]{()[]{}{}})"));
        System.out.println(!isWellFormed("([)]"));
        System.out.println(!isWellFormed("["));
        System.out.println(!isWellFormed("(()[]{()[]{})({}})"));
        System.out.println(isWellFormed("( ( 1 + 2 ) * 3 )"));
    }

    private static boolean isWellFormed(String s) {
        Stack<Character> charStore = new Stack<>();
        for(int i = 0;i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['
                    || curr == ')' || curr == '}' || curr == ']') {
                if (curr == '(' || curr == '{' || curr == '[') {
                    charStore.push(curr);
                } else {
                    if (charStore.isEmpty())
                        return false;
                    char leftChar = charStore.pop();
                    if ((leftChar == '(' && curr != ')') ||
                            (leftChar == '{' && curr != '}') ||
                            (leftChar == '[' && curr != ']')) {
                        return false;
                    }
                }
            }
        }
        return charStore.isEmpty();
    }
}
