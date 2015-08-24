package hackerrank.list_stack_queues.epi;


import java.util.Stack;

/**
 * Created by sharath on 8/23/15.
 */
public class SortedStack {
    private static Stack<Integer> S = new Stack<>();

    public static void sort() {
        if (!S.isEmpty()) {
            Integer e = S.pop();
            sort();
            S.push(e);
        }
    }

    public static void insert(Integer e) {
        if(S.isEmpty() || e.compareTo(S.peek()) < 0) {
            S.push(e);
        } else {
            Integer first = S.pop();
            insert(e);
            S.push(first);
        }
    }

    public static void top() {
        S.peek();
    }
}
