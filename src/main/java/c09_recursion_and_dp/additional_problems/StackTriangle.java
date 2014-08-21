package c09_recursion_and_dp.additional_problems;

import java.util.Stack;

/**
 * Created by sharath on 8/20/14.
 *
 * Solving triangular numbers problem using stack instead of recursion
 */
public class StackTriangle {

    public int nthNumber(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("Only positive numbers are accepted.");
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        while(n > 0) {
            stack.push(n--);
        }
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            result += tmp;
        }
        return result;
    }
}
