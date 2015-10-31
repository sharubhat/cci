package hackerrank.dynamic_programming.zenefits;

import java.util.*;


/**
 * K caterpillars are eating their way through N leaves, each caterpillar falls from leaf to leaf in a unique sequence,
 * all caterpillars start at a twig at position 0 and falls onto the leaves at position between 1 and N.
 * Each caterpillar j has as associated jump number Aj. A caterpillar with jump number j eats leaves at positions
 * that are multiple of j. It will proceed in the order j, 2j, 3j…. till it reaches the end of the leaves and
 * it stops and build its cocoon. Given a set A of K elements K<-15, N<=10^9,
 * we need to determine the number of uneaten leaves.

 Input:

 N = No of uneaten leaves
 K = No. of caterpillars
 A = Array of integer jump numbers
 Output:

 The integer nu. Of uneaten leaves

 Sample Input:

 10
 3
 2
 4
 5
 Output:

 4
 Explanation:

 [2, 4, 5] is a j member jump numbers, all leaves which are multiple of 2, 4, and 5 are eaten,
 leaves 1,3,7,9 are left, and thus the no. 4

 * Created by sharath on 10/12/15.
 */
public class UneatenLeaves {
    public static void main(String[] args) {
//        int n = 1000000000;
        int n = 10;
        int[] cat = {2,4,5};
        System.out.println(countUneatenLeaves(n, cat));
    }

    static int countUneatenLeaves(int N, int[] A) {
        BitSet leaves = new BitSet(N + 1);

        int leavesNotEaten = N;

        Set<Integer> cats = new HashSet<>();

        // remove dupes and jumps that are larger than number of leaves.
        for(int cat : A) {
            if(cat <= N)
                cats.add(cat);
        }

        System.out.println(cats);

        for (int jump : cats) {
            for (int i = 1; jump * i <= N; i++) {
                if (!leaves.get(jump * i)) {
                    leaves.set(jump * i);
                    leavesNotEaten--;
                }
            }
        }

        return leavesNotEaten;
    }
}
