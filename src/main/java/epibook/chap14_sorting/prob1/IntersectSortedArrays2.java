package epibook.chap14_sorting.prob1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sharath on 6/29/15.
 */
public class IntersectSortedArrays2 {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> a, List<Integer> b) {
        List<Integer> intersection = new ArrayList<>();
        for(int i = 0 ; i < a.size(); i++) {
            if((i == 0 || a.get(i) != a.get(i - 1)) &&
                    Collections.binarySearch(b, a.get(i)) > 0) {
                intersection.add(a.get(i));
            }
        }
        return intersection;
    }
}
