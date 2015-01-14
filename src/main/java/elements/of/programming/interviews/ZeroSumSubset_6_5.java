package elements.of.programming.interviews;

import java.util.*;

/**
 * Created by sharath on 1/7/15.
 *
 * Problem 6.5
 *
 * 0 mod n-sum subset problem means, find a subset of an array such that (sum(elements of subset) % size(original array)) = 0
 *
 * Assuming here that you are fine with any (non-trivial) subset such that its sum is 0 mod n
 * i.e. we are not looking for the largest subset or the smallest subset etc.
 * Also, one more assumption is that the numbers given to you are integers.
 * Under the above assumptions, there is a linear time algorithm to find this subset.
 * This is a classic problem from Discrete Mathematics.
 * Consider the following sums: a_1, a_1 + a_2, a_1 + a_2 + a_3, ..., a_1 + a_2 + ... + a_n.
 * By pigeonhole principle, either one of these sums is exactly 0 mod n or two of these sums have the same remainder mod n.
 * Hence, their difference will be 0 mod n.
 *
 * This can be translated into a linear time algorithm which computes the sums:
 * a_1, a_1 + a_2, a_1 + a_2 + a_3, ..., a_1 + a_2 + ... + a_n.
 * Also, at the same time computes their remainder modulo n.
 * Then, amongst the remainders we search for 0 or two identical remainders. All of these can be done in linear time.
 */
public class ZeroSumSubset_6_5 {
    public static List<Integer> find0SumSubset(List<Integer> A) {
        List<Integer> modList = new ArrayList<>(A);
        for(int i = 0; i < A.size(); i++) {
            // Ideally you may want to maintain two lists one for the sums and other for the mods/remainders
            // However, since all you care about is the remainder which is again the last digit of the sum,
            // you may anyhow replace the sum with remainder itself
            // e.g : consider list of {429, 334, 62}
            // sumList will be 429, 763, 825
            // modList will be 9, 3, 5
            // what happens here is 9, 9 + 334 -> 3, 3 + 62 -> 5
            modList.set(i, modList.get(i) + (i > 0 ? modList.get(i - 1) : 0));
            modList.set(i, modList.get(i) % A.size());
        }

        List<Integer> table = new ArrayList<>(A.size());
        for(int i = 0; i < A.size(); i++) {
            table.add(-1);
        }

        // The only way to come to solving this loop is to take an example and solve it by hand
        for(int i = 0; i < A.size(); i++) {
            if(table.get(modList.get(i)) == -1) {
                table.set(modList.get(i), i);
            }
            else {
                return listFromTo(table.get(modList.get(i)) + 1, i + 1);
            }

        }
        return Collections.emptyList();
    }

    private static List<Integer> listFromTo(int start, int end) {
        List<Integer> list = new ArrayList<>(end - start);
        for( int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }

    private static boolean checkAns(List<Integer> A, List<Integer> ans) {
        int sum = 0;
        System.out.println(A.toString());
        System.out.println(ans.toString());
        for(int i : ans) {
            sum = (sum + A.get(i)) % A.size();
        }
        return sum == 0;
    }
    public static void main(String[] args) {
//        int[] A = {429, 334, 62, 711, 704, 763, 98, 733, 721, 995};
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 0; i < A.length; i++) {
//            list.add(A[i]);
//        }
//        System.out.println(checkAns(list, find0SumSubset(list)));

        Random gen = new Random();
        for (int times = 0; times < 20; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.valueOf(args[0]);
            } else {
                n = gen.nextInt(20) + 1;
            }
            int[] A = new int[n];
            for (int i = 0; i < n; ++i) {
                A[i] = nextPositiveInt(gen, n);
            }

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < A.length; i++) {
                list.add(A[i]);
            }
            System.out.println(checkAns(list, find0SumSubset(list)));
        }
    }

    private static Integer nextPositiveInt(Random random, int maxValue) {
        int next = random.nextInt(maxValue);
        return next == Integer.MIN_VALUE ? Integer.MAX_VALUE : next;
    }
}
