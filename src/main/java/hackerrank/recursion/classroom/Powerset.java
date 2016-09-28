package hackerrank.recursion.classroom;

import java.util.*;

/**
 * Power set is set of all subsets of S including empty set and S itself.
 *
 * Space complexity is O(2^n) as there are 2^n subsets.
 * Time complexity is O(n*2^n)
 *
 * Note: Set does not maintain the order, so it's not easy to use set class to build power set.
 * Convert the set to a list first.
 *
 * Created by sharath on 8/16/15.
 */
public class PowerSet {
    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        if (originalSet == null || originalSet.isEmpty()) {
            powerSet.add(new HashSet<>());  // Power set contains empty set.
            return powerSet;
        }
        List<Integer> list = new ArrayList<>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));
        // recursively call powerSet on rest of the set.
        Set<Set<Integer>> pSetRest = powerSet(rest);
        for (Set<Integer> set : pSetRest) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            powerSet.add(newSet);
            // unlike array permutations, we also need the sub-sets as part of power set, so add them
            powerSet.add(set);
        }
        return powerSet;
    }

    public static void main(String[] args) {
        Set<Integer> in = new HashSet<>();
        in.add(1);
        in.add(2);
        in.add(3);

        System.out.println(powerSet(in));
    }

}
