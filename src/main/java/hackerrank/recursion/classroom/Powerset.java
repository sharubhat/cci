package hackerrank.recursion.classroom;

import java.util.*;

/**
 * Same as subsets. It's actually called as powerset.
 * Created by sharath on 8/16/15.
 */
public class Powerset {
    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<Integer> list = new ArrayList<>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public static void main(String[] args) {
        Set<Integer> in = new HashSet<>();
        in.add(1);
        in.add(2);
        in.add(3);

        System.out.println(powerSet(in));
    }

}
