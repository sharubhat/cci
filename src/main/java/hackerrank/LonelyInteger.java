package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sharath on 2/11/15.
 */
public class LonelyInteger {
    static int lonelyInteger(int[] a) {
        Set<Integer> store = new HashSet<>();
        for(int i : a) {
            if(!store.add(i))
                store.remove(i);
        }
        return store.iterator().next();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyInteger(_a);
        System.out.println(res);

    }
}
