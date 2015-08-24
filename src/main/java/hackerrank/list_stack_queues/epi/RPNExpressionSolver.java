package hackerrank.list_stack_queues.epi;

import java.util.Stack;

/**
 * Created by sharath on 8/22/15.
 */
public class RPNExpressionSolver {
    public static void main(String[] args) {
        System.out.println(0 == eval("2,-10,/"));
        System.out.println(-5 == eval("-10,2,/"));
        System.out.println(5 == eval("-10,-2,/"));
        System.out.println(-5 == eval("5,10,-"));
        System.out.println(6 == eval("-10,-16,-"));
        System.out.println(12 == eval("10,2,+"));
        System.out.println(15 == eval("1,2,+,3,4,*,+"));
        System.out.println(42 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+"));
        System.out.println(-6 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+,-7,/"));
    }

    public static int eval(String RPNExpression) {
        Stack<Integer> store = new Stack<>();
        String[] symbols = RPNExpression.split(",");
        for(String token : symbols) {
            if(token.length() == 1 && "+-*/".contains(token)) {
                int y = store.pop();
                int x = store.pop();
                switch (token) {
                    case "+" : store.push(x + y); break;
                    case "-" : store.push(x - y); break;
                    case "*" : store.push(x * y); break;
                    case "/" : store.push(x / y); break;
                    default : throw new IllegalArgumentException();
                }
            } else {
                store.push(Integer.parseInt(token));
            }
        }
        return store.pop();
    }
}
