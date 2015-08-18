package epibook.chap14_sorting.prob1;

import java.util.*;

/**
 * Created by sharath on 6/29/15.
 */
public class IntersectSortedArrays1 {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> a, List<Integer> b) {
        List<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            // consider the first element or first non repeated element of the first array
            if (i == 0 || a.get(i) != a.get(i - 1)) {
                for (int k : b) {
                    if (a.get(i) == k) {
                        intersection.add(a.get(i));
                        // once a match is found in second array, break. If not, you may find it's repetitive.
                        break;
                    }
                }
            }
        }
        return intersection;
    }
}
