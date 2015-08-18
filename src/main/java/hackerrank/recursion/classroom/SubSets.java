package hackerrank.recursion.classroom;

import java.util.ArrayList;

/**
 * Print all subsets of a set.
 *
 * Created by sharath on 8/14/15.
 */
public class SubSets {
    public static void main(String[] args) {
        ArrayList<Character> in = new ArrayList<>();
        in.add('a');
        in.add('b');
        in.add('c');

        System.out.println(getSubsets(in, 0));
    }

    private static ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set, int n) {
        ArrayList<ArrayList<Character>> allSubsets;
        if(set.size() == n) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {

            allSubsets = getSubsets(set, n + 1);

            char item = set.get(n);

            ArrayList<ArrayList<Character>> moreSubsets = new ArrayList<>();
            for (ArrayList<Character> subset : allSubsets) {
                ArrayList<Character> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

}
