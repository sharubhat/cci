package hackerrank.arrays_strings_and_everything;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * Problem Statement

 There are N integers in an array A. All but one integer occur in pairs. Your task is to find out the number that occurs only once.

 Input Format

 The first line of the input contains an integer N indicating the number of integers.
 The next line contains N space separated integers that form the array A.

 Constraints

 1 <= N < 100

 N % 2 = 1 ( N is an odd number )

 0 <= A[i] <= 100, ∀ i ∈ [1, N]

 Output Format

 Output S, the number that occurs only once.

 Sample Input:1

 1
 1

 Sample Output:1

 1

 Sample Input:2

 3
 1 1 2

 Sample Output:2

 2

 Sample Input:3

 5
 0 0 1 2 1

 Sample Output:3

 2

 Explanation

 In the first input, we see only one element and that element is the answer (1).
 In the second input, we see three elements, one is repeated twice (1); the element that occurs only once is 2.
 In the third input, we see five elements. 1 and 0 are repeated twice; the element that occurs only once is 2.


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
