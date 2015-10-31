package hackerrank.arrays_strings_and_everything.epi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of objects with boolean keys, rearrange such that objects with 'false' key appear first.
 * Maintain the original order of objects with 'true' key.
 *
 * While it's tempting to define an object that has boolean key and an identifiable value, we could get away with
 * positive and negative integers as sample set and reduce the amount of code as we want to save time in an interview.
 *
 * Created by sharath on 10/30/15.
 */
public class DutchFlagVariant {
    private static void partition(List<Integer> A)
    {
        if(A.contains(0))
            throw new IllegalArgumentException("Zero is not accepted in the data set.");

        int i = A.size(), pivot = 0;

        for(int j = A.size() - 1; j >= 0; j--)
        {
            if(A.get(j) > pivot) {
                i--;
                if(i != j)
                    Collections.swap(A, i, j);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] entries = {-1, 3, -3, -2, 1, 8, 7, 4, -1, -1, 6};
        List<Integer> list = Arrays.asList(entries);
        System.out.println(list);
        partition(list);
        System.out.println(list);
    }
}
