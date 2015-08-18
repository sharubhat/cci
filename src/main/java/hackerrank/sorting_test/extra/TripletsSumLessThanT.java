package hackerrank.sorting_test.extra;


import java.util.*;

/**
 * Created by sharath on 8/13/15.
 */
public class TripletsSumLessThanT {

    public static void main(String[] args) {
        int in[] = {1,2,3,4,6};

        System.out.println(triplets(8, in));
    }

    static int triplets(int t, int[] d) {
        HashMap<Integer, HashSet<Integer>> store = new HashMap<>();
        HashSet<HashSet<Integer>> res = new HashSet<>();

        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d.length; j++) {
                HashSet<Integer> set = new HashSet<>();
                set.add(d[i]);
                set.add(d[j]);
                store.put(d[j] + d[j] , set);
            }
        }

        for(int i = 0; i < d.length; i++) {
            for (Map.Entry<Integer, HashSet<Integer>> e : store.entrySet()) {
                if (e.getKey() <= (t - d[i])) {
                    HashSet<Integer> newSet = new HashSet<>(e.getValue());
                    newSet.add(d[i]);
                    res.add(newSet);
                }
            }
        }

        return res.size();

    }

}
